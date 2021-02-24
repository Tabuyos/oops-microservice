package com.tabuyos.microservice.oops.discovery.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.discovery.application</i>
 *   <b>class: </b><i>OopsDiscoveryApplication</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 3:06 PM
 */
@SpringBootApplication
@EnableConfigServer
public class OopsDiscoveryApplication {

  public static void main(String[] args) {
    SpringApplication.run(OopsDiscoveryApplication.class, args);
  }
}
