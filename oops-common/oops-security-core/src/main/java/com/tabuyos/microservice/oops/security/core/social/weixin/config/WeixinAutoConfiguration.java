package com.tabuyos.microservice.oops.security.core.social.weixin.config;

import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import com.tabuyos.microservice.oops.security.core.social.view.PcConnectView;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.weixin.config
 *   <b>class: </b>WeixinAutoConfiguration
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
 * @since 0.1.0 - 3/1/21 4:29 PM
 */
@Configuration
@ConditionalOnProperty(prefix = GlobalConstant.OOPS_SECURITY_SOCIAL_WEIXIN_PREFIX, name = "app-id")
public class WeixinAutoConfiguration {
//  @Autowired
//  private SecurityProperties securityProperties;
//
//  /**
//   * Create connection factory connection factory.
//   *
//   * @return the connection factory
//   */
//  @Override
//  protected ConnectionFactory<?> createConnectionFactory() {
//    WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
//    return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
//      weixinConfig.getAppSecret());
//  }

  /**
   * Weixin connected view view.
   *
   * @return the view
   */
  @Bean({"connect/weixinConnect", "connect/weixinConnected"})
  @ConditionalOnMissingBean(name = "weixinConnectedView")
  public View weixinConnectedView() {
    return new PcConnectView();
  }
}
