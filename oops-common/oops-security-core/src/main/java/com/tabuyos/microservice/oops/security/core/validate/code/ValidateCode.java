package com.tabuyos.microservice.oops.security.core.validate.code;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCode
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 * <pre><b>email: </b>tabuyos@outlook.com</pre>
 * <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:41 PM
 */
public class ValidateCode implements Serializable {
  @Serial
  private static final long serialVersionUID = 2343195200712225755L;

  private String code;

  private String type;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime expireTime;

  /**
   * Instantiates a new Validate code.
   */
  public ValidateCode() {
  }

  /**
   * Instantiates a new Validate code.
   *
   * @param code     the code
   * @param expireIn the expire in
   */
  public ValidateCode(String code, int expireIn) {
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
  }

  /**
   * Instantiates a new Validate code.
   *
   * @param code       the code
   * @param expireTime the expire time
   */
  public ValidateCode(String code, LocalDateTime expireTime) {
    this.code = code;
    this.expireTime = expireTime;
  }

  /**
   * Is expired boolean.
   *
   * @return the boolean
   */
  @JsonIgnore
  public boolean isExpired() {
    return LocalDateTime.now().isAfter(expireTime);
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Gets expire time.
   *
   * @return the expire time
   */
  public LocalDateTime getExpireTime() {
    return expireTime;
  }

  /**
   * Sets expire time.
   *
   * @param expireTime the expire time
   */
  public void setExpireTime(LocalDateTime expireTime) {
    this.expireTime = expireTime;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * To string string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ValidateCode{");
    sb.append("code='").append(code).append('\'');
    sb.append(", type='").append(type).append('\'');
    sb.append(", expireTime=").append(expireTime);
    sb.append('}');
    return sb.toString();
  }
}
