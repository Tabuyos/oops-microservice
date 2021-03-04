package com.tabuyos.microservice.oops.security.core.properties;

import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>SecurityProperties
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
 * @since 0.1.0 - 3/1/21 11:02 AM
 */
@ConfigurationProperties(prefix = GlobalConstant.OOPS_SECURITY_PREFIX)
public class SecurityProperties {
  /**
   * 浏览器环境配置
   */
  private BrowserProperties browser = new BrowserProperties();
  /**
   * 验证码配置
   */
  private ValidateCodeProperties code = new ValidateCodeProperties();
  /**
   * 社交登录配置
   */
  private SocialProperties social = new SocialProperties();
  /**
   * OAuth2认证服务器配置
   */
  private OAuth2Properties oauth2 = new OAuth2Properties();

  /**
   * Gets browser.
   *
   * @return the browser
   */
  public BrowserProperties getBrowser() {
    return browser;
  }

  /**
   * Sets browser.
   *
   * @param browser the browser
   */
  public void setBrowser(BrowserProperties browser) {
    this.browser = browser;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public ValidateCodeProperties getCode() {
    return code;
  }

  /**
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(ValidateCodeProperties code) {
    this.code = code;
  }

  /**
   * Gets social.
   *
   * @return the social
   */
  public SocialProperties getSocial() {
    return social;
  }

  /**
   * Sets social.
   *
   * @param social the social
   */
  public void setSocial(SocialProperties social) {
    this.social = social;
  }

  /**
   * Gets oauth 2.
   *
   * @return the oauth 2
   */
  public OAuth2Properties getOauth2() {
    return oauth2;
  }

  /**
   * Sets oauth 2.
   *
   * @param oauth2 the oauth 2
   */
  public void setOauth2(OAuth2Properties oauth2) {
    this.oauth2 = oauth2;
  }
}
