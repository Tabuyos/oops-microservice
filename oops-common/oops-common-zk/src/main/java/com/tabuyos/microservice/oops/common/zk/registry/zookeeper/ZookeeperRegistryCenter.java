package com.tabuyos.microservice.oops.common.zk.registry.zookeeper;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import com.tabuyos.microservice.oops.common.config.properties.ZookeeperProperties;
import com.tabuyos.microservice.oops.common.zk.registry.base.CoordinatorRegistryCenter;
import com.tabuyos.microservice.oops.common.zk.registry.base.ReliableMessageRegisterDto;
import com.tabuyos.microservice.oops.common.zk.registry.exception.RegExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry.zookeeper</i>
 *   <b>class: </b><i>ZookeeperRegistryCenter</i>
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 * <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 * <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 * <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 1:59 PM
 */
public class ZookeeperRegistryCenter implements CoordinatorRegistryCenter {

  private final static Logger log = LoggerFactory.getLogger(ZookeeperRegistryCenter.class);

  private ZookeeperProperties zkConfig;

  private final Map<String, CuratorCache> caches = new HashMap<>();

  private CuratorFramework client;
  private DistributedAtomicInteger distributedAtomicInteger;

  /**
   * Instantiates a new Zookeeper registry center.
   *
   * @param zkConfig the zk config
   */
  public ZookeeperRegistryCenter(final ZookeeperProperties zkConfig) {
    this.zkConfig = zkConfig;
  }

  public ZookeeperProperties getZkConfig() {
    return zkConfig;
  }

  public void setZkConfig(ZookeeperProperties zkConfig) {
    this.zkConfig = zkConfig;
  }

  public Map<String, CuratorCache> getCaches() {
    return caches;
  }

  public CuratorFramework getClient() {
    return client;
  }

  public void setClient(CuratorFramework client) {
    this.client = client;
  }

  public DistributedAtomicInteger getDistributedAtomicInteger() {
    return distributedAtomicInteger;
  }

  public void setDistributedAtomicInteger(DistributedAtomicInteger distributedAtomicInteger) {
    this.distributedAtomicInteger = distributedAtomicInteger;
  }

