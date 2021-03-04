package com.tabuyos.microservice.oops.security.core.validate.code.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.microservice.oops.security.core.SecurityResult;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeGenerator;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeRepository;
import com.tabuyos.microservice.oops.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.image
 *   <b>class: </b>ImageCodeProcessor
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
 * @since 0.1.0 - 3/1/21 5:07 PM
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
  @Resource private ObjectMapper objectMapper;

  /**
   * Instantiates a new Abstract validate code processor.
   *
   * @param validateCodeGenerators the validate code generators
   * @param validateCodeRepository the validate code repository
   */
  public ImageCodeProcessor(
      Map<String, ValidateCodeGenerator> validateCodeGenerators,
      ValidateCodeRepository validateCodeRepository) {
    super(validateCodeGenerators, validateCodeRepository);
  }

  /**
   * 发送图形验证码，将其写到响应中
   *
   * @param request the request
   * @param imageCode the image code
   * @throws Exception the exception
   */
  @Override
  protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ImageIO.write(imageCode.getImage(), "JPEG", bos);

    SecurityResult result = SecurityResult.ok(bos.toByteArray());

    String json = objectMapper.writeValueAsString(result);
    HttpServletResponse response = request.getResponse();
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
  }
}
