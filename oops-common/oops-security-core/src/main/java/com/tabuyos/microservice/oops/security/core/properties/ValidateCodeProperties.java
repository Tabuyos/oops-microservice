package com.tabuyos.microservice.oops.security.core.properties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.properties
 *   <b>class: </b>ValidateCodeProperties
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
 * @since 0.1.0 - 3/1/21 11:07 AM
 */
public class ValidateCodeProperties {
  /**
   * 图片验证码配置
   */
  private ImageCodeProperties image = new ImageCodeProperties();
  /**
   * 短信验证码配置
   */
  private SmsCodeProperties sms = new SmsCodeProperties();
  /**
   * 邮箱验证码配置
   */
  private EmailCodeProperties email = new EmailCodeProperties();

  public ImageCodeProperties getImage() {
    return image;
  }

  public void setImage(ImageCodeProperties image) {
    this.image = image;
  }

  public SmsCodeProperties getSms() {
    return sms;
  }

  public void setSms(SmsCodeProperties sms) {
    this.sms = sms;
  }

  public EmailCodeProperties getEmail() {
    return email;
  }

  public void setEmail(EmailCodeProperties email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "ValidateCodeProperties{" +
      "image=" + image +
      ", sms=" + sms +
      ", email=" + email +
      '}';
  }
}
