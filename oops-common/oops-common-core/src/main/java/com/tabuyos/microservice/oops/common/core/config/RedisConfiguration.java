package com.tabuyos.microservice.oops.common.core.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.microservice.oops.common.config.properties.OopsProperties;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Sentinel;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.config</i>
 *   <b>class: </b><i>RedisConfiguration</i>
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
 * @since 0.1.0 - 2/22/21 10:57 AM
 */
@Configuration
@EnableCaching
public class RedisConfiguration {

  @Resource
  private OopsProperties oopsProperties;

  /**
   * generator key generator.
   *
   * @return the key generator
   */
  @Bean
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      StringBuilder sb = new StringBuilder();
      sb.append(target.getClass().getName());
      sb.append(method.getName());
      for (Object obj : params) {
        sb.append(obj.toString());
      }
      return sb.toString();
    };

  }

  /**
   * Cache manager cache manager.
   *
   * @param connectionFactory the redis template
   *
   * @return the cache manager
   */
  @Bean
  public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    return RedisCacheManager.create(connectionFactory);
  }

  @Bean
  public StringRedisSerializer stringRedisSerializer() {
    return new StringRedisSerializer();
  }

  @Bean("redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.setKeySerializer(stringRedisSerializer());
    template.afterPropertiesSet();
    return template;
  }

//  @Bean
//  @ConditionalOnMissingBean(RedisConnectionFactory.class)
//  public JedisConnectionFactory redisConnectionFactory()
//    throws UnknownHostException {
//    return applyProperties(createJedisConnectionFactory());
//  }
//
//  //为JedisConnectionFactory注入host，port，password，database，timeout等基本属性
//  protected final JedisConnectionFactory applyProperties(
//    JedisConnectionFactory factory) {
//    factory.setHostName(this.oopsProperties.getHost());
//    factory.setPort(this.oopsProperties.getPort());
//    if (this.oopsProperties.getPassword() != null) {
//      factory.setPassword(this.oopsProperties.getPassword());
//    }
//    factory.setDatabase(this.oopsProperties.getDatabase());
//    if (this.oopsProperties.getTimeout() > 0) {
//      factory.setTimeout(this.oopsProperties.getTimeout());
//    }
//    return factory;
//  }
//
//  //下面几个方法的作用类似，就是检查spring上下文中是否已经有sentinel，cluster的配置
//  //bean（从构造函数注入的刚才），如果有，就用已有的，没有，就用
//  //从RedisProperties中写入的属性生成。
//  protected final RedisSentinelConfiguration getSentinelConfig() {
//    if (this.sentinelConfiguration != null) {
//      return this.sentinelConfiguration;
//    }
//    Sentinel sentinelProperties = this.properties.getSentinel();
//    if (sentinelProperties != null) {
//      RedisSentinelConfiguration config = new RedisSentinelConfiguration();
//      config.master(sentinelProperties.getMaster());
//      config.setSentinels(createSentinels(sentinelProperties));
//      return config;
//    }
//    return null;
//  }
//
//  /**
//   * Create a {@link RedisClusterConfiguration} if necessary.
//   * @return {@literal null} if no cluster settings are set.
//   */
//  protected final RedisClusterConfiguration getClusterConfiguration() {
//    if (this.clusterConfiguration != null) {
//      return this.clusterConfiguration;
//    }
//    if (this.properties.getCluster() == null) {
//      return null;
//    }
//    Cluster clusterProperties = this.properties.getCluster();
//    RedisClusterConfiguration config = new RedisClusterConfiguration(
//      clusterProperties.getNodes());
//
//    if (clusterProperties.getMaxRedirects() != null) {
//      config.setMaxRedirects(clusterProperties.getMaxRedirects());
//    }
//    return config;
//  }
//
//  private JedisConnectionFactory createJedisConnectionFactory() {
//    JedisPoolConfig poolConfig = this.oopsProperties.getPool() != null
//      ? jedisPoolConfig() : new JedisPoolConfig();
//
//    if (getSentinelConfig() != null) {
//      return new JedisConnectionFactory(getSentinelConfig(), poolConfig);
//    }
//    if (getClusterConfiguration() != null) {
//      return new JedisConnectionFactory(getClusterConfiguration(), poolConfig);
//    }
//    return new JedisConnectionFactory(poolConfig);
//  }
//
//  private JedisPoolConfig jedisPoolConfig() {
//    JedisPoolConfig config = new JedisPoolConfig();
//    RedisProperties.Pool props = this.properties.getPool();
//    config.setMaxTotal(props.getMaxActive());
//    config.setMaxIdle(props.getMaxIdle());
//    config.setMinIdle(props.getMinIdle());
//    config.setMaxWaitMillis(props.getMaxWait());
//    return config;
//  }
//
//  private List<RedisNode> createSentinels(Sentinel sentinel) {
//    List<RedisNode> nodes = new ArrayList<RedisNode>();
//    for (String node : StringUtils
//      .commaDelimitedListToStringArray(sentinel.getNodes())) {
//      try {
//        String[] parts = StringUtils.split(node, ":");
//        Assert.state(parts.length == 2, "Must be defined as 'host:port'");
//        nodes.add(new RedisNode(parts[0], Integer.valueOf(parts[1])));
//      }
//      catch (RuntimeException ex) {
//        throw new IllegalStateException(
//          "Invalid redis sentinel " + "property '" + node + "'", ex);
//      }
//    }
//    return nodes;
//  }
}
