package com.tabuyos.microservice.oops.tabuyos.order.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>oops-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.tabuyos.order.application</i>
 *   <b>class: </b><i>OopsOrderApplication</i>
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 * <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 * <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 * <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/23/21 4:04 PM
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.microservice.oops.tabuyos.order"})
@RestController
@RequestMapping("order")
public class OopsOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(OopsOrderApplication.class, args);
  }

  @GetMapping("index")
  public String index() {
    return "Hello tabuyos from order.";
  }

  @GetMapping("sayHello")
  public String sayHello() {
    return "you can see the message.";
  }

  @GetMapping("monoFallback")
  public Mono<String> monoFallback() {
    return Mono.just("monoFallback");
  }

  @GetMapping("fluxFallback")
  public Flux<String> fluxFallback() {
    return Flux.just("fluxFallback0", "fluxFallback1", "fluxFallback2");
  }
}
