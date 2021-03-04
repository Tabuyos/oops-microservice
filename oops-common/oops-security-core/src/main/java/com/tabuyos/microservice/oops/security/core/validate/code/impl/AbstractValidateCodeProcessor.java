package com.tabuyos.microservice.oops.security.core.validate.code.impl;

import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCode;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeException;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeGenerator;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeProcessor;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeRepository;
import com.tabuyos.microservice.oops.security.core.validate.code.ValidateCodeType;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code.impl
 *   <b>class: </b>AbstractValidateCodeProcessor
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
 * @since 0.1.0 - 3/1/21 5:08 PM
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements
  ValidateCodeProcessor {
  /**
   * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
   */
  private final Map<String, ValidateCodeGenerator> validateCodeGenerators;

  private final ValidateCodeRepository validateCodeRepository;

  /**
   * Instantiates a new Abstract validate code processor.
   *
   * @param validateCodeGenerators the validate code generators
   * @param validateCodeRepository the validate code repository
   */
  @Autowired
  public AbstractValidateCodeProcessor(Map<String, ValidateCodeGenerator> validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
    this.validateCodeGenerators = validateCodeGenerators;
    this.validateCodeRepository = validateCodeRepository;
  }


  /**
   * Create.
   *
   * @param request the request
   *
   * @throws Exception the exception
   */
  @Override
  public void create(ServletWebRequest request) throws Exception {
    C validateCode = generate(request);
    save(request, validateCode);
    send(request, validateCode);
  }

  /**
   * 生成校验码
   */
  @SuppressWarnings("unchecked")
  private C generate(ServletWebRequest request) {
    String type = getValidateCodeType().toString().toLowerCase();
    String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
    ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
    if (validateCodeGenerator == null) {
      throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
    }
    return (C) validateCodeGenerator.generate(request);
  }

  /**
   * 保存校验码
   */
  private void save(ServletWebRequest request, C validateCode) {
    ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
    validateCodeRepository.save(request, code, getValidateCodeType());
  }

  /**
   * 发送校验码，由子类实现
   *
   * @param request      the request
   * @param validateCode the validate code
   *
   * @throws Exception the exception
   */
  protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

  /**
   * 根据请求的url获取校验码的类型
   */
  private ValidateCodeType getValidateCodeType() {
    String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
    return ValidateCodeType.valueOf(type.toUpperCase());
  }

  /**
   * Validate.
   *
   * @param request the request
   */
  @SuppressWarnings("unchecked")
  @Override
  public void validate(ServletWebRequest request) {

    ValidateCodeType codeType = getValidateCodeType();
    this.check(request);
    validateCodeRepository.remove(request, codeType);

  }

  /**
   * Check.
   *
   * @param request the request
   */
  @SuppressWarnings("unchecked")
  @Override
  public void check(ServletWebRequest request) {
    ValidateCodeType codeType = getValidateCodeType();

    C codeInSession = (C) validateCodeRepository.get(request, codeType);

    String codeInRequest;
    try {
      codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), codeType.getParamNameOnValidate());
    } catch (ServletRequestBindingException e) {
      throw new ValidateCodeException("获取验证码的值失败");
    }

    if (StringUtils.isBlank(codeInRequest)) {
      throw new ValidateCodeException(codeType + "验证码的值不能为空");
    }

    if (codeInSession == null || codeInSession.isExpired()) {
      validateCodeRepository.remove(request, codeType);
      throw new ValidateCodeException(codeType + "验证码已过期");
    }

    if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException(codeType + "验证码不匹配");
    }
  }
}