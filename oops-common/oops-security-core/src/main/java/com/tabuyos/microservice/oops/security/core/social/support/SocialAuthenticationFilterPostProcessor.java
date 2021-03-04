package com.tabuyos.microservice.oops.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.support
 *   <b>class: </b>SocialAuthenticationFilterPostProcessor
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
 * @since 0.1.0 - 3/1/21 4:23 PM
 */
public interface SocialAuthenticationFilterPostProcessor {
  /**
   * Process.
   *
   * @param socialAuthenticationFilter the social authentication filter
   */
  void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
