package com.tabuyos.microservice.oops.security.core;

import org.apache.commons.lang.StringUtils;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core
 *   <b>class: </b>SecurityResult
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 10:39 AM
 */
public class SecurityResult {

  /** 成功码. */
  public static final int SUCCESS_CODE = 200;

  /** 成功信息. */
  public static final String SUCCESS_MESSAGE = "操作成功";

  /** 错误码. */
  public static final int ERROR_CODE = 500;

  /** 错误信息. */
  public static final String ERROR_MESSAGE = "内部异常";

  /** 状态码 */
  private Integer code;

  /** 提示信息 */
  private String message;

  /** 结果 */
  private Object result;

  public static SecurityResult ok(Object data) {
    return new SecurityResult(data);
  }

  public static SecurityResult ok() {
    return new SecurityResult(null);
  }

  public static SecurityResult error(String message) {
    return error(message, null);
  }

  public static SecurityResult error(String message, Object data) {
    return new SecurityResult(
        ERROR_CODE, StringUtils.isEmpty(message) ? ERROR_MESSAGE : message, data);
  }

  public SecurityResult(Integer code, String message, Object result) {
    this.code = code;
    this.message = message;
    this.result = result;
  }

  private SecurityResult(Object result) {
    this.code = SUCCESS_CODE;
    this.message = SUCCESS_MESSAGE;
    this.result = result;
  }

  public SecurityResult() {
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "SecurityResult{" +
      "code=" + code +
      ", message='" + message + '\'' +
      ", result=" + result +
      '}';
  }
}
