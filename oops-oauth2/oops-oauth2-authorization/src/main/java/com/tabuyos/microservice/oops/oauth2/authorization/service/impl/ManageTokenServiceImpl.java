package com.tabuyos.microservice.oops.oauth2.authorization.service.impl;

import com.tabuyos.microservice.oops.oauth2.authorization.service.ManageTokenService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.authorization.service.impl
 *   <b>class: </b>ManageTokenServiceImpl
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
 * @since 0.1.0 - 3/3/21 4:07 PM
 */
@Service
public class ManageTokenServiceImpl implements ManageTokenService {

  @Override
  public OAuth2AccessToken createAccessToken(
    OAuth2Authentication authentication) throws AuthenticationException {
    return null;
  }

  @Override
  public OAuth2AccessToken refreshAccessToken(String refreshToken,
    TokenRequest tokenRequest) throws AuthenticationException {
    return null;
  }

  @Override
  public OAuth2AccessToken getAccessToken(
    OAuth2Authentication authentication) {
    return null;
  }
}
