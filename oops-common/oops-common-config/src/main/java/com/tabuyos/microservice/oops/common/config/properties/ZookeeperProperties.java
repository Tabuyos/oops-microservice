package com.tabuyos.microservice.oops.common.config.properties;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.config.properties</i>
 *   <b>class: </b><i>ZookeeperProperties</i>
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 * <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 * <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 * <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/3/21 2:11 PM
 */
public class ZookeeperProperties {
  /**
   * 链接zookeeper服务器的列表, 包括IP地址和端口号, 多个地址用逗号分隔
   */
  private String zkAddressList;
  /**
   * zookeeper的命名空间
   */
  private String namespace;
  /**
   * 等待重试的间隔时间的初始值 单位:毫秒
   */
  private Integer baseSleepTimeMilliseconds = 1000;
  /**
   * 等待重试间隔最大值 单位:毫秒
   */
  private Integer maxSleepTimeMilliseconds = 3000;
  /**
   * 最大重试次数
   */
  private Integer maxRetries = 3;
  /**
   * 连接超时时间 单位:毫秒
   */
  private Integer connectionTimeoutMilliseconds = 1500;
  /**
   * 会话超时时间 单位:毫秒
   */
  private Integer sessionTimeoutMilliseconds = 60000;
  /**
   * 连接zookeeper的权限令牌缺省不需要权限验证
   */
  private String digest;

  public String getZkAddressList() {
    return zkAddressList;
  }

  public void setZkAddressList(String zkAddressList) {
    this.zkAddressList = zkAddressList;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public Integer getBaseSleepTimeMilliseconds() {
    return baseSleepTimeMilliseconds;
  }

  public void setBaseSleepTimeMilliseconds(Integer baseSleepTimeMilliseconds) {
    this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
  }

  public Integer getMaxSleepTimeMilliseconds() {
    return maxSleepTimeMilliseconds;
  }

  public void setMaxSleepTimeMilliseconds(Integer maxSleepTimeMilliseconds) {
    this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
  }

  public Integer getMaxRetries() {
    return maxRetries;
  }

  public void setMaxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
  }

  public Integer getConnectionTimeoutMilliseconds() {
    return connectionTimeoutMilliseconds;
  }

  public void setConnectionTimeoutMilliseconds(Integer connectionTimeoutMilliseconds) {
    this.connectionTimeoutMilliseconds = connectionTimeoutMilliseconds;
  }

  public Integer getSessionTimeoutMilliseconds() {
    return sessionTimeoutMilliseconds;
  }

  public void setSessionTimeoutMilliseconds(Integer sessionTimeoutMilliseconds) {
    this.sessionTimeoutMilliseconds = sessionTimeoutMilliseconds;
  }

  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  @Override
  public String toString() {
    return "ZookeeperProperties{" +
      "zkAddressList='" + zkAddressList + '\'' +
      ", namespace='" + namespace + '\'' +
      ", baseSleepTimeMilliseconds=" + baseSleepTimeMilliseconds +
      ", maxSleepTimeMilliseconds=" + maxSleepTimeMilliseconds +
      ", maxRetries=" + maxRetries +
      ", connectionTimeoutMilliseconds=" + connectionTimeoutMilliseconds +
      ", sessionTimeoutMilliseconds=" + sessionTimeoutMilliseconds +
      ", digest='" + digest + '\'' +
      '}';
  }
}
