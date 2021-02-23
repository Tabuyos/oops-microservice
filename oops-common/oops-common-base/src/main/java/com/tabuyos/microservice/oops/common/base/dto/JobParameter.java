package com.tabuyos.microservice.oops.common.base.dto;

import com.google.common.base.Preconditions;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>JobParameter</i>
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
 * @since 0.1.0 - 2/3/21 4:51 PM
 */
public class JobParameter implements Serializable {

  @Serial
  private static final long serialVersionUID = -7374851246890237174L;

  /**
   * 每次查询数据量
   */
  private int fetchNum;
  /**
   * 取模条件
   */
  private String condition;
  /**
   * 取模条件
   */
  private String taskType;

  public int getFetchNum() {
    Preconditions.checkArgument(fetchNum != 0);
    return fetchNum;
  }

  public void setFetchNum(int fetchNum) {
    this.fetchNum = fetchNum;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getTaskType() {
    return taskType;
  }

  public void setTaskType(String taskType) {
    this.taskType = taskType;
  }

  @Override
  public String toString() {
    return "JobParameter{" +
      "fetchNum=" + fetchNum +
      ", condition='" + condition + '\'' +
      ", taskType='" + taskType + '\'' +
      '}';
  }
}
