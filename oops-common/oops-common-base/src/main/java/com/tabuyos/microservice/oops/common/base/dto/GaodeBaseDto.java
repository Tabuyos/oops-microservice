package com.tabuyos.microservice.oops.common.base.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.base.dto</i>
 *   <b>class: </b><i>GaodeBaseDto</i>
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
 * @since 0.1.0 - 2/3/21 4:49 PM
 */
public class GaodeBaseDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 6794654906639684086L;

  /**
   * 状态
   */
  private String status;

  /**
   * 响应信息
   */
  private String info;

  /**
   * 响应编码
   */
  private String infocode;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getInfocode() {
    return infocode;
  }

  public void setInfocode(String infocode) {
    this.infocode = infocode;
  }

  @Override
  public String toString() {
    return "GaodeBaseDto{" +
      "status='" + status + '\'' +
      ", info='" + info + '\'' +
      ", infocode='" + infocode + '\'' +
      '}';
  }
}
