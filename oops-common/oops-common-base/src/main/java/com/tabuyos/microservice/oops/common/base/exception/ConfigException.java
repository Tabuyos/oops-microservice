package com.tabuyos.microservice.oops.common.base.exception;

import java.io.Serial;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.exception</i>
 *   <b>class: </b><i>ConfigException</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/3/21 4:30 PM
 */
public class ConfigException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 6480772904575978373L;

  /**
   * Instantiates a new Config exception.
   *
   * @param message the message
   */
  public ConfigException(String message) {
    super(message);
  }

  /** Instantiates a new Config exception. */
  public ConfigException() {
    super();
  }
}
