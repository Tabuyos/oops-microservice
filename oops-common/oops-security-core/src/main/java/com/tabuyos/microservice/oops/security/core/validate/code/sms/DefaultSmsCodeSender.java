package com.tabuyos.microservice.oops.security.core.validate.code.sms;

import com.tabuyos.microservice.oops.security.core.validate.code.email.DefaultEmailCodeSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.sms
 *   <b>class: </b>DefaultSmsCodeSender
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
 * @since 0.1.0 - 3/1/21 5:10 PM
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
  private final Logger log = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

  /**
   * Send.
   *
   * @param mobile the mobile
   * @param code   the code
   * @param ip     the ip
   */
  @Override
  public void send(String mobile, String code, String ip) {
    log.warn("请配置真实的短信验证码发送器(SmsCodeSender)");
    log.info("向手机" + mobile + "发送短信验证码" + code + "ip:" + ip);
  }
}
