package com.tabuyos.microservice.oops.common.core.annotation;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.annotation</i>
 *   <b>class: </b><i>OperationLogDto</i>
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
 * @since 0.1.0 - 2/22/21 9:49 AM
 */
public class OperationLogDto implements Serializable {
  @Serial
  private static final long serialVersionUID = 8645782437190408207L;

  private Long id;

  /**
   * 组织流水号
   */
  private Long groupId;

  /**
   * 组织名称
   */
  private String groupName;

  /**
   * 日志类型
   */
  private String logType;

  /**
   * 日志类型名称
   */
  private String logName;

  /**
   * 权限ID
   */
  private Long actionId;

  /**
   * 权限编码
   */
  private String actionCode;

  /**
   * 权限名称
   */
  private String actionName;

  /**
   * 操作系统
   */
  private String os;

  /**
   * 浏览器类型
   */
  private String browser;

  /**
   * IP地址
   */
  private String ip;

  /**
   * 操作位置
   */
  private String location;

  /**
   * 物理地址
   */
  private String mac;

  /**
   * 详细描述
   */
  private String description;

  /**
   * 请求参数
   */
  private String requestData;

  /**
   * 请求地址
   */
  private String requestUrl;

  /**
   * 响应结果
   */
  private String responseData;

  /**
   * 类名
   */
  private String className;

  /**
   * 方法名
   */
  private String methodName;

  /**
   * 开始时间
   */
  private Date startTime;

  /**
   * 结束时间
   */
  private Date endTime;

  /**
   * 耗时,秒
   */
  private Long excuteTime;

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
  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getLogType() {
    return logType;
  }

  public void setLogType(String logType) {
    this.logType = logType;
  }

  public String getLogName() {
    return logName;
  }

  public void setLogName(String logName) {
    this.logName = logName;
  }

  public Long getActionId() {
    return actionId;
  }

  public void setActionId(Long actionId) {
    this.actionId = actionId;
  }

  public String getActionCode() {
    return actionCode;
  }

  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
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

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  public String getResponseData() {
    return responseData;
  }

  public void setResponseData(String responseData) {
    this.responseData = responseData;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Long getExcuteTime() {
    return excuteTime;
  }

  public void setExcuteTime(Long excuteTime) {
    this.excuteTime = excuteTime;
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
    return "OperationLogDto{" +
      "id=" + id +
      ", groupId=" + groupId +
      ", groupName='" + groupName + '\'' +
      ", logType='" + logType + '\'' +
      ", logName='" + logName + '\'' +
      ", actionId=" + actionId +
      ", actionCode='" + actionCode + '\'' +
      ", actionName='" + actionName + '\'' +
      ", os='" + os + '\'' +
      ", browser='" + browser + '\'' +
      ", ip='" + ip + '\'' +
      ", location='" + location + '\'' +
      ", mac='" + mac + '\'' +
      ", description='" + description + '\'' +
      ", requestData='" + requestData + '\'' +
      ", requestUrl='" + requestUrl + '\'' +
      ", responseData='" + responseData + '\'' +
      ", className='" + className + '\'' +
      ", methodName='" + methodName + '\'' +
      ", startTime=" + startTime +
      ", endTime=" + endTime +
      ", excuteTime=" + excuteTime +
      ", creator='" + creator + '\'' +
      ", creatorId=" + creatorId +
      ", createdTime=" + createdTime +
      ", lastOperator='" + lastOperator + '\'' +
      ", lastOperatorId=" + lastOperatorId +
      ", updateTime=" + updateTime +
      '}';
  }
}
