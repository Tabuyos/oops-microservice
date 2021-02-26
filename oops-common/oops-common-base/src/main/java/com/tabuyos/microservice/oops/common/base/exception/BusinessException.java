package com.tabuyos.microservice.oops.common.base.exception;

import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;

import java.io.Serial;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.exception</i>
 *   <b>class: </b><i>BusinessException</i>
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
public class BusinessException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -1087797720827444564L;

  /**
   * 异常码
   */
  protected int code;

  public BusinessException() {
    super();
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public BusinessException(int code, String msgFormat, Object... args) {
    super(String.format(msgFormat, args));
    this.code = code;
  }

  public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
    super(String.format(codeEnum.message(), args));
    this.code = codeEnum.code();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
