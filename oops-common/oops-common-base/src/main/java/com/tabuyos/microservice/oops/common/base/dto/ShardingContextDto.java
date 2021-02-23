package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>ShardingContextDto</i>
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
 * @since 0.1.0 - 2/3/21 5:16 PM
 */
public class ShardingContextDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 1631529807557696554L;

  /**
   * The Sharding total count.
   */
  int shardingTotalCount;
  /**
   * The Sharding item.
   */
  int shardingItem;

  public ShardingContextDto() {
  }

  public ShardingContextDto(final int shardingTotalCount, final int shardingItem) {
    this.shardingTotalCount = shardingTotalCount;
    this.shardingItem = shardingItem;
  }

  public int getShardingTotalCount() {
    return shardingTotalCount;
  }

  public void setShardingTotalCount(int shardingTotalCount) {
    this.shardingTotalCount = shardingTotalCount;
  }

  public int getShardingItem() {
    return shardingItem;
  }

  public void setShardingItem(int shardingItem) {
    this.shardingItem = shardingItem;
  }

  @Override
  public String toString() {
    return "ShardingContextDto{" +
      "shardingTotalCount=" + shardingTotalCount +
      ", shardingItem=" + shardingItem +
      '}';
  }
}