  /**
   * Init.
   */
  @Override
  public void init() {
    log.debug("Elastic job: zookeeper registry center init, server lists is: {}.", zkConfig.getZkAddressList());
    CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
      .connectString(zkConfig.getZkAddressList())
      .retryPolicy(new ExponentialBackoffRetry(zkConfig.getBaseSleepTimeMilliseconds(), zkConfig.getMaxRetries(), zkConfig.getMaxSleepTimeMilliseconds()));
    if (0 != zkConfig.getSessionTimeoutMilliseconds()) {
      builder.sessionTimeoutMs(zkConfig.getSessionTimeoutMilliseconds());
    }
    if (0 != zkConfig.getConnectionTimeoutMilliseconds()) {
      builder.connectionTimeoutMs(zkConfig.getConnectionTimeoutMilliseconds());
    }
    if (!Strings.isNullOrEmpty(zkConfig.getDigest())) {
      builder.authorization("digest", zkConfig.getDigest().getBytes(Charsets.UTF_8))
        .aclProvider(new ACLProvider() {

          @Override
          public List<ACL> getDefaultAcl() {
            return ZooDefs.Ids.CREATOR_ALL_ACL;
          }

          @Override
          public List<ACL> getAclForPath(final String path) {
            return ZooDefs.Ids.CREATOR_ALL_ACL;
          }
        });
    }
    client = builder.build();
    client.start();
    try {
      if (!client.blockUntilConnected(zkConfig.getMaxSleepTimeMilliseconds() * zkConfig.getMaxRetries(), TimeUnit.MILLISECONDS)) {
        client.close();
        throw new KeeperException.OperationTimeoutException();
      }

      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Close.
   */
  @Override
  public void close() {
    for (Map.Entry<String, CuratorCache> each : caches.entrySet()) {
      each.getValue().close();
    }
    waitForCacheClose();
    CloseableUtils.closeQuietly(client);
  }

  /**
   * 等待500ms, cache先关闭再关闭client, 否则会抛异常
   * 因为异步处理, 可能会导致client先关闭而cache还未关闭结束.
   * 等待Curator新版本解决这个bug.
   * BUG地址：https://issues.apache.org/jira/browse/CURATOR-157
   */
  private void waitForCacheClose() {
    try {
      Thread.sleep(500L);
    } catch (final InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Get string.
   *
   * @param key the key
   *
   * @return the string
   */
  @Override
  public String get(final String key) {
    CuratorCache cache = findCuratorCache(key);
    if (null == cache) {
      return getDirectly(key);
    }
    ChildData resultInCache = cache.get(key).orElse(null);
    if (null != resultInCache) {
      return null == resultInCache.getData() ? null : new String(resultInCache.getData(), Charsets.UTF_8);
    }
    return getDirectly(key);
  }

  private CuratorCache findCuratorCache(final String key) {
    for (Map.Entry<String, CuratorCache> entry : caches.entrySet()) {
      if (key.startsWith(entry.getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

  /**
   * Gets directly.
   *
   * @param key the key
   *
   * @return the directly
   */
  @Override
  public String getDirectly(final String key) {
    try {
      return new String(client.getData().forPath(key), Charsets.UTF_8);
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
      return null;
    }
  }

  /**
   * Gets children keys.
   *
   * @param key the key
   *
   * @return the children keys
   */
  @Override
  public List<String> getChildrenKeys(final String key) {
    try {
      List<String> result = client.getChildren().forPath(key);
      result.sort(Comparator.reverseOrder());
      return result;
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
      return Collections.emptyList();
    }
  }

  /**
   * Gets num children.
   *
   * @param key the key
   *
   * @return the num children
   */
  @Override
  public int getNumChildren(final String key) {
    Stat stat = null;
    try {
      stat = client.checkExists().forPath(key);
    } catch (final Exception ex) {
      RegExceptionHandler.handleException(ex);
    }
    return stat == null ? 0 : stat.getNumChildren();
  }

  /**
   * Is existed boolean.
   *
   * @param key the key
   *
   * @return the boolean
   */
  @Override
  public boolean isExisted(final String key) {
    try {
      return null != client.checkExists().forPath(key);
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
      return false;
    }
  }

  /**
   * Persist.
   *
   * @param key   the key
   * @param value the value
   */
  @Override
  public void persist(final String key, final String value) {
    try {
      if (!isExisted(key)) {
        if (null == value) {
          client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(key);
        } else {
          client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(key, value.getBytes(Charsets.UTF_8));
        }
      } else {
        if (null != value) {
          update(key, value);
        }
      }
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Persist.
   *
   * @param key the key
   */
  @Override
  public void persist(String key) {
    this.persist(key, null);
  }

  /**
   * Update.
   *
   * @param key   the key
   * @param value the value
   */
  @Override
  public void update(final String key, final String value) {
    try {
      CuratorOp checkOp = client.transactionOp()
                                  .check()
                                  .forPath(key);
      CuratorOp setDataOp = client.transactionOp()
                                  .setData()
                                  .forPath(key, value.getBytes(Charsets.UTF_8));
      client.transaction().forOperations(checkOp, setDataOp);
//      client.inTransaction().check().forPath(key).and().setData().forPath(key, value.getBytes(Charsets.UTF_8)).and().commit();
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Persist ephemeral.
   *
   * @param key   the key
   * @param value the value
   */
  @Override
  public void persistEphemeral(final String key, final String value) {
    try {
      if (isExisted(key)) {
        client.delete().deletingChildrenIfNeeded().forPath(key);
      }
      client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(key, value.getBytes(Charsets.UTF_8));
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Persist sequential string.
   *
   * @param key   the key
   * @param value the value
   *
   * @return the string
   */
  @Override
  public String persistSequential(final String key, final String value) {
    try {
      return client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath(key, value.getBytes(Charsets.UTF_8));
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
    return null;
  }

  /**
   * Persist ephemeral sequential.
   *
   * @param key the key
   */
  @Override
  public void persistEphemeralSequential(final String key) {
    try {
      client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(key);
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Remove.
   *
   * @param key the key
   */
  @Override
  public void remove(final String key) {
    try {
      client.delete().deletingChildrenIfNeeded().forPath(key);
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
  }

  /**
   * Gets registry center time.
   *
   * @param key the key
   *
   * @return the registry center time
   */
  @Override
  public long getRegistryCenterTime(final String key) {
    long result = 0L;
    try {
      persist(key, "");
      result = client.checkExists().forPath(key).getMtime();
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
    Preconditions.checkState(0L != result, "Cannot get registry center time.");
    return result;
  }

  /**
   * Gets raw client.
   *
   * @return the raw client
   */
  @Override
  public Object getRawClient() {
    return client;
  }

  /**
   * Increment.
   *
   * @param path        the path
   * @param retryNTimes the retry n times
   */
  @Override
  public void increment(String path, RetryNTimes retryNTimes) {
    try {
      distributedAtomicInteger = new DistributedAtomicInteger(client, path, retryNTimes);
      distributedAtomicInteger.increment();
    } catch (Exception e) {
      log.error("increment={}", e.getMessage(), e);
    }
  }

  /**
   * Gets atomic value.
   *
   * @param path        the path
   * @param retryNTimes the retry n times
   *
   * @return the atomic value
   */
  @Override
  public AtomicValue<Integer> getAtomicValue(String path, RetryNTimes retryNTimes) {
    try {
      distributedAtomicInteger = new DistributedAtomicInteger(client, path, retryNTimes);
      return distributedAtomicInteger.get();
    } catch (Exception e) {
      log.error("getAtomicValue={}", e.getMessage(), e);
    }
    return null;
  }

  /**
   * Add cache data.
   *
   * @param cachePath the cache path
   */
  @Override
  public void addCacheData(final String cachePath) {
    CuratorCache cache = CuratorCache.builder(client, cachePath).build();
    try {
      cache.start();
      //CHECKSTYLE:OFF
    } catch (final Exception ex) {
      //CHECKSTYLE:ON
      RegExceptionHandler.handleException(ex);
    }
    caches.put(cachePath + "/", cache);
  }

  /**
   * Evict cache data.
   *
   * @param cachePath the cache path
   */
  @Override
  public void evictCacheData(final String cachePath) {
    CuratorCache cache = caches.remove(cachePath + "/");
    if (null != cache) {
      cache.close();
    }
  }

  /**
   * Gets raw cache.
   *
   * @param cachePath the cache path
   *
   * @return the raw cache
   */
  @Override
  public Object getRawCache(final String cachePath) {
    return caches.get(cachePath + "/");
  }

  /**
   * Register mq.
   *
   * @param app           the app
   * @param host          the host
   * @param producerGroup the producer group
   * @param consumerGroup the consumer group
   * @param namesrvAddr   the namesrv addr
   */
  @Override
  public void registerMq(final String app, final String host, final String producerGroup, final String consumerGroup, String namesrvAddr) {
    // 注册生产者
    final String producerRootPath = GlobalConstant.ZK_REGISTRY_PRODUCER_ROOT_PATH + GlobalConstant.Symbol.SLASH + app;
    final String consumerRootPath = GlobalConstant.ZK_REGISTRY_CONSUMER_ROOT_PATH + GlobalConstant.Symbol.SLASH + app;
    ReliableMessageRegisterDto dto;
    if (StringUtils.isNotEmpty(producerGroup)) {
      dto = new ReliableMessageRegisterDto().setProducerGroup(producerGroup).setNamesrvAddr(namesrvAddr);
      String producerJson = JSON.toJSONString(dto);
      this.persist(producerRootPath, producerJson);
      this.persistEphemeral(producerRootPath + GlobalConstant.Symbol.SLASH + host, DateUtil.now());
    }
    // 注册消费者
    if (StringUtils.isNotEmpty(consumerGroup)) {
      dto = new ReliableMessageRegisterDto().setConsumerGroup(consumerGroup).setNamesrvAddr(namesrvAddr);
      String producerJson = JSON.toJSONString(dto);
      this.persist(consumerRootPath, producerJson);
      this.persistEphemeral(consumerRootPath + GlobalConstant.Symbol.SLASH + host, DateUtil.now());
    }

  }
}
