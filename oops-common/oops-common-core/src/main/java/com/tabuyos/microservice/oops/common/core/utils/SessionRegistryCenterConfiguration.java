package com.tabuyos.microservice.oops.common.core.utils;

import com.tabuyos.microservice.oops.common.config.properties.ZookeeperProperties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.utils</i>
 *   <b>class: </b><i>SessionRegistryCenterConfiguration</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 1:39 PM
 */
public final class SessionRegistryCenterConfiguration {

  private static ZookeeperProperties regCenterConfig;

  /**
   * 从当前会话范围获取注册中心配置.
   *
   * @return 事件追踪数据源配置
   */
  public static ZookeeperProperties getRegistryCenterConfiguration() {
    return regCenterConfig;
  }

  /**
   * 设置注册中心配置至当前会话范围.
   *
   * @param regCenterConfig 注册中心配置
   */
  public static void setRegistryCenterConfiguration(final ZookeeperProperties regCenterConfig) {
    SessionRegistryCenterConfiguration.regCenterConfig = regCenterConfig;
  }
}
