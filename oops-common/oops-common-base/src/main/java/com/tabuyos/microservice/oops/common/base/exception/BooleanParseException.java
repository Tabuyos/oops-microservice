package com.tabuyos.microservice.oops.common.base.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.exception</i>
 *   <b>class: </b><i>BooleanParseException</i>
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 * <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 * <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 * <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/3/21 4:30 PM
 */
public class BooleanParseException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 7537665235472457550L;

  /**
   * Instantiates a new Boolean parse exception.
   */
  public BooleanParseException() {
    super();
  }

  /**
   * Instantiates a new Boolean parse exception.
   *
   * @param message the message
   */
  public BooleanParseException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Boolean parse exception.
   *
   * @param message the message
   * @param cause   the cause
   */
  public BooleanParseException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new Boolean parse exception.
   *
   * @param cause the cause
   */
  public BooleanParseException(Throwable cause) {
    super(cause);
  }
}
