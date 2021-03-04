package com.tabuyos.microservice.oops.security.core.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authentication
 *   <b>class: </b>DefaultSocialUserDetailsServiceImpl
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
 * @since 0.1.0 - 3/1/21 10:43 AM
 */
public class DefaultSocialUserDetailsServiceImpl implements SocialUserDetailsService {

  private final Logger log = LoggerFactory.getLogger(DefaultSocialUserDetailsServiceImpl.class);

  /**
   * Load user by user id social user details.
   *
   * @param userId the user id
   *
   * @return the social user details
   *
   * @throws UsernameNotFoundException the username not found exception
   */
  @Override
  public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
    log.warn("请配置 SocialUserDetailsService 接口的实现.");
    throw new UsernameNotFoundException(userId);
  }
}
