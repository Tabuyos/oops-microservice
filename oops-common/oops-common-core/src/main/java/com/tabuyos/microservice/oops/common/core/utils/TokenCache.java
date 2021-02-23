package com.tabuyos.microservice.oops.common.core.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.utils</i>
 *   <b>class: </b><i>TokenCache</i>
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
 * @since 0.1.0 - 2/22/21 1:39 PM
 */
public class TokenCache {

  private final static Logger log = LoggerFactory.getLogger(TokenCache.class);

  public static final String NULL = "null";

  /**
   * LRU算法
   */
  private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
    .build(new CacheLoader<String, String>() {
      //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
      @Override
      public String load(String s) {
        return "null";
      }
    });

  /**
   * Set key.
   *
   * @param key   the key
   * @param value the value
   */
  public static void setKey(String key, String value) {
    localCache.put(key, value);
  }

  /**
   * Get key string.
   *
   * @param key the key
   *
   * @return the string
   */
  public static String getKey(String key) {
    String value;
    try {
      value = localCache.get(key);
      if (NULL.equals(value)) {
        return null;
      }
      return value;
    } catch (Exception e) {
      log.error("localCache get error", e);
    }
    return null;
  }
}
