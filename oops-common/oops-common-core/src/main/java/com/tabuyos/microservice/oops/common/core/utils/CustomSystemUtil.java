package com.tabuyos.microservice.oops.common.core.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.utils</i>
 *   <b>class: </b><i>CustomSystemUtil</i>
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
 * @since 0.1.0 - 2/22/21 1:38 PM
 */
public class CustomSystemUtil {

  /** 内网IP */
  private static String INTRANET_IP = getIntranetIp();

  /** 外网IP */
  private static String INTERNET_IP = getInternetIp();

  /**
   * 获得内网IP
   *
   * @return 内网IP
   */
  private static String getIntranetIp() {
    try {
      return InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 获得外网IP
   *
   * @return 外网IP
   */
  private static String getInternetIp() {
    try {
      Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
      InetAddress ip;
      Enumeration<InetAddress> addrs;
      while (networks.hasMoreElements()) {
        addrs = networks.nextElement().getInetAddresses();
        while (addrs.hasMoreElements()) {
          ip = addrs.nextElement();
          if (ip != null
              && ip instanceof Inet4Address
              && ip.isSiteLocalAddress()
              && !ip.getHostAddress().equals(INTRANET_IP)) {
            return ip.getHostAddress();
          }
        }
      }

      // 如果没有外网IP，就返回内网IP
      return INTRANET_IP;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
