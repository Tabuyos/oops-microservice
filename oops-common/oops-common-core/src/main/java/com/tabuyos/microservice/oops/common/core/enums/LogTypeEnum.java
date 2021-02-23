package com.tabuyos.microservice.oops.common.core.enums;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.enums</i>
 *   <b>class: </b><i>LogTypeEnum</i>
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
 * @since 0.1.0 - 2/22/21 9:48 AM
 */
public enum LogTypeEnum {

  /**
   * 操作日志
   */
  OPERATION_LOG("10", "操作日志"),
  /**
   * 登录日志
   */
  LOGIN_LOG("20", "登录日志"),
  /**
   * 异常日志
   */
  EXCEPTION_LOG("30", "异常日志");

  /**
   * The Type.
   */
  String type;
  /**
   * The Name.
   */
  String name;

  LogTypeEnum(String type, String name) {
    this.type = type;
    this.name = name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets name.
   *
   * @param type the type
   *
   * @return the name
   */
  public static String getName(String type) {
    for (LogTypeEnum ele : LogTypeEnum.values()) {
      if (type.equals(ele.getType())) {
        return ele.getName();
      }
    }
    return null;
  }

  /**
   * Gets enum.
   *
   * @param type the type
   *
   * @return the enum
   */
  public static LogTypeEnum getEnum(String type) {
    for (LogTypeEnum ele : LogTypeEnum.values()) {
      if (type.equals(ele.getType())) {
        return ele;
      }
    }
    return LogTypeEnum.OPERATION_LOG;
  }

  /**
   * Gets list.
   *
   * @return the list
   */
  public static List<Map<String, Object>> getList() {
    List<Map<String, Object>> list = Lists.newArrayList();
    for (LogTypeEnum ele : LogTypeEnum.values()) {
      Map<String, Object> map = Maps.newHashMap();
      map.put("key", ele.getType());
      map.put("value", ele.getName());
      list.add(map);
    }
    return list;
  }
}
