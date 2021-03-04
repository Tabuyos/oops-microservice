package com.tabuyos.microservice.oops.security.core.properties;

import java.util.Arrays;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>OAuth2Properties
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
 * @since 0.1.0 - 3/1/21 11:01 AM
 */
public class OAuth2Properties {
  /**
   * 使用jwt时为token签名的秘钥
   */
  private String jwtSigningKey = "oops";
  /**
   * 客户端配置
   */
  private OAuth2ClientProperties[] clients = {};

  public String getJwtSigningKey() {
    return jwtSigningKey;
  }

  public void setJwtSigningKey(String jwtSigningKey) {
    this.jwtSigningKey = jwtSigningKey;
  }

  public OAuth2ClientProperties[] getClients() {
    return clients;
  }

  public void setClients(
    OAuth2ClientProperties[] clients) {
    this.clients = clients;
  }

  @Override
  public String toString() {
    return "OAuth2Properties{" +
      "jwtSigningKey='" + jwtSigningKey + '\'' +
      ", clients=" + Arrays.toString(clients) +
      '}';
  }
}
