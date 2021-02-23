package com.tabuyos.microservice.oops.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>RecursionTreeUtil</i>
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
public class RecursionTreeUtil {
	/**
	 * Gets child tree nodes.
	 *
	 * @param list     the list
	 * @param parentId the parent id
	 *
	 * @return the child tree nodes
	 */
	public static List<TreeNode> getChildTreeNodes(List<TreeNode> list, Long parentId) {
		List<TreeNode> returnList = new ArrayList<>();

		for (TreeNode treeNode : list) {
			if (treeNode.getPid() == null) {
				continue;
			}

			if (Objects.equals(treeNode.getPid(), parentId)) {
				recursionFn(list, treeNode);
				returnList.add(treeNode);
			}
		}
		return returnList;
	}

	/**
	 * 递归列表
	 */
	private static void recursionFn(List<TreeNode> list, TreeNode node) {
		List<TreeNode> childList = getChildList(list, node);
		if (PublicUtil.isEmpty(childList)) {
			return;
		}
		node.setChildren(childList);
		for (TreeNode tChild : childList) {
			recursionFn(list, tChild);
		}
	}

	/**
	 * 得到子节点列表
	 */
	private static List<TreeNode> getChildList(List<TreeNode> list, TreeNode t) {
		List<TreeNode> tList = new ArrayList<>();

		for (TreeNode treeNode : list) {
			if (PublicUtil.isEmpty(treeNode.getPid())) {
				continue;
			}
			if (Objects.equals(treeNode.getPid(), t.getId())) {
				tList.add(treeNode);
			}
		}
		return tList;
	}
}
