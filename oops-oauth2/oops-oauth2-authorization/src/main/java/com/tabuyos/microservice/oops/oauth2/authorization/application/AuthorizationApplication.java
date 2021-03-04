package com.tabuyos.microservice.oops.oauth2.authorization.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.authorization.application
 *   <b>class: </b>Authorization
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
 * @since 0.1.0 - 3/3/21 11:32 AM
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.microservice.oops.oauth2.authorization"})
public class AuthorizationApplication {
  public static void main(String[] args) {
    SpringApplication.run(AuthorizationApplication.class, args);
  }
}
