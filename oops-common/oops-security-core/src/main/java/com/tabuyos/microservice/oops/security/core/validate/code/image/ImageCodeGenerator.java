package com.tabuyos.microservice.oops.security.core.validate.code.image;

import com.google.code.kaptcha.Producer;
import com.tabuyos.microservice.oops.security.core.properties.SecurityProperties;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeGenerator;
import java.awt.image.BufferedImage;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.image
 *   <b>class: </b>ImageCodeGenerator
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
 * @since 0.1.0 - 3/1/21 5:07 PM
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {
  private SecurityProperties securityProperties;
  private Producer captchaProducer;

  /**
   * 生成图片验证码.
   *
   * @param request the request
   *
   * @return the image code
   */
  @Override
  public ImageCode generate(ServletWebRequest request) {
    String kaptchaCode = captchaProducer.createText();
    BufferedImage image = captchaProducer.createImage(kaptchaCode);
    return new ImageCode(image, kaptchaCode, securityProperties.getCode().getImage().getExpireIn());
  }

  /**
   * Sets security properties.
   *
   * @param securityProperties the security properties
   */
  public void setSecurityProperties(SecurityProperties securityProperties) {
    this.securityProperties = securityProperties;
  }

  /**
   * Sets captcha producer.
   *
   * @param captchaProducer the captcha producer
   */
  public void setCaptchaProducer(Producer captchaProducer) {
    this.captchaProducer = captchaProducer;
  }

}
