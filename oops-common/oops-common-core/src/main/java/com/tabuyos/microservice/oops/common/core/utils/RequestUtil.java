package com.tabuyos.microservice.oops.common.core.utils;

import cn.hutool.core.codec.Base64;
import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import com.tabuyos.microservice.oops.common.base.dto.LoginAuthDto;
import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;
import com.tabuyos.microservice.oops.common.base.exception.BusinessException;
import com.tabuyos.microservice.oops.common.util.PublicUtil;
import com.tabuyos.microservice.oops.common.util.ThreadLocalMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.utils</i>
 *   <b>class: </b><i>RequestUtil</i>
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
 * @since 0.1.0 - 2/22/21 10:49 AM
 */
public class RequestUtil {

  private final static Logger log = LoggerFactory.getLogger(RequestUtil.class);


  /**
   * Gets request.
   *
   * @return the request
   */
  public static HttpServletRequest getRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

  /**
   * 获得用户远程地址
   *
   * @param request the request
   *
   * @return the string
   */
  public static String getRemoteAddr(HttpServletRequest request) {
    String ipAddress = request.getHeader(GlobalConstant.X_REAL_IP);
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.X_FORWARDED_FOR);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.PROXY_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.WL_PROXY_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.HTTP_CLIENT_IP);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader(GlobalConstant.HTTP_X_FORWARDED_FOR);
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
    }
    if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if (GlobalConstant.LOCALHOST_IP.equals(ipAddress) || GlobalConstant.LOCALHOST_IP_16.equals(ipAddress)) {
        //根据网卡取本机配置的IP
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          log.error("获取IP地址, 出现异常={}", e.getMessage(), e);
        }
        assert inet != null;
        ipAddress = inet.getHostAddress();
      }
      log.info("获取IP地址 ipAddress={}", ipAddress);
    }
    // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
    if (ipAddress != null && ipAddress.length() > GlobalConstant.MAX_IP_LENGTH) {
      if (ipAddress.indexOf(GlobalConstant.Symbol.COMMA) > 0) {
        ipAddress = ipAddress.substring(0, ipAddress.indexOf(GlobalConstant.Symbol.COMMA));
      }
    }
    return ipAddress;
  }

  /**
   * Gets login user.
   *
   * @return the login user
   */
  public static LoginAuthDto getLoginUser() {
    LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
    if (PublicUtil.isEmpty(loginAuthDto)) {
      throw new BusinessException(ErrorCodeEnum.UAC10011039);
    }
    return loginAuthDto;

  }

  /**
   * Gets auth header.
   *
   * @param request the request
   *
   * @return the auth header
   */
  public static String getAuthHeader(HttpServletRequest request) {

    String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (org.apache.commons.lang.StringUtils.isEmpty(authHeader)) {
      throw new BusinessException(ErrorCodeEnum.UAC10011040);
    }
    return authHeader;
  }

  public static String[] extractAndDecodeHeader(String header) throws IOException {

    byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
    byte[] decoded;
    try {
      decoded = Base64.decode(base64Token);
    } catch (IllegalArgumentException e) {
      throw new BadCredentialsException("Failed to decode basic authentication token");
    }

    String token = new String(decoded, StandardCharsets.UTF_8);

    int delim = token.indexOf(GlobalConstant.Symbol.MH);

    if (delim == -1) {
      throw new BadCredentialsException("Invalid basic authentication token");
    }
    return new String[]{token.substring(0, delim), token.substring(delim + 1)};
  }
}
