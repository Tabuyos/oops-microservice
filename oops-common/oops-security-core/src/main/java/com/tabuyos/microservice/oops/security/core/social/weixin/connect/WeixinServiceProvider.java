package com.tabuyos.microservice.oops.security.core.social.weixin.connect;

import com.tabuyos.microservice.oops.security.core.social.weixin.api.Weixin;
import com.tabuyos.microservice.oops.security.core.social.weixin.api.WeixinImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.weixin.connect
 *   <b>class: </b>WeixinServiceProvider
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:36 PM
 */
public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<Weixin> {
  /** 微信获取授权码的url */
  private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
  /** 微信获取accessToken的url */
  private static final String URL_ACCESS_TOKEN =
      "https://api.weixin.qq.com/sns/oauth2/access_token";

  /**
   * Instantiates a new Weixin service provider.
   *
   * @param appId the app id
   * @param appSecret the app secret
   */
  WeixinServiceProvider(String appId, String appSecret) {
    super(new WeixinOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
  }

  /**
   * Gets api.
   *
   * @param accessToken the access token
   * @return the api
   */
  @Override
  public Weixin getApi(String accessToken) {
    return new WeixinImpl(accessToken);
  }
}
