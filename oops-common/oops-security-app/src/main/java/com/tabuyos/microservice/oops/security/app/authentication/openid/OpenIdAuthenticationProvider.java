package com.tabuyos.microservice.oops.security.app.authentication.openid;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.util.CollectionUtils;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.app.authentication.openid
 *   <b>class: </b>OpenIdAuthenticationProvider
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
 * @since 0.1.0 - 3/1/21 5:25 PM
 */
public class OpenIdAuthenticationProvider implements AuthenticationProvider {
  private SocialUserDetailsService userDetailsService;

  private UsersConnectionRepository usersConnectionRepository;

  /**
   * Authenticate authentication.
   *
   * @param authentication the authentication
   *
   * @return the authentication
   *
   * @throws AuthenticationException the authentication exception
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    OpenIdAuthenticationToken authenticationToken = (OpenIdAuthenticationToken) authentication;

    Set<String> providerUserIds = new HashSet<>();
    providerUserIds.add((String) authenticationToken.getPrincipal());
    Set<String> userIds = usersConnectionRepository.findUserIdsConnectedTo(authenticationToken.getProviderId(), providerUserIds);

    if (CollectionUtils.isEmpty(userIds) || userIds.size() != 1) {
      throw new InternalAuthenticationServiceException("无法获取用户信息");
    }

    String userId = userIds.iterator().next();

    UserDetails user = userDetailsService.loadUserByUserId(userId);

    if (user == null) {
      throw new InternalAuthenticationServiceException("无法获取用户信息");
    }

    OpenIdAuthenticationToken authenticationResult = new OpenIdAuthenticationToken(user, user.getAuthorities());

    authenticationResult.setDetails(authenticationToken.getDetails());

    return authenticationResult;
  }

  /**
   * Supports boolean.
   *
   * @param authentication the authentication
   *
   * @return the boolean
   */
  @Override
  public boolean supports(Class<?> authentication) {
    return OpenIdAuthenticationToken.class.isAssignableFrom(authentication);
  }

  /**
   * Gets user details service.
   *
   * @return the user details service
   */
  public SocialUserDetailsService getUserDetailsService() {
    return userDetailsService;
  }

  /**
   * Sets user details service.
   *
   * @param userDetailsService the user details service
   */
  public void setUserDetailsService(SocialUserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  /**
   * Gets users connection repository.
   *
   * @return the users connection repository
   */
  public UsersConnectionRepository getUsersConnectionRepository() {
    return usersConnectionRepository;
  }

  /**
   * Sets users connection repository.
   *
   * @param usersConnectionRepository the users connection repository
   */
  public void setUsersConnectionRepository(UsersConnectionRepository usersConnectionRepository) {
    this.usersConnectionRepository = usersConnectionRepository;
  }
}
