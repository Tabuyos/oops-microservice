package com.tabuyos.microservice.oops.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authentication.mobile
 *   <b>class: </b>SmsCodeAuthenticationProvider
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
 * @since 0.1.0 - 3/1/21 11:12 AM
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
  private UserDetailsService userDetailsService;

  /**
   * Authenticate authentication.
   *
   * @param authentication the authentication
   * @return the authentication
   * @throws AuthenticationException the authentication exception
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;

    UserDetails user =
        userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());

    if (user == null) {
      throw new InternalAuthenticationServiceException("无法获取用户信息");
    }

    SmsCodeAuthenticationToken authenticationResult =
        new SmsCodeAuthenticationToken(user, user.getAuthorities());

    authenticationResult.setDetails(authenticationToken.getDetails());

    return authenticationResult;
  }

  /**
   * Supports boolean.
   *
   * @param authentication the authentication
   * @return the boolean
   */
  @Override
  public boolean supports(Class<?> authentication) {
    return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
  }

  /**
   * Gets user details service.
   *
   * @return the user details service
   */
  public UserDetailsService getUserDetailsService() {
    return userDetailsService;
  }

  /**
   * Sets user details service.
   *
   * @param userDetailsService the user details service
   */
  public void setUserDetailsService(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }
}
