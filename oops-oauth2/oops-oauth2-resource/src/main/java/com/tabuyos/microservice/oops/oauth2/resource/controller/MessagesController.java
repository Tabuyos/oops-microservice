package com.tabuyos.microservice.oops.oauth2.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.resource.controller
 *   <b>class: </b>MessagesController
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
 * @since 0.1.0 - 3/4/21 11:08 AM
 */
@RestController
public class MessagesController {

  @GetMapping("/messages")
  public String[] getMessages() {
    return new String[] {"Message 1", "Message 2", "Message 3"};
  }
}
