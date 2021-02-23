package com.tabuyos.microservice.oops.common.util.wrapper;

import com.tabuyos.microservice.oops.common.util.page.PageUtil;

import java.io.Serial;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util.wrapper</i>
 *   <b>class: </b><i>PageWrapper</i>
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
public class PageWrapper<T> extends Wrapper<T> {

	@Serial
  private static final long serialVersionUID = 666985064788933395L;

	private PageUtil pageUtil;


	/**
	 * Instantiates a new Page wrapper.
	 */
	PageWrapper() {
		super();
	}


	/**
	 * Instantiates a new Page wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public PageWrapper(int code, String message) {
		super(code, message);
	}

	/**
	 * Instantiates a new pageWrapper default code=200
	 *
	 * @param result   the result
	 * @param pageUtil the page util
	 */
	public PageWrapper(T result, PageUtil pageUtil) {
		super();
		this.setResult(result);
		this.setPageUtil(pageUtil);
	}

	/**
	 * Instantiates a new Page wrapper.
	 *
	 * @param code     the code
	 * @param message  the message
	 * @param result   the result
	 * @param pageUtil the page util
	 */
	PageWrapper(int code, String message, T result, PageUtil pageUtil) {
		super(code, message, result);
		this.pageUtil = pageUtil;
	}

	/**
	 * Sets the 分页数据 , 返回自身的引用.
	 *
	 * @param pageUtil the page util
	 *
	 * @return the page wrapper
	 */
	public PageWrapper<T> pageUtil(PageUtil pageUtil) {
		this.setPageUtil(pageUtil);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the result
	 *
	 * @return the page wrapper
	 */
	@Override
	public PageWrapper<T> result(T result) {
		super.setResult(result);
		return this;
	}

  public PageUtil getPageUtil() {
    return pageUtil;
  }

  public void setPageUtil(PageUtil pageUtil) {
    this.pageUtil = pageUtil;
  }

  @Override
  public String toString() {
    return "PageWrapper{" +
      "pageUtil=" + pageUtil +
      '}';
  }
}
