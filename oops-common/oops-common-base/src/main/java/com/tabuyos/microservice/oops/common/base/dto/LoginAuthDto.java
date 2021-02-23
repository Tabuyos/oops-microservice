package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>LoginAuthDto</i>
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
 * @since 0.1.0 - 2/3/21 5:01 PM
 */
public class LoginAuthDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 7777831263362080917L;

  /**
   * 用户ID
   */
  private Long userId;
  /**
   * 登录名
   */
  private String loginName;
  /**
   * 用户名
   */
  private String userName;
  /**
   * 组织ID
   */
  private Long groupId;
  /**
   * 组织名称
   */
  private String groupName;

  public LoginAuthDto() {
  }

  public LoginAuthDto(Long userId, String loginName, String userName) {
    this.userId = userId;
    this.loginName = loginName;
    this.userName = userName;
  }

  public LoginAuthDto(Long userId, String loginName, String userName, Long groupId, String groupName) {
    this.userId = userId;
    this.loginName = loginName;
    this.userName = userName;
    this.groupId = groupId;
    this.groupName = groupName;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  @Override
  public String toString() {
    return "LoginAuthDto{" +
      "userId=" + userId +
      ", loginName='" + loginName + '\'' +
      ", userName='" + userName + '\'' +
      ", groupId=" + groupId +
      ", groupName='" + groupName + '\'' +
      '}';
  }
}
