package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>SocialProperties
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
 * @since 0.1.0 - 3/1/21 11:06 AM
 */
public class SocialProperties {
  /**
   * 社交登录功能拦截的url
   */
  private String filterProcessesUrl = "/auth";

  private QQProperties qq = new QQProperties();

  private WeixinProperties weixin = new WeixinProperties();

  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  public QQProperties getQq() {
    return qq;
  }

  public void setQq(QQProperties qq) {
    this.qq = qq;
  }

  public WeixinProperties getWeixin() {
    return weixin;
  }

  public void setWeixin(WeixinProperties weixin) {
    this.weixin = weixin;
  }

  @Override
  public String toString() {
    return "SocialProperties{" +
      "filterProcessesUrl='" + filterProcessesUrl + '\'' +
      ", qq=" + qq +
      ", weixin=" + weixin +
      '}';
  }
}
