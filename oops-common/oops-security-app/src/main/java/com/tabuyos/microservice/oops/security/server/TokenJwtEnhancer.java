//package com.tabuyos.microservice.oops.security.server;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//
///**
// * Description:
// *
// * <pre>
// *   <b>project: </b>oops-microservice
// *   <b>package: </b>com.tabuyos.microservice.oops.security.server
// *   <b>class: </b>TokenJwtEnhancer
// *   comment here.
// * </pre>
// *
// * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
// * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
// * <pre><b>email: </b>tabuyos@outlook.com</pre>
// * <pre><b>description: </b>
// *       <pre>
// *         Talk is cheap, show me the code.
// *       </pre>
// *     </pre>
// * @version 0.1.0
// * @since 0.1.0 - 3/1/21 5:33 PM
// */
//public class TokenJwtEnhancer  implements TokenEnhancer {
//  /**
//   * Enhance o auth 2 access token.
//   *
//   * @param accessToken          the access token
//   * @param oAuth2Authentication the o auth 2 authentication
//   *
//   * @return the o auth 2 access token
//   */
//  @Override
//  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oAuth2Authentication) {
//    Map<String, Object> info = new HashMap<>(8);
//    info.put("timestamp", System.currentTimeMillis());
//    Authentication authentication = oAuth2Authentication.getUserAuthentication();
//    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
//      Object principal = authentication.getPrincipal();
//      info.put("loginName", ((UserDetails) principal).getUsername());
//    }
//
//    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
//
//    return accessToken;
//  }
//
//}
