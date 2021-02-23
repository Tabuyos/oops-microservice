package com.tabuyos.microservice.oops.security.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;
import com.tabuyos.microservice.oops.common.base.exception.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.security.feign</i>
 *   <b>class: </b><i>Oauth2FeignErrorInterceptor</i>
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
 * @since 0.1.0 - 2/22/21 2:18 PM
 */
public class Oauth2FeignErrorInterceptor implements ErrorDecoder {

  private final static Logger log = LoggerFactory.getLogger(Oauth2FeignErrorInterceptor.class);

  private final ErrorDecoder defaultErrorDecoder = new Default();

  /**
   * Decode exception.
   *
   * @param methodKey the method key
   * @param response  the response
   *
   * @return the exception
   */
  @Override
  public Exception decode(final String methodKey, final Response response) {
    if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
      return new RuntimeException("request exception wrapper");
    }

    ObjectMapper mapper = new ObjectMapper();
    try {
      HashMap map = mapper.readValue(response.body().asInputStream(), HashMap.class);
      Integer code = (Integer) map.get("code");
      String message = (String) map.get("message");
      if (code != null) {
        ErrorCodeEnum anEnum = ErrorCodeEnum.getEnum(code);
        if (anEnum != null) {
          if (anEnum == ErrorCodeEnum.GL99990100) {
            throw new IllegalArgumentException(message);
          } else {
            throw new BusinessException(anEnum);
          }
        } else {
          throw new BusinessException(ErrorCodeEnum.GL99990500, message);
        }
      }
    } catch (IOException e) {
      log.info("Failed to process response body");
    }
    return defaultErrorDecoder.decode(methodKey, response);
  }
}
