package com.tabuyos.microservice.oops.common.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>MessageQueryDto</i>
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
 * @since 0.1.0 - 2/3/21 5:05 PM
 */
public class MessageQueryDto extends BaseQuery {

  @Serial
  private static final long serialVersionUID = -7127405878783773012L;

  /**
   * messageKey
   */
  private String messageKey;
  /**
   * messageTopic
   */
  private String messageTopic;

  /**
   * messageTag
   */
  private String messageTag;
  /**
   * 发送状态
   */
  private String messageStatus;

  /**
   * PID
   */
  private String producerGroup;

  /**
   * 消息类型
   */
  private String messageType;

  /**
   * 开始时间
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startQueryTime;

  /**
   * 结束时间
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endQueryTime;

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

  public String getMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(String messageStatus) {
    this.messageStatus = messageStatus;
  }

  public String getProducerGroup() {
    return producerGroup;
  }

  public void setProducerGroup(String producerGroup) {
    this.producerGroup = producerGroup;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public Date getStartQueryTime() {
    return startQueryTime;
  }

  public void setStartQueryTime(Date startQueryTime) {
    this.startQueryTime = startQueryTime;
  }

  public Date getEndQueryTime() {
    return endQueryTime;
  }

  public void setEndQueryTime(Date endQueryTime) {
    this.endQueryTime = endQueryTime;
  }

  @Override
  public String toString() {
    return "MessageQueryDto{" +
      "messageKey='" + messageKey + '\'' +
      ", messageTopic='" + messageTopic + '\'' +
      ", messageTag='" + messageTag + '\'' +
      ", messageStatus='" + messageStatus + '\'' +
      ", producerGroup='" + producerGroup + '\'' +
      ", messageType='" + messageType + '\'' +
      ", startQueryTime=" + startQueryTime +
      ", endQueryTime=" + endQueryTime +
      '}';
  }
}
