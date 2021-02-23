package com.tabuyos.microservice.oops.security.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.security.feign</i>
 *   <b>class: </b><i>Oauth2ClientProperties</i>
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
 * @since 0.1.0 - 2/22/21 2:15 PM
 */
@ConfigurationProperties(prefix = "oops.oauth2.client")
public class Oauth2ClientProperties {
  private String id;
  private String accessTokenUrl;
  private String clientId;
  private String clientSecret;
  private String clientAuthenticationScheme;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccessTokenUrl() {
    return accessTokenUrl;
  }

  public void setAccessTokenUrl(String accessTokenUrl) {
    this.accessTokenUrl = accessTokenUrl;
  }

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

  public String getClientAuthenticationScheme() {
    return clientAuthenticationScheme;
  }

  public void setClientAuthenticationScheme(String clientAuthenticationScheme) {
    this.clientAuthenticationScheme = clientAuthenticationScheme;
  }

  @Override
  public String toString() {
    return "Oauth2ClientProperties{" +
      "id='" + id + '\'' +
      ", accessTokenUrl='" + accessTokenUrl + '\'' +
      ", clientId='" + clientId + '\'' +
      ", clientSecret='" + clientSecret + '\'' +
      ", clientAuthenticationScheme='" + clientAuthenticationScheme + '\'' +
      '}';
  }
}
