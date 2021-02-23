package com.tabuyos.microservice.oops.common.zk.registry.exception;

import java.io.Serial;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry.exception</i>
 *   <b>class: </b><i>RegException</i>
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
 * @since 0.1.0 - 2/22/21 1:56 PM
 */
public final class RegException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -6417179023552012152L;

  /**
   * Instantiates a new Reg exception.
   *
   * @param errorMessage the error message
   * @param args         the args
   */
  public RegException(final String errorMessage, final Object... args) {
    super(String.format(errorMessage, args));
  }

  /**
   * Instantiates a new Reg exception.
   *
   * @param cause the cause
   */
  public RegException(final Exception cause) {
    super(cause);
  }
}
