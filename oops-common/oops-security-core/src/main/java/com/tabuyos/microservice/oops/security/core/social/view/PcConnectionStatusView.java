package com.tabuyos.microservice.oops.security.core.social.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.view
 *   <b>class: </b>PcConnectionStatusView
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 * <pre><b>email: </b>tabuyos@outlook.com</pre>
 * <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:25 PM
 */
@Component("connect/status")
public class PcConnectionStatusView extends AbstractView {

  private final ObjectMapper objectMapper;

  public PcConnectionStatusView(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Render merged output model.
   *
   * @param model    the model
   * @param request  the request
   * @param response the response
   *
   * @throws Exception the exception
   */
  @SuppressWarnings("unchecked")
  @Override
  protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
    HttpServletResponse response) throws Exception {

    Map<String, List<Connection<?>>> connections = (Map<String, List<Connection<?>>>) model.get("connectionMap");

    Map<String, Boolean> result = new HashMap<>(8);
    for (String key : connections.keySet()) {
      result.put(key, CollectionUtils.isNotEmpty(connections.get(key)));
    }

    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(objectMapper.writeValueAsString(result));
  }

}
