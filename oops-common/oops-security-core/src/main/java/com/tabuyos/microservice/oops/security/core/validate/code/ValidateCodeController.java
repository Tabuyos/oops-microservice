package com.tabuyos.microservice.oops.security.core.validate.code;

import com.tabuyos.microservice.oops.security.core.SecurityResult;
import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeController
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
 * @since 0.1.0 - 3/1/21 4:43 PM
 */
@RestController
public class ValidateCodeController {

  private final Logger log = LoggerFactory.getLogger(ValidateCodeController.class);

  @Resource
  private ValidateCodeProcessorHolder validateCodeProcessorHolder;

  /**
   * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
   *
   * @param request  the request
   * @param response the response
   * @param type     the type
   *
   * @throws Exception the exception
   */
  @PostMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
  public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
    validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
  }

  /**
   * Check code object.
   *
   * @param request  the request
   * @param response the response
   * @param type     the type
   *
   * @return the object
   */
  @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
  public Object checkCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
    SecurityResult result = new SecurityResult(SecurityResult.SUCCESS_CODE, "校验成功", true);
    try {
      validateCodeProcessorHolder.findValidateCodeProcessor(type).check(new ServletWebRequest(request, response));
    } catch (ValidateCodeException e) {
      result = SecurityResult.error(e.getMessage(), false);
    } catch (Exception e) {
      log.error("getAccessToken={}", e.getMessage(), e);
      result = SecurityResult.error("验证码错误", false);
    }
    return result;
  }
}
