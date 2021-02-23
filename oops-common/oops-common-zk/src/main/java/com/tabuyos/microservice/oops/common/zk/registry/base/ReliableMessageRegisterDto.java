package com.tabuyos.microservice.oops.common.zk.registry.base;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.zk.registry.base</i>
 *   <b>class: </b><i>ReliableMessageRegisterDto</i>
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
 * @since 0.1.0 - 2/22/21 1:49 PM
 */
public class ReliableMessageRegisterDto {

  private String consumerGroup;
  private String producerGroup;
  private String namesrvAddr;

  /**
   * Sets consumer group.
   *
   * @param consumerGroup the consumer group
   *
   * @return the consumer group
   */
  public ReliableMessageRegisterDto setConsumerGroup(final String consumerGroup) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(consumerGroup), "init zk cid is null");
    this.consumerGroup = consumerGroup;
    return this;
  }

  /**
   * Sets producer group.
   *
   * @param producerGroup the producer group
   *
   * @return the producer group
   */
  public ReliableMessageRegisterDto setProducerGroup(final String producerGroup) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(producerGroup), "init zk pid is null");
    this.producerGroup = producerGroup;
    return this;
  }

  /**
   * Sets namesrv addr.
   *
   * @param namesrvAddr the namesrv addr
   *
   * @return the namesrv addr
   */
  public ReliableMessageRegisterDto setNamesrvAddr(final String namesrvAddr) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(namesrvAddr), "init ZK namesrvAddr is null");
    this.namesrvAddr = namesrvAddr;
    return this;
  }

  public String getConsumerGroup() {
    return consumerGroup;
  }

  public String getProducerGroup() {
    return producerGroup;
  }

  public String getNamesrvAddr() {
    return namesrvAddr;
  }

  @Override
  public String toString() {
    return "ReliableMessageRegisterDto{" +
      "consumerGroup='" + consumerGroup + '\'' +
      ", producerGroup='" + producerGroup + '\'' +
      ", namesrvAddr='" + namesrvAddr + '\'' +
      '}';
  }
}
