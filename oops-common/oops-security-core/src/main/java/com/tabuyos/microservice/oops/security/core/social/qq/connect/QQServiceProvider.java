package com.tabuyos.microservice.oops.security.core.social.qq.connect;

import com.tabuyos.microservice.oops.security.core.social.qq.api.QQ;
import com.tabuyos.microservice.oops.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.connect
 *   <b>class: </b>QQServiceProvider
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
 * @since 0.1.0 - 3/1/21 4:16 PM
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

  private final String appId;

  private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

  private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

  /**
   * Instantiates a new Qq service provider.
   *
   * @param appId     the app id
   * @param appSecret the app secret
   */
  QQServiceProvider(String appId, String appSecret) {
    super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    this.appId = appId;
  }

  /**
   * Gets api.
   *
   * @param accessToken the access token
   *
   * @return the api
   */
  @Override
  public QQ getApi(String accessToken) {
    return new QQImpl(accessToken, appId);
  }
}
