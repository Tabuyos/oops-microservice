package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>SessionProperties
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
 * @since 0.1.0 - 3/1/21 11:05 AM
 */
public class SessionProperties {
  /**
   * 同一个用户在系统中的最大session数，默认1
   */
  private int maximumSessions = 1;
  /**
   * 达到最大session时是否阻止新的登录请求，默认为false，不阻止，新的登录会将老的登录失效掉
   */
  private boolean maxSessionsPreventsLogin;

  public int getMaximumSessions() {
    return maximumSessions;
  }

  public void setMaximumSessions(int maximumSessions) {
    this.maximumSessions = maximumSessions;
  }

  public boolean isMaxSessionsPreventsLogin() {
    return maxSessionsPreventsLogin;
  }

  public void setMaxSessionsPreventsLogin(boolean maxSessionsPreventsLogin) {
    this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
  }

  @Override
  public String toString() {
    return "SessionProperties{" +
      "maximumSessions=" + maximumSessions +
      ", maxSessionsPreventsLogin=" + maxSessionsPreventsLogin +
      '}';
  }
}
