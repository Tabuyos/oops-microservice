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
 *   <b>class: </b><i>UserTokenDto</i>
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
 * @since 0.1.0 - 2/3/21 5:18 PM
 */
public class UserTokenDto extends LoginAuthDto{

  @Serial
  private static final long serialVersionUID = -4878526469888990707L;

  private Long id;

  /**
   * 版本号
   */
  private Integer version;
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
  /**
   * 父ID
   */
  private Long pid;

  /**
   * 登陆人Ip地址
   */
  private String loginIp;

  /**
   * 登录地址
   */
  private String loginLocation;

  /**
   * 操作系统
   */
  private String os;

  /**
   * 浏览器类型
   */
  private String browser;

  /**
   * 访问token
   */
  private String accessToken;

  /**
   * 刷新token
   */
  private String refreshToken;

  /**
   * 访问token的生效时间(秒)
   */
  private Integer accessTokenValidity;

  /**
   * 刷新token的生效时间(秒)
   */
  private Integer refreshTokenValidity;

  /**
   * 0 在线 10已刷新 20 离线
   */
  private Integer status;

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

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public String getLoginIp() {
    return loginIp;
  }

  public void setLoginIp(String loginIp) {
    this.loginIp = loginIp;
  }

  public String getLoginLocation() {
    return loginLocation;
  }

  public void setLoginLocation(String loginLocation) {
    this.loginLocation = loginLocation;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public Integer getAccessTokenValidity() {
    return accessTokenValidity;
  }

  public void setAccessTokenValidity(Integer accessTokenValidity) {
    this.accessTokenValidity = accessTokenValidity;
  }

  public Integer getRefreshTokenValidity() {
    return refreshTokenValidity;
  }

  public void setRefreshTokenValidity(Integer refreshTokenValidity) {
    this.refreshTokenValidity = refreshTokenValidity;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "UserTokenDto{" +
      "id=" + id +
      ", version=" + version +
      ", creator='" + creator + '\'' +
      ", creatorId=" + creatorId +
      ", createdTime=" + createdTime +
      ", lastOperator='" + lastOperator + '\'' +
      ", lastOperatorId=" + lastOperatorId +
      ", updateTime=" + updateTime +
      ", pid=" + pid +
      ", loginIp='" + loginIp + '\'' +
      ", loginLocation='" + loginLocation + '\'' +
      ", os='" + os + '\'' +
      ", browser='" + browser + '\'' +
      ", accessToken='" + accessToken + '\'' +
      ", refreshToken='" + refreshToken + '\'' +
      ", accessTokenValidity=" + accessTokenValidity +
      ", refreshTokenValidity=" + refreshTokenValidity +
      ", status=" + status +
      '}';
  }
}
