package com.tabuyos.microservice.oops.common.core.annotation;

import com.tabuyos.microservice.oops.common.core.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.annotation</i>
 *   <b>class: </b><i>LogAnnotation</i>
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
 * @since 0.1.0 - 2/22/21 9:44 AM
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
  /**
   * 日志类型
   *
   * @return the log type enum
   */
  LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;

  /**
   * 是否保存请求的参数
   *
   * @return the boolean
   */
  boolean isSaveRequestData() default false;

  /**
   * 是否保存响应的结果
   *
   * @return the boolean
   */
  boolean isSaveResponseData() default false;
}
