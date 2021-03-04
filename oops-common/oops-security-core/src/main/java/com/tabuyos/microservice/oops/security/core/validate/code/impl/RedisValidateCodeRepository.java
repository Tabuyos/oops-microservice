package com.tabuyos.microservice.oops.security.core.validate.code.impl;

import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCode;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeException;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeRepository;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeType;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.impl
 *   <b>class: </b>RedisValidateCodeRepository
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
 * @since 0.1.0 - 3/1/21 5:09 PM
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {
  private final RedisTemplate<String, Object> redisTemplate;

  /**
   * Instantiates a new Redis validate code repository.
   *
   * @param redisTemplate the redis template
   */
  @Autowired
  public RedisValidateCodeRepository(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  /**
   * Save.
   *
   * @param request the request
   * @param code    the code
   * @param type    the type
   */
  @Override
  public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
    String key = buildKey(request, type);
    redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);
  }

  /**
   * Get validate code.
   *
   * @param request the request
   * @param type    the type
   *
   * @return the validate code
   */
  @Override
  public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
    Object value = redisTemplate.opsForValue().get(buildKey(request, type));
    if (value == null) {
      return null;
    }
    return (ValidateCode) value;
  }

  /**
   * Remove.
   *
   * @param request the request
   * @param type    the type
   */
  @Override
  public void remove(ServletWebRequest request, ValidateCodeType type) {
    redisTemplate.delete(buildKey(request, type));
  }

  private String buildKey(ServletWebRequest request, ValidateCodeType type) {
    String deviceId = request.getHeader("deviceId");
    if (StringUtils.isBlank(deviceId)) {
      throw new ValidateCodeException("请在请求头中携带deviceId参数");
    }
    return "code:" + type.toString().toLowerCase() + ":" + deviceId;
  }
}
