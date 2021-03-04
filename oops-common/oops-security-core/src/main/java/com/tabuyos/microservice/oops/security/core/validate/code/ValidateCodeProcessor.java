package com.tabuyos.microservice.oops.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeProcessor
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
 * @since 0.1.0 - 3/1/21 4:53 PM
 */
public interface ValidateCodeProcessor {
  /**
   * 创建校验码
   *
   * @param request the request
   *
   * @throws Exception the exception
   */
  void create(ServletWebRequest request) throws Exception;

  /**
   * 校验验证码(验证后删除)
   *
   * @param servletWebRequest the servlet web request
   */
  void validate(ServletWebRequest servletWebRequest);

  /**
   * 校验验证码(验证后不删除)
   *
   * @param servletWebRequest the servlet web request
   */
  void check(ServletWebRequest servletWebRequest);
}
