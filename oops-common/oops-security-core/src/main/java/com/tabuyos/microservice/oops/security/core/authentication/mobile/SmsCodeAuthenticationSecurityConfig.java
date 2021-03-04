package com.tabuyos.microservice.oops.security.core.authentication.mobile;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authentication.mobile
 *   <b>class: </b>SmsCodeAuthenticationSecurityConfig
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
 * @since 0.1.0 - 3/1/21 11:12 AM
 */
@Component
public class SmsCodeAuthenticationSecurityConfig extends
  SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;
  private final AuthenticationFailureHandler pcAuthenticationFailureHandler;
  private final UserDetailsService userDetailsService;
  private final PersistentTokenRepository persistentTokenRepository;

  public SmsCodeAuthenticationSecurityConfig(
    AuthenticationSuccessHandler pcAuthenticationSuccessHandler,
    AuthenticationFailureHandler pcAuthenticationFailureHandler,
    UserDetailsService userDetailsService, PersistentTokenRepository persistentTokenRepository) {
    this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
    this.pcAuthenticationFailureHandler = pcAuthenticationFailureHandler;
    this.userDetailsService = userDetailsService;
    this.persistentTokenRepository = persistentTokenRepository;
  }

  /**
   * Configure.
   *
   * @param http the http
   */
  @Override
  public void configure(HttpSecurity http) {

    SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
    smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
    smsCodeAuthenticationFilter.setAuthenticationFailureHandler(pcAuthenticationFailureHandler);
    String key = UUID.randomUUID().toString();
    smsCodeAuthenticationFilter.setRememberMeServices(new PersistentTokenBasedRememberMeServices(key, userDetailsService, persistentTokenRepository));

    SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
    smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

    http.authenticationProvider(smsCodeAuthenticationProvider)
        .addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//

  }
}
