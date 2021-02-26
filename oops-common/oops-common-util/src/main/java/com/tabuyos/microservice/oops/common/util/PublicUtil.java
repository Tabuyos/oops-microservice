package com.tabuyos.microservice.oops.common.util;

import java.util.Collection;
import java.util.Map;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>PublicUtil</i>
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
public class PublicUtil {

  /**
   * 判断对象是否Empty(null或元素为0) 实用于对如下对象做判断:String Collection及其子类 Map及其子类
   *
   * @param pObj 待检查对象
   * @return boolean 返回的布尔值
   */
  public static boolean isEmpty(Object pObj) {
    if (pObj == null) {
      return true;
    }
    if (pObj == "") {
      return true;
    }
    if (pObj instanceof String) {
      return ((String) pObj).length() == 0;
    } else if (pObj instanceof Collection) {
      return ((Collection) pObj).isEmpty();
    } else if (pObj instanceof Map) {
      return ((Map) pObj).size() == 0;
    }
    return false;
  }

  /**
   * 判断对象是否为NotEmpty(!null或元素大于0) 实用于对如下对象做判断:String Collection及其子类 Map及其子类
   *
   * @param pObj 待检查对象
   * @return boolean 返回的布尔值
   */
  public static boolean isNotEmpty(Object pObj) {
//    if (pObj == null) {
//      return false;
//    }
//    if (pObj == "") {
//      return false;
//    }
//    if (pObj instanceof String) {
//      return ((String) pObj).length() != 0;
//    } else if (pObj instanceof Collection) {
//      return !((Collection) pObj).isEmpty();
//    } else if (pObj instanceof Map) {
//      return ((Map) pObj).size() != 0;
//    }
    return !isEmpty(pObj);
  }
}
