package com.tabuyos.microservice.oops.security.core.social.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.weixin.api
 *   <b>class: </b>WeixinImpl
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
 * @since 0.1.0 - 3/1/21 4:27 PM
 */
public class WeixinImpl extends AbstractOAuth2ApiBinding implements Weixin {

  private final Logger log = LoggerFactory.getLogger(WeixinImpl.class);

  private ObjectMapper objectMapper = new ObjectMapper();
  private static final String ERR_CODE = "errcode";
  /** 获取用户信息的url */
  private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

  /**
   * Instantiates a new Weixin.
   *
   * @param accessToken the access token
   */
  public WeixinImpl(String accessToken) {
    super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
  }

  /**
   * 默认注册的StringHttpMessageConverter字符集为ISO-8859-1，而微信返回的是UTF-8的，所以覆盖了原来的方法。
   *
   * @return the message converters
   */
  @Override
  protected List<HttpMessageConverter<?>> getMessageConverters() {
    List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
    messageConverters.remove(0);
    messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    return messageConverters;
  }

  /**
   * 获取微信用户信息。
   *
   * @param openId the open id
   * @return the user info
   */
  @Override
  public WeixinUserInfo getUserInfo(String openId) {
    String url = URL_GET_USER_INFO + openId;
    String response = getRestTemplate().getForObject(url, String.class);
    if (StringUtils.contains(response, ERR_CODE)) {
      return null;
    }
    WeixinUserInfo profile = null;
    try {
      profile = objectMapper.readValue(response, WeixinUserInfo.class);
    } catch (Exception e) {
      log.error("getUserInfo={}", e.getMessage(), e);
    }
    return profile;
  }
}
