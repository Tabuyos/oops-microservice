package com.tabuyos.microservice.oops.security.core.validate.code.email;

import com.tabuyos.microservice.oops.security.core.properties.SecurityProperties;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCode;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeGenerator;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.email
 *   <b>class: </b>EmailCodeGenerator
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
 * @since 0.1.0 - 3/1/21 5:03 PM
 */
@Component("emailValidateCodeGenerator")
public class EmailCodeGenerator implements ValidateCodeGenerator {
  private final Logger log = LoggerFactory.getLogger(DefaultEmailCodeSender.class);

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * Generate validate code.
   *
   * @param request the request
   *
   * @return the validate code
   */
  @Override
  public ValidateCode generate(ServletWebRequest request) {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
    String[] emails = parameterMap.get("email");
    log.info(Arrays.toString(emails));
    String code = Arrays.toString(emails);
    return new ValidateCode(code, securityProperties.getCode().getEmail().getExpireIn());
  }
}
