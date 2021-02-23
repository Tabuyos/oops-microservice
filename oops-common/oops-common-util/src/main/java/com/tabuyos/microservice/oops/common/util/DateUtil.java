package com.tabuyos.microservice.oops.common.util;

import cn.hutool.core.date.DateField;

import java.util.Date;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>DateUtil</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class DateUtil {

  /**
   * 获取系统前时间.
   *
   * @param minute the minute
   * @return the before time[yyyy-MM-dd HH:mm:ss]
   */
  public static String getBeforeTime(int minute) {
    Date newDate = cn.hutool.core.date.DateUtil.offset(new Date(), DateField.MINUTE, -minute);
    return cn.hutool.core.date.DateUtil.formatDateTime(newDate);
  }
}
