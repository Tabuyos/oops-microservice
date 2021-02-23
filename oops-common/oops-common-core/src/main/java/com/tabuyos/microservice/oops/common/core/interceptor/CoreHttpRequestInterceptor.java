package com.tabuyos.microservice.oops.common.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.interceptor</i>
 *   <b>class: </b><i>CoreHttpRequestInterceptor</i>
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
 * @since 0.1.0 - 2/22/21 1:20 PM
 */
public class CoreHttpRequestInterceptor implements ClientHttpRequestInterceptor {

  private final Logger log = LoggerFactory.getLogger(CoreHttpRequestInterceptor.class);

  /**
   * Intercept client http response.
   *
   * @param request the request
   * @param body the body
   * @param execution the execution
   * @return the client http response
   * @throws IOException the io exception
   */
  @Override
  public ClientHttpResponse intercept(
      HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);

    String header =
        StringUtils.collectionToDelimitedString(
            CoreHeaderInterceptor.LABEL.get(), CoreHeaderInterceptor.HEADER_LABEL_SPLIT);
    log.info("header={} ", header);
    requestWrapper.getHeaders().add(CoreHeaderInterceptor.HEADER_LABEL, header);

    return execution.execute(requestWrapper, body);
  }
}
