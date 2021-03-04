package com.tabuyos.microservice.oops.security.core.validate.code;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import com.tabuyos.microservice.oops.security.core.properties.SecurityProperties;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeFilter
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
 * @since 0.1.0 - 3/1/21 4:44 PM
 */
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
  private final Logger log = LoggerFactory.getLogger(ValidateCodeFilter.class);
  /**
   * 验证码校验失败处理器
   */
  @Resource
  private AuthenticationFailureHandler authenticationFailureHandler;
  /**
   * 系统配置信息
   */
  @Autowired
  private SecurityProperties securityProperties;
  /**
   * 系统中的校验码处理器
   */
  @Resource
  private ValidateCodeProcessorHolder validateCodeProcessorHolder;
  /**
   * 存放所有需要校验验证码的url
   */
  private Map<String, ValidateCodeType> urlMap = new HashMap<>();
  /**
   * 验证请求url与配置的url是否匹配的工具类
   */
  private AntPathMatcher pathMatcher = new AntPathMatcher();

  private static final String GET = "get";

  /**
   * 初始化要拦截的url配置信息
   *
   * @throws ServletException the servlet exception
   */
  @Override
  public void afterPropertiesSet() throws ServletException {
    super.afterPropertiesSet();

    urlMap.put(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
    addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeType.IMAGE);

    urlMap.put(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
    addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeType.SMS);
    addUrlToMap(securityProperties.getCode().getEmail().getUrl(), ValidateCodeType.EMAIL);
  }

  /**
   * 讲系统中配置的需要校验验证码的URL根据校验的类型放入map
   *
   * @param urlString the url string
   * @param type      the type
   */
  private void addUrlToMap(String urlString, ValidateCodeType type) {
    if (StringUtils.isNotBlank(urlString)) {
      String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
      for (String url : urls) {
        urlMap.put(url, type);
      }
    }
  }

  /**
   * Do filter internal.
   *
   * @param request  the request
   * @param response the response
   * @param chain    the chain
   *
   * @throws ServletException the servlet exception
   * @throws IOException      the io exception
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {

    ValidateCodeType type = getValidateCodeType(request);
    if (type != null) {
      logger.info("校验请求(" + request.getRequestURI() + ")中的验证码,验证码类型" + type);
      try {
        validateCodeProcessorHolder.findValidateCodeProcessor(type).validate(new ServletWebRequest(request, response));
        logger.info("验证码校验通过");
      } catch (ValidateCodeException exception) {
        authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
        return;
      }
    }

    chain.doFilter(request, response);

  }

  /**
   * 获取校验码的类型，如果当前请求不需要校验，则返回null
   */
  private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
    ValidateCodeType result = null;
    if (!StringUtils.equalsIgnoreCase(request.getMethod(), GET)) {
      Set<String> urls = urlMap.keySet();
      for (String url : urls) {
        if (pathMatcher.match(url, request.getRequestURI())) {
          result = urlMap.get(url);
        }
      }
    }
    return result;
  }
}
