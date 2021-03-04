package com.tabuyos.microservice.oops.security.core.social.weixin.connect;

import java.io.Serial;
import org.springframework.social.oauth2.AccessGrant;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.weixin.connect
 *   <b>class: </b>WeixinAccessGrant
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
 * @since 0.1.0 - 3/1/21 4:32 PM
 */
public class WeixinAccessGrant extends AccessGrant {

  @Serial
  private static final long serialVersionUID = -7975047793354135806L;

  private String openId;

  /**
   * Instantiates a new Weixin access grant.
   */
  public WeixinAccessGrant() {
    super("");
  }

  /**
   * Instantiates a new Weixin access grant.
   *
   * @param accessToken  the access token
   * @param scope        the scope
   * @param refreshToken the refresh token
   * @param expiresIn    the expires in
   */
  public WeixinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
    super(accessToken, scope, refreshToken, expiresIn);
  }

  /**
   * Gets open id.
   *
   * @return the openId
   */
  public String getOpenId() {
    return openId;
  }

  /**
   * Sets open id.
   *
   * @param openId the openId to set
   */
  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
