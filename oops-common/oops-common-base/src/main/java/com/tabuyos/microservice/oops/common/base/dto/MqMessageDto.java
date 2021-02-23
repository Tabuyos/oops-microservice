package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>MqMessageDto</i>
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
 * @since 0.1.0 - 2/3/21 5:14 PM
 */
public class MqMessageDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -8215701208934310329L;

  /**
   * 消息key
   */
  private String messageKey;

  /**
   * topic
   */
  private String messageTopic;

  public MqMessageDto(String messageKey, String messageTopic) {
    this.messageKey = messageKey;
    this.messageTopic = messageTopic;
  }

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

  @Override
  public String toString() {
    return "MqMessageDto{" +
      "messageKey='" + messageKey + '\'' +
      ", messageTopic='" + messageTopic + '\'' +
      '}';
  }
}
