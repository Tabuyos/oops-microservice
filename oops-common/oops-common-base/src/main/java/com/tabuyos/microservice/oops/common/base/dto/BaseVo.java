package com.tabuyos.microservice.oops.common.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>BaseVo</i>
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
 * @since 0.1.0 - 2/3/21 4:47 PM
 */
public class BaseVo implements Serializable {

  @Serial
  private static final long serialVersionUID = 5256514666542403421L;

  private Long id;

  /**
   * 创建人
   */
  private String creator;

  /**
   * 创建人ID
   */
  private Long creatorId;

  /**
   * 创建时间
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;

  /**
   * 最近操作人
   */
  private String lastOperator;

  /**
   * 最后操作人ID
   */
  private Long lastOperatorId;

  /**
   * 更新时间
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getLastOperator() {
    return lastOperator;
  }

  public void setLastOperator(String lastOperator) {
    this.lastOperator = lastOperator;
  }

  public Long getLastOperatorId() {
    return lastOperatorId;
  }

  public void setLastOperatorId(Long lastOperatorId) {
    this.lastOperatorId = lastOperatorId;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "BaseVo{" +
      "id=" + id +
      ", creator='" + creator + '\'' +
      ", creatorId=" + creatorId +
      ", createdTime=" + createdTime +
      ", lastOperator='" + lastOperator + '\'' +
      ", lastOperatorId=" + lastOperatorId +
      ", updateTime=" + updateTime +
      '}';
  }
}
