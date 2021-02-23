package com.tabuyos.microservice.oops.common.zk.registry.base;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry.base</i>
 *   <b>class: </b><i>RegisterDto</i>
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
 * @since 0.1.0 - 2/22/21 1:48 PM
 */
public class RegisterDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -8056830518421723042L;

  private String app;

  private String host;

  private CoordinatorRegistryCenter coordinatorRegistryCenter;

  public RegisterDto(String app, String host, CoordinatorRegistryCenter coordinatorRegistryCenter) {
    this.app = app;
    this.host = host;
    this.coordinatorRegistryCenter = coordinatorRegistryCenter;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public CoordinatorRegistryCenter getCoordinatorRegistryCenter() {
    return coordinatorRegistryCenter;
  }

  public void setCoordinatorRegistryCenter(CoordinatorRegistryCenter coordinatorRegistryCenter) {
    this.coordinatorRegistryCenter = coordinatorRegistryCenter;
  }

  @Override
  public String toString() {
    return "RegisterDto{" +
      "app='" + app + '\'' +
      ", host='" + host + '\'' +
      ", coordinatorRegistryCenter=" + coordinatorRegistryCenter +
      '}';
  }
}
