package com.tabuyos.microservice.oops.security.core.validate.code;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeProcessorHolder
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
@Component
public class ValidateCodeProcessorHolder {
  private final Map<String, ValidateCodeProcessor> validateCodeProcessors;

  /**
   * Instantiates a new Validate code processor holder.
   *
   * @param validateCodeProcessors the validate code processors
   */
  @Autowired
  public ValidateCodeProcessorHolder(Map<String, ValidateCodeProcessor> validateCodeProcessors) {
    this.validateCodeProcessors = validateCodeProcessors;
  }

  /**
   * Find validate code processor validate code processor.
   *
   * @param type the type
   *
   * @return validate code processor
   */
  ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
    return findValidateCodeProcessor(type.toString().toLowerCase());
  }

  /**
   * Find validate code processor validate code processor.
   *
   * @param type the type
   *
   * @return validate code processor
   */
  ValidateCodeProcessor findValidateCodeProcessor(String type) {
    String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
    ValidateCodeProcessor processor = validateCodeProcessors.get(name);
    if (processor == null) {
      throw new ValidateCodeException("验证码处理器" + name + "不存在");
    }
    return processor;
  }
}
