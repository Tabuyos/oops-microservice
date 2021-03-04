//package com.tabuyos.microservice.oops.security.server;
//
//import com.tabuyos.microservice.oops.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
//import com.tabuyos.microservice.oops.security.core.authentication.FormAuthenticationConfig;
//import com.tabuyos.microservice.oops.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
//import com.tabuyos.microservice.oops.security.core.authorize.AuthorizeConfigManager;
//import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeSecurityConfig;
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.social.security.SpringSocialConfigurer;
//
///**
// * Description:
// *
// * <pre>
// *   <b>project: </b>oops-microservice
// *   <b>package: </b>com.tabuyos.microservice.oops.security.server
// *   <b>class: </b>PcResourceServerConfig
// *   comment here.
// * </pre>
// *
// * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
// * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
// * <pre><b>email: </b>tabuyos@outlook.com</pre>
// * <pre><b>description: </b>
// *       <pre>
// *         Talk is cheap, show me the code.
// *       </pre>
// *     </pre>
// * @version 0.1.0
// * @since 0.1.0 - 3/1/21 5:29 PM
// */
//@Configuration
////@EnableResourceServer
//public class PcResourceServerConfig extends ResourceServerConfigurerAdapter {
//  @Autowired
//  private OAuth2WebSecurityExpressionHandler pcSecurityExpressionHandler;
//
//  @Autowired
//  private AccessDeniedHandler pcAccessDeniedHandler;
//
//  @Autowired
//  protected AuthenticationSuccessHandler pcAuthenticationSuccessHandler;
//
//  @Autowired
//  protected AuthenticationFailureHandler pcAuthenticationFailureHandler;
//
//  @Autowired
//  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
//
//  @Autowired
//  private ValidateCodeSecurityConfig validateCodeSecurityConfig;
//
//  @Autowired
//  private SpringSocialConfigurer pcSocialSecurityConfig;
//
//  @Autowired
//  private AuthorizeConfigManager authorizeConfigManager;
//
//  @Autowired
//  private FormAuthenticationConfig formAuthenticationConfig;
//
//  @Autowired
//  private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
//
//  @Resource
//  private DataSource dataSource;
//
//  /**
//   * 记住我功能的token存取器配置
//   *
//   * @return the persistent token repository
//   */
//  @Bean
//  public PersistentTokenRepository persistentTokenRepository() {
//    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//    tokenRepository.setDataSource(dataSource);
////		tokenRepository.setCreateTableOnStartup(true); // 第一次启动创建
//    return tokenRepository;
//  }
//
//  /**
//   * Configure.
//   *
//   * @param http the http
//   *
//   * @throws Exception the exception
//   */
//  @Override
//  public void configure(HttpSecurity http) throws Exception {
//    formAuthenticationConfig.configure(http);
//    http.headers().frameOptions().disable();
//    http.apply(validateCodeSecurityConfig)
//        .and()
//        .apply(smsCodeAuthenticationSecurityConfig)
//        .and()
//        .apply(pcSocialSecurityConfig)
//        .and()
//        .apply(openIdAuthenticationSecurityConfig)
//        .and()
//        .headers().frameOptions().disable()
//        .and()
//        .exceptionHandling().accessDeniedHandler(pcAccessDeniedHandler)
//        .and()
//        .csrf().disable();
//
//    authorizeConfigManager.config(http.authorizeRequests());
//  }
//
//  @Override
//  public void configure(ResourceServerSecurityConfigurer resources) {
//    resources.expressionHandler(pcSecurityExpressionHandler);
//  }
//}
