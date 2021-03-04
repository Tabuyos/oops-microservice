package com.tabuyos.microservice.oops.security.core.social;

import com.tabuyos.microservice.oops.security.core.properties.SecurityProperties;
import com.tabuyos.microservice.oops.security.core.social.support.PcSpringSocialConfigurer;
import com.tabuyos.microservice.oops.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social
 *   <b>class: </b>SocialConfig
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
 * @since 0.1.0 - 3/1/21 11:23 AM
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
  @Autowired private DataSource dataSource;

  @Autowired private SecurityProperties securityProperties;

  @Autowired(required = false)
  private ConnectionSignUp connectionSignUp;

  @Autowired(required = false)
  private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

  /**
   * Gets users connection repository.
   *
   * @param connectionFactoryLocator the connection factory locator
   * @return the users connection repository
   */
  @Override
  public UsersConnectionRepository getUsersConnectionRepository(
      ConnectionFactoryLocator connectionFactoryLocator) {
    JdbcUsersConnectionRepository repository =
        new JdbcUsersConnectionRepository(
            dataSource, connectionFactoryLocator, Encryptors.noOpText());
    repository.setTablePrefix("pc_uac_");
    if (connectionSignUp != null) {
      repository.setConnectionSignUp(connectionSignUp);
    }
    return repository;
  }

  /**
   * 社交登录配置类，供浏览器或app模块引入设计登录配置用。
   *
   * @return spring social configurer
   */
  @Bean
  public SpringSocialConfigurer pcSocialSecurityConfig() {
    String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
    PcSpringSocialConfigurer configurer = new PcSpringSocialConfigurer(filterProcessesUrl);
    configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
    configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
    return configurer;
  }

  /**
   * 用来处理注册流程的工具类
   *
   * @param connectionFactoryLocator the connection factory locator
   * @return provider sign in utils
   */
  @Bean
  public ProviderSignInUtils providerSignInUtils(
      ConnectionFactoryLocator connectionFactoryLocator) {
    return new ProviderSignInUtils(
        connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator)) {};
  }
}
