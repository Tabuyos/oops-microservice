package com.tabuyos.microservice.oops.security.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.security.feign</i>
 *   <b>class: </b><i>OAuth2FeignRequestInterceptor</i>
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
 * @since 0.1.0 - 2/22/21 2:19 PM
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

  private final static Logger log = LoggerFactory.getLogger(OAuth2FeignRequestInterceptor.class);

  private static final String BEARER_TOKEN_TYPE = "bearer";

//  private final OAuth2RestTemplate oAuth2RestTemplate;
//
//  /**
//   * Instantiates a new O auth 2 feign request interceptor.
//   *
//   * @param oAuth2RestTemplate the o auth 2 rest template
//   */
//  OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
//    Assert.notNull(oAuth2RestTemplate, "Context can not be null");
//    this.oAuth2RestTemplate = oAuth2RestTemplate;
//  }

  /**
   * Apply.
   *
   * @param template the template
   */
  @Override
  public void apply(RequestTemplate template) {
//    log.debug("Constructing Header {} for Token {}", HttpHeaders.AUTHORIZATION, BEARER_TOKEN_TYPE);
//    template.header(HttpHeaders.AUTHORIZATION, String.format("%s %s", BEARER_TOKEN_TYPE, oAuth2RestTemplate.getAccessToken().toString()));
  }
}
