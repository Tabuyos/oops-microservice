package com.tabuyos.microservice.oops.common.util;


import java.util.List;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>TreeNode</i>
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
public class TreeNode {
	/**
	 * 节点编码
	 */
	private String nodeCode;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 父ID
	 */
	private Long pid;
	/**
	 * 孩子节点信息
	 */
	private List<TreeNode> children;

  public String getNodeCode() {
    return nodeCode;
  }

  public void setNodeCode(String nodeCode) {
    this.nodeCode = nodeCode;
  }

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public List<TreeNode> getChildren() {
    return children;
  }

  public void setChildren(List<TreeNode> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
      "nodeCode='" + nodeCode + '\'' +
      ", nodeName='" + nodeName + '\'' +
      ", id=" + id +
      ", pid=" + pid +
      ", children=" + children +
      '}';
  }
}
