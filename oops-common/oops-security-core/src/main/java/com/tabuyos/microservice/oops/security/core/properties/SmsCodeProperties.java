package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>SmsCodeProperties
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
public class SmsCodeProperties {
  /**
   * 验证码长度
   */
  private int length = 6;
  /**
   * 过期时间
   */
  private int expireIn = 60;
  /**
   * 要拦截的url，多个url用逗号隔开，ant pattern
   */
  private String url;
  /**
   * 每天每个手机号最大送送短信数量
   */
  private int mobileMaxSendCount;
  /**
   * 每天每个IP最大送送短信数量
   */
  private int ipMaxSendCount;
  /**
   * 每天最大送送短信数量
   */
  private int totalMaxSendCount;

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

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

  public int getMobileMaxSendCount() {
    return mobileMaxSendCount;
  }

  public void setMobileMaxSendCount(int mobileMaxSendCount) {
    this.mobileMaxSendCount = mobileMaxSendCount;
  }

  public int getIpMaxSendCount() {
    return ipMaxSendCount;
  }

  public void setIpMaxSendCount(int ipMaxSendCount) {
    this.ipMaxSendCount = ipMaxSendCount;
  }

  public int getTotalMaxSendCount() {
    return totalMaxSendCount;
  }

  public void setTotalMaxSendCount(int totalMaxSendCount) {
    this.totalMaxSendCount = totalMaxSendCount;
  }

  @Override
  public String toString() {
    return "SmsCodeProperties{" +
      "length=" + length +
      ", expireIn=" + expireIn +
      ", url='" + url + '\'' +
      ", mobileMaxSendCount=" + mobileMaxSendCount +
      ", ipMaxSendCount=" + ipMaxSendCount +
      ", totalMaxSendCount=" + totalMaxSendCount +
      '}';
  }
}
