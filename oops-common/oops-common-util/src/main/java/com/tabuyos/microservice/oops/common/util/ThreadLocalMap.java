package com.tabuyos.microservice.oops.common.util;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>ThreadLocalMap</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class ThreadLocalMap {
  /**
   * The constant threadContext.
   */
  private static final ThreadLocal<Map<String, Object>> THREAD_CONTEXT = new MapThreadLocal();

  /**
   * Put.
   *
   * @param key the key
   * @param value the value
   */
  public static void put(String key, Object value) {
    getContextMap().put(key, value);
  }

  /**
   * Remove object.
   *
   * @param key the key
   * @return the object
   */
  public static Object remove(String key) {
    return getContextMap().remove(key);
  }

  /**
   * Get object.
   *
   * @param key the key
   * @return the object
   */
  public static Object get(String key) {
    return getContextMap().get(key);
  }

  private static class MapThreadLocal extends ThreadLocal<Map<String, Object>> {
    /**
     * Initial value map.
     *
     * @return the map
     */
    @Override
    protected Map<String, Object> initialValue() {
      return new HashMap<String, Object>(8) {

        @Serial private static final long serialVersionUID = 3637958959138295593L;

        @Override
        public Object put(String key, Object value) {
          return super.put(key, value);
        }
      };
    }
  }

  /**
   * 取得thread context Map的实例。
   *
   * @return thread context Map的实例
   */
  private static Map<String, Object> getContextMap() {
    return THREAD_CONTEXT.get();
  }

  /** 清理线程所有被hold住的对象。以便重用！ */
  public static void remove() {
    getContextMap().clear();
  }
}
