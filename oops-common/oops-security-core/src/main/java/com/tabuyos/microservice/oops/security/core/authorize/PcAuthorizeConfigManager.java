package com.tabuyos.microservice.oops.security.core.authorize;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authorize
 *   <b>class: </b>PcAuthorizeConfigManager
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
 * @since 0.1.0 - 3/1/21 11:20 AM
 */
@Component
public class PcAuthorizeConfigManager implements AuthorizeConfigManager {
  private final List<AuthorizeConfigProvider> authorizeConfigProviders;

  /**
   * Instantiates a new Pc authorize config manager.
   *
   * @param authorizeConfigProviders the authorize config providers
   */
  @Autowired
  public PcAuthorizeConfigManager(List<AuthorizeConfigProvider> authorizeConfigProviders) {
    this.authorizeConfigProviders = authorizeConfigProviders;
  }

  /**
   * Config.
   *
   * @param config the config
   */
  @Override
  public void config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    boolean existAnyRequestConfig = false;
    String existAnyRequestConfigName = null;

    for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
      boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
      if (existAnyRequestConfig && currentIsAnyRequestConfig) {
        throw new RuntimeException(
            "重复的anyRequest配置:"
                + existAnyRequestConfigName
                + ","
                + authorizeConfigProvider.getClass().getSimpleName());
      } else if (currentIsAnyRequestConfig) {
        existAnyRequestConfig = true;
        existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
      }
    }

    if (!existAnyRequestConfig) {
      config.anyRequest().authenticated();
    }
  }
}
