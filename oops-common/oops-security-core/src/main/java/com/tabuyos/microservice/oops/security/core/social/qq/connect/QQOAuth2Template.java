package com.tabuyos.microservice.oops.security.core.social.qq.connect;

import java.nio.charset.Charset;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.connect
 *   <b>class: </b>QQOAuth2Template
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
 * @since 0.1.0 - 3/1/21 4:15 PM
 */
public class QQOAuth2Template extends OAuth2Template {

  private final Logger log = LoggerFactory.getLogger(QQOAuth2Template.class);

  /**
   * Instantiates a new Qqo auth 2 template.
   *
   * @param clientId       the client id
   * @param clientSecret   the client secret
   * @param authorizeUrl   the authorize url
   * @param accessTokenUrl the access token url
   */
  QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
    super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    setUseParametersForClientAuthentication(true);
  }

  /**
   * Post for access grant access grant.
   *
   * @param accessTokenUrl the access token url
   * @param parameters     the parameters
   *
   * @return the access grant
   */
  @Override
  protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
    String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);

    log.info("获取accessToke的响应={}", responseStr);

    String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");

    String accessToken = StringUtils.substringAfterLast(items[0], "=");
    Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
    String refreshToken = StringUtils.substringAfterLast(items[2], "=");

    return new AccessGrant(accessToken, null, refreshToken, expiresIn);
  }

  /**
   * Create rest template rest template.
   *
   * @return the rest template
   */
  @Override
  protected RestTemplate createRestTemplate() {
    RestTemplate restTemplate = super.createRestTemplate();
    restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    return restTemplate;
  }
}
