package com.tabuyos.microservice.oops.common.zk.registry;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.google.common.base.Charsets;
import com.tabuyos.microservice.oops.common.config.properties.AliyunProperties;
import com.tabuyos.microservice.oops.common.config.properties.OopsProperties;
import com.tabuyos.microservice.oops.common.config.properties.ZookeeperProperties;
import com.tabuyos.microservice.oops.common.zk.generator.IncrementIdGenerator;
import com.tabuyos.microservice.oops.common.zk.registry.base.CoordinatorRegistryCenter;
import com.tabuyos.microservice.oops.common.zk.registry.base.RegisterDto;
import com.tabuyos.microservice.oops.common.zk.registry.zookeeper.ZookeeperRegistryCenter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry</i>
 *   <b>class: </b><i>RegistryCenterFactory</i>
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
 * @since 0.1.0 - 2/22/21 2:02 PM
 */
public final class RegistryCenterFactory {


  private static final ConcurrentHashMap<Integer, CoordinatorRegistryCenter> REG_CENTER_REGISTRY = new ConcurrentHashMap<>();

  /**
   * 创建注册中心.
   *
   * @param zookeeperProperties the zookeeper properties
   *
   * @return 注册中心对象 coordinator registry center
   */
  public static CoordinatorRegistryCenter createCoordinatorRegistryCenter(ZookeeperProperties zookeeperProperties) {
//    Hasher hasher = Hashing.md5().newHasher().putString(zookeeperProperties.getZkAddressList(), Charsets.UTF_8);
//    HashCode hashCode = hasher.hash();

    Digester sha512 = new Digester(DigestAlgorithm.SHA512);
    String hex = sha512.digestHex(zookeeperProperties.getZkAddressList(), Charsets.UTF_8);
    int hashCode = hex.hashCode();
    CoordinatorRegistryCenter result = REG_CENTER_REGISTRY.get(hashCode);
    if (null != result) {
      return result;
    }
    result = new ZookeeperRegistryCenter(zookeeperProperties);
    result.init();
    REG_CENTER_REGISTRY.put(hashCode, result);
    return result;
  }

  /**
   * Startup.
   *
   * @param oopsProperties the paascloud properties
   * @param host                the host
   * @param app                 the app
   */
  public static void startup(OopsProperties oopsProperties, String host, String app) {
    CoordinatorRegistryCenter coordinatorRegistryCenter = createCoordinatorRegistryCenter(oopsProperties.getZk());
    RegisterDto dto = new RegisterDto(app, host, coordinatorRegistryCenter);
    Long serviceId = new IncrementIdGenerator(dto).nextId();
    IncrementIdGenerator.setServiceId(serviceId);
    registerMq(oopsProperties, host, app);
  }

  private static void registerMq(OopsProperties oopsProperties, String host, String app) {
    CoordinatorRegistryCenter coordinatorRegistryCenter = createCoordinatorRegistryCenter(oopsProperties.getZk());
    AliyunProperties.RocketMqProperties rocketMq = oopsProperties.getAliyun().getRocketMq();
    String consumerGroup = rocketMq.isReliableMessageConsumer() ? rocketMq.getConsumerGroup() : null;
    String namesrvAddr = rocketMq.getNameSrvAddr();
    String producerGroup = rocketMq.isReliableMessageProducer() ? rocketMq.getProducerGroup() : null;
    coordinatorRegistryCenter.registerMq(app, host, producerGroup, consumerGroup, namesrvAddr);
  }
}
