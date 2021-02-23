package com.tabuyos.microservice.oops.common.base.constant;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;
import com.tabuyos.microservice.oops.common.base.exception.BusinessException;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.constant</i>
 *   <b>class: </b><i>AliyunSmsConstant</i>
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
 * @since 0.1.0 - 2/3/21 5:23 PM
 */
public class AliyunSmsConstant {
  /**
   * 短信模板枚举
   */
  public enum SmsTempletEnum {

    /**
     * 通用模板(短信内容:验证码${code}, 您正在注册成为paasCloud用户, 感谢您的支持！)
     */
    UAC_PC_GLOBAL_TEMPLATE("UAC_PC_GLOBAL_TEMPLATE", "SMS_105115057", "code"),;

    private final String busType;

    private final String templateCode;

    private final String smsParamName;

    public static SmsTempletEnum getEnum(String templateCode) {
      SmsTempletEnum smsTempletEnum = null;
      for (SmsTempletEnum ele : SmsTempletEnum.values()) {
        if (templateCode.equals(ele.getTemplateCode())) {
          smsTempletEnum = ele;
          break;
        }
      }
      return smsTempletEnum;
    }

    public static boolean isSmsTemplate(String smsTemplateCode) {

      if (StrUtil.isEmpty(smsTemplateCode)) {
        throw new BusinessException(ErrorCodeEnum.UAC10011020);
      }
      List<String> templetCodeList = getTemplateCodeList();

      return templetCodeList.contains(smsTemplateCode);
    }

    public static List<SmsTempletEnum> getList() {
      return Arrays.asList(SmsTempletEnum.values());
    }

    public static List<String> getTemplateCodeList() {
      List<String> templetCodeList = Lists.newArrayList();
      List<SmsTempletEnum> list = getList();
      for (SmsTempletEnum templetEnum : list) {
        if (StrUtil.isEmpty(templetEnum.getTemplateCode())) {
          continue;
        }
        templetCodeList.add(templetEnum.getTemplateCode());
      }
      return templetCodeList;
    }

    SmsTempletEnum(String busType, String templateCode, String smsParamName) {
      this.busType = busType;
      this.templateCode = templateCode;
      this.smsParamName = smsParamName;
    }

    /**
     * Gets bus type.
     *
     * @return the bus type
     */
    public String getBusType() {
      return busType;
    }

    /**
     * Gets templet code.
     *
     * @return the templet code
     */
    public String getTemplateCode() {
      return templateCode;
    }

    /**
     * Gets sms param name.
     *
     * @return the sms param name
     */
    public String getSmsParamName() {
      return smsParamName;
    }
  }
}
