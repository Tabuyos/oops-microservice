package com.tabuyos.microservice.oops.common.util.page;


import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util.page</i>
 *   <b>class: </b><i>PageUtil</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class PageUtil implements Serializable {

  @Serial
  private static final long serialVersionUID = 2133929300799657699L;

  /**
	 * The cur page.当前页
	 */
	private int currentPage = 1;

	/**
	 * The next page.下一页
	 */
	private int nextPage;

	/**
	 * The pre page. 上一页
	 */
	private int prePage;

	/**
	 * The total row. 总条数
	 */
	private int totalRow;

	/**
	 * The page size.每页条数
	 */
	private int pageSize = 10;

	/**
	 * The total page.总页数
	 */
	private int totalPage;

	/**
	 * The start. 开始条数
	 */
	private int start;

	/**
	 * The buttons.
	 */
	private int[] buttons;

	/**
	 * 当前页条数
	 */
	private int curPageSize;

	/**
	 * Instantiates a new page util.
	 */
	public PageUtil() {

	}

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getNextPage() {
    return nextPage;
  }

  public void setNextPage(int nextPage) {
    this.nextPage = nextPage;
  }

  public int getPrePage() {
    return prePage;
  }

  public void setPrePage(int prePage) {
    this.prePage = prePage;
  }

  public int getTotalRow() {
    return totalRow;
  }

  public void setTotalRow(int totalRow) {
    this.totalRow = totalRow;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int[] getButtons() {
    return buttons;
  }

  public void setButtons(int[] buttons) {
    this.buttons = buttons;
  }

  public int getCurPageSize() {
    return curPageSize;
  }

  public void setCurPageSize(int curPageSize) {
    this.curPageSize = curPageSize;
  }

  /**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 */
	public PageUtil(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 * @param pageSize    the page size
	 */
	public PageUtil(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

  @Override
  public String toString() {
    return "PageUtil{" +
      "currentPage=" + currentPage +
      ", nextPage=" + nextPage +
      ", prePage=" + prePage +
      ", totalRow=" + totalRow +
      ", pageSize=" + pageSize +
      ", totalPage=" + totalPage +
      ", start=" + start +
      ", buttons=" + Arrays.toString(buttons) +
      ", curPageSize=" + curPageSize +
      '}';
  }
}
