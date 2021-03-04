package com.tabuyos.microservice.oops.security.core.social.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.view
 *   <b>class: </b>PcConnectView
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:24 PM
 */
public class PcConnectView extends AbstractView {
  private static final String CONNECTIONS = "connections";

  /**
   * Render merged output model.
   *
   * @param model the model
   * @param request the request
   * @param response the response
   * @throws Exception the exception
   */
  @Override
  protected void renderMergedOutputModel(
      Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    response.setContentType("text/html;charset=UTF-8");
    if (model.get(CONNECTIONS) == null) {
      response.getWriter().write("<h3>解绑成功</h3>");
    } else {
      response.getWriter().write("<h3>绑定成功</h3>");
    }
  }
}
