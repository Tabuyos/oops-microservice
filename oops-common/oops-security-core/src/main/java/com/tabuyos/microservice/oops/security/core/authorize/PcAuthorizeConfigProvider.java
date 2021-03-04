package com.tabuyos.microservice.oops.security.core.authorize;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authorize
 *   <b>class: </b>PcAuthorizeConfigProvider
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
 * @since 0.1.0 - 3/1/21 11:21 AM
 */
@Component
@Order(Integer.MIN_VALUE)
public class PcAuthorizeConfigProvider implements AuthorizeConfigProvider {
  /**
   * Config boolean.
   *
   * @param config the config
   * @return the boolean
   */
  @Override
  public boolean config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    config
        .antMatchers(
            SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
            SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
            SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,
            SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL,
            SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
            "/pay/alipayCallback",
            "/druid/**",
            "/auth/**",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/v2/api-docs")
        .permitAll();
    return false;
  }
}
