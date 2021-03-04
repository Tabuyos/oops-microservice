package com.tabuyos.microservice.oops.security.app.social;

import com.tabuyos.microservice.oops.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.app.social
 *   <b>class: </b>AppSocialAuthenticationFilterPostProcessor
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
 * @since 0.1.0 - 3/1/21 5:22 PM
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements
  SocialAuthenticationFilterPostProcessor {
  private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

  @Autowired
  public AppSocialAuthenticationFilterPostProcessor(AuthenticationSuccessHandler pcAuthenticationSuccessHandler) {
    this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
  }

  @Override
  public void process(final SocialAuthenticationFilter socialAuthenticationFilter) {
    socialAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
  }
}
