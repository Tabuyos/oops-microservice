package com.tabuyos.microservice.oops.common.core.support;

import com.tabuyos.microservice.oops.common.base.dto.BaseTree;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.support</i>
 *   <b>class: </b><i>ITree</i>
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
 * @since 0.1.0 - 2/22/21 1:34 PM
 */
public interface ITree<T extends BaseTree<T, ID>, ID extends Serializable> {
  /**
   * 获得指定节点下所有归档
   *
   * @param list     the list
   * @param parentId the parent id
   *
   * @return the child tree objects
   */
  List<T> getChildTreeObjects(List<T> list, ID parentId);

  /**
   * 递归列表
   *
   * @param list the list
   * @param t    the t
   */
  void recursionFn(List<T> list, T t);

  /**
   * 获得指定节点下的所有子节点
   *
   * @param list the list
   * @param t    the t
   *
   * @return the child list
   */
  List<T> getChildList(List<T> list, T t);

  /**
   * 判断是否还有下一个子节点
   *
   * @param list the list
   * @param t    the t
   *
   * @return the boolean
   */
  boolean hasChild(List<T> list, T t);
}
