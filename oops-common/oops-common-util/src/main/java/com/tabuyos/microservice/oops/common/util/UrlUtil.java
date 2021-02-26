package com.tabuyos.microservice.oops.common.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>UrlUtil</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class UrlUtil {

  private static final Logger log = LoggerFactory.getLogger(UrlUtil.class);

  private static final String ENCODE = "GBK";

  /** URL 解码 */
  public static String getURLDecoderString(String str) {
    String result = "";
    if (null == str) {
      return "";
    }
    try {
      result = URLDecoder.decode(str, ENCODE);
    } catch (UnsupportedEncodingException e) {
      log.error("URL解码失败 ex={}", e.getMessage(), e);
    }
    return result;
  }

  /** URL 转码 */
  public static String getURLEncoderString(String str) {
    String result = "";
    if (null == str) {
      return "";
    }
    try {
      result = URLEncoder.encode(str, ENCODE);
    } catch (UnsupportedEncodingException e) {
      log.error("URL转码失败 ex={}", e.getMessage(), e);
    }
    return result;
  }
}
