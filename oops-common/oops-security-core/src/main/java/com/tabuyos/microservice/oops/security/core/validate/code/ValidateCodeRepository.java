package com.tabuyos.microservice.oops.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeRepository
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
 * @since 0.1.0 - 3/1/21 4:54 PM
 */
public interface ValidateCodeRepository {
  /**
   * 保存验证码
   *
   * @param request          the request
   * @param code             the code
   * @param validateCodeType the validate code type
   */
  void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

  /**
   * 获取验证码
   *
   * @param request          the request
   * @param validateCodeType the validate code type
   *
   * @return validate code
   */
  ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

  /**
   * 移除验证码
   *
   * @param request  the request
   * @param codeType the code type
   */
  void remove(ServletWebRequest request, ValidateCodeType codeType);
}
