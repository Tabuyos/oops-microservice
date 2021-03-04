package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>OAuth2ClientProperties
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
 * @since 0.1.0 - 3/1/21 11:00 AM
 */
public class OAuth2ClientProperties {
  /**
   * 第三方应用appId
   */
  private String clientId;
  /**
   * 第三方应用appSecret
   */
  private String clientSecret;
  /**
   * 针对此应用发出的token的有效时间
   */
  private int accessTokenValidateSeconds = 7200;

  private int refreshTokenValiditySeconds = 2592000;

  private String scope;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public int getAccessTokenValidateSeconds() {
    return accessTokenValidateSeconds;
  }

  public void setAccessTokenValidateSeconds(int accessTokenValidateSeconds) {
    this.accessTokenValidateSeconds = accessTokenValidateSeconds;
  }

  public int getRefreshTokenValiditySeconds() {
    return refreshTokenValiditySeconds;
  }

  public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
    this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  @Override
  public String toString() {
    return "OAuth2ClientProperties{" +
      "clientId='" + clientId + '\'' +
      ", clientSecret='" + clientSecret + '\'' +
      ", accessTokenValidateSeconds=" + accessTokenValidateSeconds +
      ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds +
      ", scope='" + scope + '\'' +
      '}';
  }
}
