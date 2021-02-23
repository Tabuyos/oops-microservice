package com.tabuyos.microservice.oops.common.core.mq;

import com.google.common.base.Preconditions;
import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;
import com.tabuyos.microservice.oops.common.base.exception.BusinessException;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.mq</i>
 *   <b>class: </b><i>MqMessage</i>
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
 * @since 0.1.0 - 2/22/21 1:26 PM
 */
public class MqMessage implements Serializable {

  @Serial
  private static final long serialVersionUID = -7842684587868498543L;

  private final static Logger log = LoggerFactory.getLogger(MqMessage.class);

  @ApiModelProperty("主题")
  private String topic;
  @ApiModelProperty("标签")
  private String tag;
  @ApiModelProperty("唯一键")
  private String key;
  @ApiModelProperty("消息体")
  private String body;

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  /**
   * Check message message.
   *
   * @param mqMessage the mq message
   *
   * @return the message
   */
  public static Message checkMessage(MqMessage mqMessage) {

    String topic = mqMessage.getTopic();
    String key = mqMessage.getKey();
    String body = mqMessage.getBody();
    String tag = mqMessage.getTag();
    printCheckMessageLog(topic, key, body, tag);
    checkMessage(topic, key, body);
    return buildMessage(body, topic, tag, key);

  }

  private static void printCheckMessageLog(final String topic, final String key, final String body, final String tag) {
    log.info("checkMessage - 校验MQ body={}, topic={}, tag={}, key={}", body, topic, tag, key);
  }

  /**
   * Check message message.
   *
   * @param body  the body
   * @param topic the topic
   * @param tag   the tag
   * @param key   the key
   *
   * @return the message
   */
  public static Message checkMessage(String body, String topic, String tag, String key) {
    printCheckMessageLog(topic, key, body, tag);
    checkMessage(topic, key, body);
    return buildMessage(body, topic, tag, key);

  }

  /**
   * Check message message.
   *
   * @param message the message
   *
   * @return the message
   */
  public static Message checkMessage(Message message) {

    String body = new String(message.getBody());
    String topic = message.getTopic();
    String key = message.getKeys();
    String tag = message.getTags();
    printCheckMessageLog(topic, key, body, tag);
    checkMessage(topic, key, body);
    return buildMessage(body, topic, tag, key);

  }

  /**
   * Instantiates a new Mq message.
   *
   * @param message the message
   */
  public MqMessage(Message message) {
    this.body = new String(message.getBody());
    this.topic = message.getTopic();
    this.key = message.getKeys();
    this.tag = message.getTags();

  }

  private static Message buildMessage(String body, String topic, String tag, String key) {
    Message message = new Message();
    try {
      message.setBody(body.getBytes(RemotingHelper.DEFAULT_CHARSET));
    } catch (UnsupportedEncodingException e) {
      log.error("编码转换,出现异常={}", e.getMessage(), e);
      throw new BusinessException(ErrorCodeEnum.TPC100500011);
    }
    message.setKeys(key);
    message.setTopic(topic);
    message.setTags(tag);
    return message;
  }

  /**
   * Instantiates a new Mq message.
   *
   * @param topic the topic
   * @param tag   the tag
   * @param key   the key
   * @param body  the body
   */
  public MqMessage(String topic, String tag, String key, String body) {
    this.topic = topic;
    this.tag = tag;
    this.key = key;
    this.body = body;
  }

  /**
   * Check message.
   *
   * @param topic the topic
   * @param key   the key
   * @param body  the body
   */
  public static void checkMessage(String topic, String key, String body) {

    Preconditions.checkArgument(!StringUtils.isEmpty(topic), "发送消息失败, 消息主题不能为空");
    Preconditions.checkArgument(!StringUtils.isEmpty(key), "发送消息失败, 消息关键字不能为空");
    Preconditions.checkArgument(!StringUtils.isEmpty(body), "发送消息失败, 消息体不能为空");
  }

  /**
   * Print producer result.
   *
   * @param sendResult the send result
   * @param logger     the logger
   */
  public static void printProducerResult(SendResult sendResult, Logger logger) {
    if (sendResult != null) {
      logger.info("sendSimpleMessage - 发送MQ [OK]sendResult={}", sendResult);
    } else {
      logger.info("sendSimpleMessage - 发送MQ [FAIL]");
    }
  }

  /**
   * Print producer exception.
   *
   * @param topic  the topic
   * @param tag    the tag
   * @param key    the key
   * @param logger the logger
   * @param e      the e
   */
  public static void printProducerException(String topic, String tag, String key, Logger logger, Exception e) {
    logger.error("sendSimpleMessage - 发送MQ [FAIL] topic={}, tag={}, key={}", topic, tag, key, e);
  }
}
