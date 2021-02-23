package com.tabuyos.microservice.oops.common.base.dto;


import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>CheckValidDto</i>
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
 * @since 0.1.0 - 2/3/21 4:48 PM
 */
public class CheckValidDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -7923595884548921201L;

  /**
   * 校验的参数值
   */
  private String validValue;

  /**
   * 参数类型(列)
   */
  private String type;

  public String getValidValue() {
    return validValue;
  }

  public void setValidValue(String validValue) {
    this.validValue = validValue;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "CheckValidDto{" +
      "validValue='" + validValue + '\'' +
      ", type='" + type + '\'' +
      '}';
  }
}
