package com.tabuyos.microservice.oops.security.core.validate.code.email;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCode;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeGenerator;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeRepository;
import com.tabuyos.microservice.oops.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.email
 *   <b>class: </b>EmailCodeProcessor
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
 * @since 0.1.0 - 3/1/21 5:04 PM
 */
@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
  /**
   * 短信验证码发送器
   */
  @Resource
  private EmailCodeSender emailCodeSender;

  /**
   * Instantiates a new Abstract validate code processor.
   *
   * @param validateCodeGenerators the validate code generators
   * @param validateCodeRepository the validate code repository
   */
  public EmailCodeProcessor(Map<String, ValidateCodeGenerator> validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
    super(validateCodeGenerators, validateCodeRepository);
  }

  /**
   * Send.
   *
   * @param request      the request
   * @param validateCode the validate code
   *
   * @throws Exception the exception
   */
  @Override
  protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
    String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_EMAIL;
    String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
    emailCodeSender.send(email, validateCode.getCode());
  }
}
