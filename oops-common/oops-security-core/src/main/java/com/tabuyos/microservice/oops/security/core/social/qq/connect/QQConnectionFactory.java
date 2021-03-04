package com.tabuyos.microservice.oops.security.core.social.qq.connect;

import com.tabuyos.microservice.oops.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.connect
 *   <b>class: </b>QQConnectionFactory
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
 * @since 0.1.0 - 3/1/21 4:15 PM
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
  /**
   * Instantiates a new Qq connection factory.
   *
   * @param providerId the provider id
   * @param appId      the app id
   * @param appSecret  the app secret
   */
  public QQConnectionFactory(String providerId, String appId, String appSecret) {
    super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
  }
}
