package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>KvDto</i>
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
 * @since 0.1.0 - 2/3/21 4:58 PM
 */
public class KvDto<K, V> implements Serializable {

  @Serial
  private static final long serialVersionUID = -4148462133208063479L;

  /**
   * Instantiates a new Kv dto.
   */
  public KvDto() {
  }

  /**
   * Instantiates a new Kv dto.
   *
   * @param key   the key
   * @param value the value
   */
  public KvDto(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * key
   */
  private K key;
  /**
   * value
   */
  private V value;

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "KvDto{" +
      "key=" + key +
      ", value=" + value +
      '}';
  }
}
