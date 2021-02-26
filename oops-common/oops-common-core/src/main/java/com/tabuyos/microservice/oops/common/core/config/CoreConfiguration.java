package com.tabuyos.microservice.oops.common.core.config;

import com.tabuyos.microservice.oops.common.core.interceptor.SqlLogInterceptor;
import com.tabuyos.microservice.oops.common.core.interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.config</i>
 *   <b>class: </b><i>CoreConfiguration</i>
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
 * @since 0.1.0 - 2/22/21 10:03 AM
 */
@Configuration
public class CoreConfiguration {
  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public SqlLogInterceptor sqlLogInterceptor() {
    return new SqlLogInterceptor();
  }


  @Bean
  @ConditionalOnMissingBean(HandlerInterceptor.class)
  @ConditionalOnProperty(prefix = "oops.token.interceptor", name = "enable", havingValue = "true")
  public TokenInterceptor tokenInterceptor() {
    return new TokenInterceptor();
  }
}
