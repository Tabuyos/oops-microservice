package com.tabuyos.microservice.oops.security.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.microservice.oops.security.core.validate.code.email.DefaultEmailCodeSender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.server
 *   <b>class: </b>PcAccessDeniedHandler
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
 * @since 0.1.0 - 3/1/21 5:27 PM
 */
@Configuration
public class PcAccessDeniedHandler  implements AccessDeniedHandler {
  private final Logger log = LoggerFactory.getLogger(PcAccessDeniedHandler.class);

  @Resource
  private ObjectMapper objectMapper;

  /**
   * Handle.
   *
   * @param request  the request
   * @param response the response
   * @param accessDeniedException        the e
   *
   * @throws IOException the json processing exception
   */
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
    AccessDeniedException accessDeniedException) throws IOException, ServletException {
    log.info("处理权限异常. e={0}", accessDeniedException);
    Map<String, Object> result = new HashMap<>(3);
    result.put("code", 99990401);
    result.put("message", "无访问权限");
    String json = objectMapper.writeValueAsString(result);
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(json);
  }
}
