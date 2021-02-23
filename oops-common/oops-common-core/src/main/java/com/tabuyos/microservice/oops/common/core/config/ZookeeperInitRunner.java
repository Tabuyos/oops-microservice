package com.tabuyos.microservice.oops.common.core.config;

import com.tabuyos.microservice.oops.common.config.properties.OopsProperties;
import com.tabuyos.microservice.oops.common.zk.registry.RegistryCenterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.config</i>
 *   <b>class: </b><i>ZookeeperInitRunner</i>
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
 * @since 0.1.0 - 2/22/21 11:46 AM
 */
@Component
@Order
public class ZookeeperInitRunner implements CommandLineRunner {
  private final Logger log = LoggerFactory.getLogger(ZookeeperInitRunner.class);

  @Resource
  private OopsProperties oopsProperties;
  @Value("${spring.application.name}")
  private String applicationName;

  /**
   * Run.
   *
   * @param args the args
   *
   * @throws Exception the exception
   */
  @Override
  public void run(String... args) throws Exception {
    String hostAddress = InetAddress.getLocalHost().getHostAddress();
    log.info("###ZookeeperInitRunner，init. HostAddress={}, applicationName={}", hostAddress, applicationName);
    RegistryCenterFactory.startup(oopsProperties, hostAddress, applicationName);
    log.info("###ZookeeperInitRunner，finish<<<<<<<<<<<<<");
  }
}
