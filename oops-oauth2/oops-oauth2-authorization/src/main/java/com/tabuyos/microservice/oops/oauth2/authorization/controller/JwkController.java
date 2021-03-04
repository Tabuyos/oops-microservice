package com.tabuyos.microservice.oops.oauth2.authorization.controller;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.authorization.controller
 *   <b>class: </b>JwkController
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
 * @since 0.1.0 - 3/3/21 4:43 PM
 */
@RestController
public class JwkController {
  private final JWKSet jwkSet;

  public JwkController(JWKSet jwkSet) {
    this.jwkSet = jwkSet;
  }

  @GetMapping("/")
  public String index() {
    return "Tabuyos.";
  }

  @GetMapping(value = "/oauth2/keys", produces = MediaType.APPLICATION_JSON_VALUE)
  public String keys() {
    return this.jwkSet.toString();
  }
}
