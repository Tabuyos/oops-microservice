package com.tabuyos.microservice.oops.provider.uac.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.provider.uac.application
 *   <b>class: </b>UacApplication
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
 * @since 0.1.0 - 3/2/21 5:20 PM
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.microservice.oops.provider.uac"})
@EnableDiscoveryClient
@RestController
@RequestMapping("uac")
public class UacApplication {
  public static void main(String[] args) {
    SpringApplication.run(UacApplication.class, args);
  }

  @GetMapping("index")
  public String index() {
    return "Hello, tabuyos.";
  }
}
