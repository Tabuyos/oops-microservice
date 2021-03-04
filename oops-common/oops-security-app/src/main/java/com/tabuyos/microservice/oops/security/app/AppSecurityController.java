package com.tabuyos.microservice.oops.security.app;

import com.tabuyos.microservice.oops.security.app.social.AppSingUpUtils;
import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import com.tabuyos.microservice.oops.security.core.social.BaseSocialController;
import com.tabuyos.microservice.oops.security.core.social.support.SocialUserInfo;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.app
 *   <b>class: </b>AppSecurityController
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
 * @since 0.1.0 - 3/1/21 5:18 PM
 */
@RestController
public class AppSecurityController extends BaseSocialController {
  @Resource
  private ProviderSignInUtils providerSignInUtils;

  @Resource
  private AppSingUpUtils appSingUpUtils;

  /**
   * 需要注册时跳到这里，返回401和用户信息给前端
   *
   * @param request the request
   *
   * @return social user info
   */
  @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
    Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
    appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
    return buildSocialUserInfo(connection);
  }
}
