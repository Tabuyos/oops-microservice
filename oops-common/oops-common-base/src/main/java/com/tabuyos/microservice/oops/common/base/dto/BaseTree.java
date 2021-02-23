package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>BaseTree</i>
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
 * @since 0.1.0 - 2/3/21 4:45 PM
 */
public class BaseTree<E, ID> implements Serializable {

  @Serial
  private static final long serialVersionUID = 2945678860116067148L;

  /**
   * ID
   */
  private ID id;

  /**
   * 父ID
   */
  private ID pid;

  /**
   * 是否含有子节点
   */
  private boolean hasChild = false;

  /**
   * 子节点集合
   */
  private List<E> children;

  public ID getId() {
    return id;
  }

  public void setId(ID id) {
    this.id = id;
  }

  public ID getPid() {
    return pid;
  }

  public void setPid(ID pid) {
    this.pid = pid;
  }

  public boolean isHasChild() {
    return hasChild;
  }

  public void setHasChild(boolean hasChild) {
    this.hasChild = hasChild;
  }

  public List<E> getChildren() {
    return children;
  }

  public void setChildren(List<E> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "BaseTree{" +
      "id=" + id +
      ", pid=" + pid +
      ", hasChild=" + hasChild +
      ", children=" + children +
      '}';
  }
}
