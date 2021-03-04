package com.tabuyos.microservice.oops.security.core.validate.code;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.validate.code
 *   <b>class: </b>ValidateCodeType
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
 * @since 0.1.0 - 3/1/21 4:58 PM
 */
public enum ValidateCodeType {
  /** 短信验证码 */
  SMS {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
    }
  },
  /** 图片验证码 */
  IMAGE {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
    }
  },
  /** 邮箱验证码 */
  EMAIL {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_EMAIL;
    }
  };

  /**
   * 校验时从请求中获取的参数的名字
   *
   * @return param name on validate
   */
  public abstract String getParamNameOnValidate();
}
