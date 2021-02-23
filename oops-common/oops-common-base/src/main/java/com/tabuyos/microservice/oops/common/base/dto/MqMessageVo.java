package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>MqMessageVo</i>
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
 * @since 0.1.0 - 2/3/21 5:15 PM
 */
public class MqMessageVo extends BaseVo{

  @Serial
  private static final long serialVersionUID = -3269192027193071532L;

  /**
   * 消息key
   */
  private String messageKey;

  /**
   * topic
   */
  private String messageTopic;

  /**
   * tag
   */
  private String messageTag;

  /**
   * 消息内容
   */
  private String messageBody;

  /**
   * 消息类型: 10 - 生产者 ; 20 - 消费者
   */
  private Integer messageType;

  /**
   * 顺序类型, 0有序 1无序
   */
  private int orderType;

  /**
   * 消息状态
   */
  private Integer status;

  /**
   * 延时级别
   */
  private int delayLevel;

  public String getMessageKey() {
    return messageKey;
  }

  public void setMessageKey(String messageKey) {
    this.messageKey = messageKey;
  }

  public String getMessageTopic() {
    return messageTopic;
  }

  public void setMessageTopic(String messageTopic) {
    this.messageTopic = messageTopic;
  }

  public String getMessageTag() {
    return messageTag;
  }

  public void setMessageTag(String messageTag) {
    this.messageTag = messageTag;
  }

  public String getMessageBody() {
    return messageBody;
  }

  public void setMessageBody(String messageBody) {
    this.messageBody = messageBody;
  }

  public Integer getMessageType() {
    return messageType;
  }

  public void setMessageType(Integer messageType) {
    this.messageType = messageType;
  }

  public int getOrderType() {
    return orderType;
  }

  public void setOrderType(int orderType) {
    this.orderType = orderType;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public int getDelayLevel() {
    return delayLevel;
  }

  public void setDelayLevel(int delayLevel) {
    this.delayLevel = delayLevel;
  }

  @Override
  public String toString() {
    return "MqMessageVo{" +
      "messageKey='" + messageKey + '\'' +
      ", messageTopic='" + messageTopic + '\'' +
      ", messageTag='" + messageTag + '\'' +
      ", messageBody='" + messageBody + '\'' +
      ", messageType=" + messageType +
      ", orderType=" + orderType +
      ", status=" + status +
      ", delayLevel=" + delayLevel +
      '}';
  }
}
