package com.tabuyos.microservice.oops.common.core.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tabuyos.microservice.oops.common.base.dto.LoginAuthDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.mybatis</i>
 *   <b>class: </b><i>BaseEntity</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 1:29 PM
 */
public class BaseEntity implements Serializable {
  @Serial private static final long serialVersionUID = -8397010646054748343L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 版本号 */
  private Integer version;
  /** 创建人 */
  private String creator;

  /** 创建人ID */
  @Column(name = "creator_id")
  private Long creatorId;

  /** 创建时间 */
  @Column(name = "created_time")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdTime;

  /** 最近操作人 */
  @Column(name = "last_operator")
  private String lastOperator;

  /** 最后操作人ID */
  @Column(name = "last_operator_id")
  private Long lastOperatorId;

  /** 更新时间 */
  @Column(name = "update_time")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @Transient private Integer pageNum;

  @Transient private Integer pageSize;

  @Transient private String orderBy;

  /**
   * Is new boolean.
   *
   * @return the boolean
   */
  @Transient
  @JsonIgnore
  public boolean isNew() {
    return this.id == null;
  }

  /**
   * Sets update info.
   *
   * @param user the user
   */
  @Transient
  @JsonIgnore
  public void setUpdateInfo(LoginAuthDto user) {

    if (isNew()) {
      this.creatorId = (this.lastOperatorId = user.getUserId());
      this.creator = user.getUserName();
      this.createdTime = (this.updateTime = new Date());
    }
    this.lastOperatorId = user.getUserId();
    this.lastOperator = user.getUserName() == null ? user.getLoginName() : user.getUserName();
    this.updateTime = new Date();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
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

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
      "id=" + id +
      ", version=" + version +
      ", creator='" + creator + '\'' +
      ", creatorId=" + creatorId +
      ", createdTime=" + createdTime +
      ", lastOperator='" + lastOperator + '\'' +
      ", lastOperatorId=" + lastOperatorId +
      ", updateTime=" + updateTime +
      ", pageNum=" + pageNum +
      ", pageSize=" + pageSize +
      ", orderBy='" + orderBy + '\'' +
      '}';
  }
}
