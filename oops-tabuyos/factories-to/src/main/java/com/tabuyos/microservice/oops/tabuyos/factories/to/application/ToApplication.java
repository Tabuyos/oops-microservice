package com.tabuyos.microservice.oops.tabuyos.factories.to.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.tabuyos.factories.to.application
 *   <b>class: </b>ToApplication
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
 * @since 0.1.0 - 2/25/21 5:01 PM
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.microservice.oops.tabuyos"})
public class ToApplication {
  public static void main(String[] args) {
    SpringApplication.run(ToApplication.class, args);
  }
}
