package com.tabuyos.microservice.oops.common.zk.registry.exception;

import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry.exception</i>
 *   <b>class: </b><i>RegExceptionHandler</i>
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
 * @since 0.1.0 - 2/22/21 1:57 PM
 */
public final class RegExceptionHandler {

  private final static Logger log = LoggerFactory.getLogger(RegExceptionHandler.class);

  /**
   * 处理异常.
   * <p>
   * <p>处理掉中断和连接失效异常并继续抛注册中心.</p>
   *
   * @param cause 待处理异常.
   */
  public static void handleException(final Exception cause) {
    if (null == cause) {
      return;
    }
    boolean flag = isIgnoredException(cause) || null != cause.getCause() && isIgnoredException(cause.getCause());
    if (flag) {
      log.debug("Elastic job: ignored exception for: {}", cause.getMessage());
    } else if (cause instanceof InterruptedException) {
      Thread.currentThread().interrupt();
    } else {
      throw new RegException(cause);
    }
  }

  private static boolean isIgnoredException(final Throwable cause) {
    return cause instanceof KeeperException.NoNodeException || cause instanceof KeeperException.NodeExistsException;
  }
}
