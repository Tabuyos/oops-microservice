package com.tabuyos.microservice.oops.oauth2.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.resource.config
 *   <b>class: </b>ResourceServerConfig
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
 * @since 0.1.0 - 3/4/21 11:05 AM
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {
  private static final String RESOURCE_ID = "messages-resource";

  private final TokenStore tokenStore;

  public ResourceServerConfig(TokenStore tokenStore) {
    this.tokenStore = tokenStore;
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer security) throws Exception {
    security.resourceId(RESOURCE_ID).tokenStore(this.tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/messages/**")
        .authorizeRequests()
        .antMatchers("/messages/**")
        .access("#oauth2.hasScope('message.read')");
  }
}
