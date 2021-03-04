package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>WeixinProperties
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
 * @since 0.1.0 - 3/1/21 11:07 AM
 */
public class WeixinProperties extends SocialProperties {
  /**
   * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
   */
  private String providerId = "weixin";

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  @Override
  public String toString() {
    return "WeixinProperties{" +
      "providerId='" + providerId + '\'' +
      '}';
  }
}
