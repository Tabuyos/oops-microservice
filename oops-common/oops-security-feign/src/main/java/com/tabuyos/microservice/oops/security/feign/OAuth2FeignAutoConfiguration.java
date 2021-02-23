package com.tabuyos.microservice.oops.security.feign;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.security.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.security.feign</i>
 *   <b>class: </b><i>OAuth2FeignAutoConfiguration</i>
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
 * @since 0.1.0 - 2/22/21 2:17 PM
 */
@Configuration
@EnableConfigurationProperties(Oauth2ClientProperties.class)
public class OAuth2FeignAutoConfiguration {


  private final Oauth2ClientProperties oauth2ClientProperties;

  /**
   * Instantiates a new O auth 2 feign auto configuration.
   *
   * @param oauth2ClientProperties the oauth 2 client properties
   */
  @Autowired
  public OAuth2FeignAutoConfiguration(Oauth2ClientProperties oauth2ClientProperties) {
    this.oauth2ClientProperties = oauth2ClientProperties;
  }

//  /**
//   * Resource details client credentials resource details.
//   *
//   * @return the client credentials resource details
//   */
//  @Bean("paascloudClientCredentialsResourceDetails")
//  public ClientCredentialsResourceDetails resourceDetails() {
//    ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
//    details.setId(oauth2ClientProperties.getId());
//    details.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUrl());
//    details.setClientId(oauth2ClientProperties.getClientId());
//    details.setClientSecret(oauth2ClientProperties.getClientSecret());
//    details.setAuthenticationScheme(AuthenticationScheme.valueOf(oauth2ClientProperties.getClientAuthenticationScheme()));
//    return details;
//  }
//
//  /**
//   * O auth 2 rest template o auth 2 rest template.
//   *
//   * @return the o auth 2 rest template
//   */
//  @Bean("paascloudOAuth2RestTemplate")
//  public OAuth2RestTemplate oAuth2RestTemplate() {
//    final OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails(), new DefaultOAuth2ClientContext());
//    oAuth2RestTemplate.setRequestFactory(new Netty4ClientHttpRequestFactory());
//    return oAuth2RestTemplate;
//  }
//
//  /**
//   * Oauth 2 feign request interceptor request interceptor.
//   *
//   * @param oAuth2RestTemplate the o auth 2 rest template
//   *
//   * @return the request interceptor
//   */
//  @Bean
//  public RequestInterceptor oauth2FeignRequestInterceptor(@Qualifier("paascloudOAuth2RestTemplate") OAuth2RestTemplate oAuth2RestTemplate) {
//    return new OAuth2FeignRequestInterceptor(oAuth2RestTemplate);
//  }

  /**
   * Feign logger level logger . level.
   *
   * @return the logger . level
   */
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  /*
   * To disable Hystrix support on a per-client basis create a vanilla Feign.Builder with the "prototype" scope, e.g.:
   */
//	@Bean
//	@Scope("prototype")
//	public Feign.Builder feignBuilder() {
//		return Feign.builder();
//	}

  @Bean
  public ErrorDecoder errorDecoder() {
    return new Oauth2FeignErrorInterceptor();
  }
}
