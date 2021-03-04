package com.tabuyos.microservice.oops.security.core.validate.code;

import java.io.Serial;
import org.springframework.security.core.AuthenticationException;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeException
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
public class ValidateCodeException extends AuthenticationException {

  @Serial
  private static final long serialVersionUID = -9153829356907759464L;

  /**
   * Instantiates a new Validate code exception.
   *
   * @param msg the msg
   */
  public ValidateCodeException(String msg) {
    super(msg);
  }
}
