package com.tabuyos.microservice.oops.security.core.social;

import com.tabuyos.microservice.oops.security.core.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social
 *   <b>class: </b>BaseSocialController
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
 * @since 0.1.0 - 3/1/21 11:23 AM
 */
public abstract class BaseSocialController {
  /**
   * 根据Connection信息构建SocialUserInfo
   *
   * @param connection the connection
   *
   * @return social user info
   */
  protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
    SocialUserInfo userInfo = new SocialUserInfo();
    userInfo.setProviderId(connection.getKey().getProviderId());
    userInfo.setProviderUserId(connection.getKey().getProviderUserId());
    userInfo.setNickname(connection.getDisplayName());
    userInfo.setHeadimg(connection.getImageUrl());
    return userInfo;
  }
}
