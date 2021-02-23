package com.tabuyos.microservice.oops.common.util.exception;

import java.io.Serial;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util.exception</i>
 *   <b>class: </b><i>HttpAesException</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class HttpAesException extends IllegalArgumentException {
  @Serial
  private static final long serialVersionUID = -2489600753056921095L;

  /**
   * Instantiates a new Http aes exception.
   *
   * @param message the message
   */
  public HttpAesException(String message) {
    super(message);
  }

  /** Instantiates a new Http aes exception. */
  public HttpAesException() {}
}
