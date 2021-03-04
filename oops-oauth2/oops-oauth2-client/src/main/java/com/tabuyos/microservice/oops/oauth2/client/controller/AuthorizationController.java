package com.tabuyos.microservice.oops.oauth2.client.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.client.controller
 *   <b>class: </b>AuthorizationController
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
 * @since 0.1.0 - 3/4/21 1:18 PM
 */
@Controller
public class AuthorizationController {
  @Value("${messages.base-uri}")
  private String messagesBaseUri;

  @Autowired
  @Qualifier("messagingClientAuthCodeRestTemplate")
  private OAuth2RestTemplate messagingClientAuthCodeRestTemplate;

  @Autowired
  @Qualifier("messagingClientClientCredsRestTemplate")
  private OAuth2RestTemplate messagingClientClientCredsRestTemplate;

  @Autowired
  @Qualifier("messagingClientPasswordRestTemplate")
  private OAuth2RestTemplate messagingClientPasswordRestTemplate;


  @GetMapping(value = "/authorize", params = "grant_type=authorization_code")
  public String authorization_code_grant(Model model) {
    String[] messages = this.messagingClientAuthCodeRestTemplate.getForObject(this.messagesBaseUri, String[].class);
    model.addAttribute("messages", messages);
    return "index";
  }

  @GetMapping(value = "/token")
  public String token(Model model) {
    OAuth2AccessToken accessToken = this.messagingClientAuthCodeRestTemplate.getAccessToken();
    System.out.println(accessToken);
    System.out.println(accessToken.getValue());
    System.out.println(accessToken.isExpired());
    System.out.println(accessToken.getTokenType());
    System.out.println(accessToken.getScope());
    System.out.println(accessToken.getExpiration());
    System.out.println(accessToken.getAdditionalInformation());
    System.out.println(accessToken.getExpiresIn());
    model.addAttribute("token", accessToken);
    return "index";
  }

  // registered redirect_uri for authorization_code
  @GetMapping("/authorized")
  public String authorized(Model model) {
    String[] messages = this.messagingClientAuthCodeRestTemplate.getForObject(this.messagesBaseUri, String[].class);
    model.addAttribute("messages", messages);
    return "index";
  }

  @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
  public String client_credentials_grant(Model model) {
    String[] messages = this.messagingClientClientCredsRestTemplate.getForObject(this.messagesBaseUri, String[].class);
    model.addAttribute("messages", messages);
    return "index";
  }

  @PostMapping(value = "/authorize", params = "grant_type=password")
  public String password_grant(Model model, HttpServletRequest request) {
    ResourceOwnerPasswordResourceDetails passwordResourceDetails =
      (ResourceOwnerPasswordResourceDetails) this.messagingClientPasswordRestTemplate.getResource();
    passwordResourceDetails.setUsername(request.getParameter("username"));
    passwordResourceDetails.setPassword(request.getParameter("password"));

    String[] messages = this.messagingClientPasswordRestTemplate.getForObject(this.messagesBaseUri, String[].class);
    model.addAttribute("messages", messages);

    // Never store the user's credentials
    passwordResourceDetails.setUsername(null);
    passwordResourceDetails.setPassword(null);

    return "index";
  }
}
