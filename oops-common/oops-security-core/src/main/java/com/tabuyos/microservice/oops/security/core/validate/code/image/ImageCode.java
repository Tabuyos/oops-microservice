package com.tabuyos.microservice.oops.security.core.validate.code.image;

import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCode;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.image
 *   <b>class: </b>ImageCode
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
 * @since 0.1.0 - 3/1/21 5:05 PM
 */
public class ImageCode extends ValidateCode {
  @Serial
  private static final long serialVersionUID = 4531888078902790L;

  private BufferedImage image;

  /**
   * Instantiates a new Image code.
   *
   * @param image    the image
   * @param code     the code
   * @param expireIn the expire in
   */
  ImageCode(BufferedImage image, String code, int expireIn) {
    super(code, expireIn);
    this.image = image;
  }

  /**
   * Instantiates a new Image code.
   *
   * @param image      the image
   * @param code       the code
   * @param expireTime the expire time
   */
  public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
    super(code, expireTime);
    this.image = image;
  }

  /**
   * Gets image.
   *
   * @return the image
   */
  public BufferedImage getImage() {
    return image;
  }

  /**
   * Sets image.
   *
   * @param image the image
   */
  public void setImage(BufferedImage image) {
    this.image = image;
  }
}
