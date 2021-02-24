package com.tabuyos.microservice.oops.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>oops-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.gateway.route</i>
 *   <b>class: </b><i>TestRoute</i>
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
 * @since 0.1.0 - 2/23/21 3:52 PM
 */
@Configuration
public class TabuyosRoute {

  @Bean
  public RouteLocator kiteRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route("userRouter",
            r -> r.path("/user/**")
                  .filters(
                      f ->	f.addResponseHeader("X-CustomerHeader", "kite"))
                  .uri("lb://oops-tabuyos-user"))
        .route("orderRouter",
            r -> r.path("/test/order/**")
                  .filters(
                      f -> f.stripPrefix(1))
                  .uri("lb://oops-tabuyos-order"))
        .route("redirect",
            p -> p.path("/redirect/**")
                  .filters(g -> g.addResponseHeader("tabuyos", "tabuyos").redirect(302, "https://www.baidu.com"))
                  .uri("lb://oops-tabuyos-order"))
        .build();
  }
}
