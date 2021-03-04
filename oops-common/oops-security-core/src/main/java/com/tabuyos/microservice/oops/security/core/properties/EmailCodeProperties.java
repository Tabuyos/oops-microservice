package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>EmailCodeProperties
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
 * @since 0.1.0 - 3/1/21 10:58 AM
 */
public class EmailCodeProperties {
  /** 过期时间 */
  private int expireIn = 60 * 60 * 24;
  /** 要拦截的url，多个url用逗号隔开，ant pattern */
  private String url;

  public int getExpireIn() {
    return expireIn;
  }

  public void setExpireIn(int expireIn) {
    this.expireIn = expireIn;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "EmailCodeProperties{" + "expireIn=" + expireIn + ", url='" + url + '\'' + '}';
  }
}
