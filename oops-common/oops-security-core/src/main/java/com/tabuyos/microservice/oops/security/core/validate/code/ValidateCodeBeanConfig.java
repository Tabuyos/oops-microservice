package com.tabuyos.microservice.oops.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeBeanConfig
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:42 PM
 */
@Configuration
public class ValidateCodeBeanConfig {
  @Autowired private SecurityProperties securityProperties;
  @Autowired private Producer captchaProducer;

  /**
   * 图片验证码图片生成器
   *
   * @return validate code generator
   */
  @Bean
  @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
  public ValidateCodeGenerator imageValidateCodeGenerator() {
    ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
    codeGenerator.setSecurityProperties(securityProperties);
    codeGenerator.setCaptchaProducer(captchaProducer);
    return codeGenerator;
  }

  /**
   * 短信验证码发送器
   *
   * @return sms code sender
   */
  @Bean
  @ConditionalOnMissingBean(SmsCodeSender.class)
  public SmsCodeSender smsCodeSender() {
    return new DefaultSmsCodeSender();
  }

  /**
   * 邮箱验证码发送器
   *
   * @return sms code sender
   */
  @Bean
  @ConditionalOnMissingBean(EmailCodeSender.class)
  public EmailCodeSender emailCodeSender() {
    return new DefaultEmailCodeSender();
  }
}
