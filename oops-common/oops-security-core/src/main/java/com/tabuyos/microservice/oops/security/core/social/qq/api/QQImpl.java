package com.tabuyos.microservice.oops.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.api
 *   <b>class: </b>QQImpl
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
 * @since 0.1.0 - 3/1/21 4:04 PM
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

  private final Logger log = LoggerFactory.getLogger(QQImpl.class);

  private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

  private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

  private String appId;

  private String openId;

  private ObjectMapper objectMapper = new ObjectMapper();

  /**
   * Instantiates a new Qq.
   *
   * @param accessToken the access token
   * @param appId       the app id
   */
  public QQImpl(String accessToken, String appId) {
    super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

    this.appId = appId;

    String url = String.format(URL_GET_OPENID, accessToken);
    String result = getRestTemplate().getForObject(url, String.class);

    log.info("result={}", result);

    this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
  }

  /**
   * Gets user info.
   *
   * @return the user info
   */
  @Override
  public QQUserInfo getUserInfo() {

    String url = String.format(URL_GET_USERINFO, appId, openId);
    String result = getRestTemplate().getForObject(url, String.class);

    log.info("result={}", result);

    QQUserInfo userInfo;
    try {
      userInfo = objectMapper.readValue(result, QQUserInfo.class);
      userInfo.setOpenId(openId);
      return userInfo;
    } catch (Exception e) {
      throw new RuntimeException("获取用户信息失败", e);
    }
  }
}
