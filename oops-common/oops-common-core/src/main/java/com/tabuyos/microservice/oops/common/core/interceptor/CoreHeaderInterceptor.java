package com.tabuyos.microservice.oops.common.core.interceptor;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.interceptor</i>
 *   <b>class: </b><i>CoreHeaderInterceptor</i>
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
 * @since 0.1.0 - 2/22/21 1:18 PM
 */
public class CoreHeaderInterceptor implements HandlerInterceptor {

  private static final Logger log = LoggerFactory.getLogger(CoreHeaderInterceptor.class);

  /** The constant HEADER_LABEL. */
  public static final String HEADER_LABEL = "x-label";
  /** The constant HEADER_LABEL_SPLIT. */
  public static final String HEADER_LABEL_SPLIT = ",";

  /** The constant LABEL. */
  public static final HystrixRequestVariableDefault<List<String>> LABEL =
      new HystrixRequestVariableDefault<>();

  private static void initHystrixRequestContext(String labels) {
    log.info("LABEL={}", labels);
    if (!HystrixRequestContext.isCurrentThreadInitialized()) {
      HystrixRequestContext.initializeContext();
    }

    if (!StringUtils.isEmpty(labels)) {
      CoreHeaderInterceptor.LABEL.set(
          Arrays.asList(labels.split(CoreHeaderInterceptor.HEADER_LABEL_SPLIT)));
    } else {
      CoreHeaderInterceptor.LABEL.set(Collections.emptyList());
    }
  }

  private static void shutdownHystrixRequestContext() {
    if (HystrixRequestContext.isCurrentThreadInitialized()) {
      HystrixRequestContext.getContextForCurrentThread().shutdown();
    }
  }

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    CoreHeaderInterceptor.initHystrixRequestContext(
        request.getHeader(CoreHeaderInterceptor.HEADER_LABEL));
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView) {
    CoreHeaderInterceptor.shutdownHystrixRequestContext();
  }
}
