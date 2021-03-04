package com.tabuyos.microservice.oops.security.core.social.qq.config;

import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import com.tabuyos.microservice.oops.security.core.properties.QQProperties;
import com.tabuyos.microservice.oops.security.core.properties.SecurityProperties;
import com.tabuyos.microservice.oops.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.config
 *   <b>class: </b>QQAutoConfig
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
 * @since 0.1.0 - 3/1/21 4:07 PM
 */
@Component
@ConditionalOnProperty(prefix = GlobalConstant.OOPS_SECURITY_SOCIAL_QQ_PREFIX, name = "app-id")
public class QQAutoConfig {
  private final SecurityProperties securityProperties;

  @Autowired
  public QQAutoConfig(SecurityProperties securityProperties) {
    this.securityProperties = securityProperties;
  }
//
//  /**
//   * Create connection factory connection factory.
//   *
//   * @return the connection factory
//   */
//  @Override
//  protected ConnectionFactory<?> createConnectionFactory() {
//    QQProperties qqConfig = securityProperties.getSocial().getQq();
//    return new QQConnectionFactory(
//        qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
//  }
}
