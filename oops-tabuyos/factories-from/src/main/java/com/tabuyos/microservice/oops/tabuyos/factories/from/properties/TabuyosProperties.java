package com.tabuyos.microservice.oops.tabuyos.factories.from.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.tabuyos.factories.from.properties
 *   <b>class: </b>TabuyosProperties
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 * <pre><b>email: </b>tabuyos@outlook.com</pre>
 * <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/25/21 4:50 PM
 */
@ConfigurationProperties("tabuyos")
public class TabuyosProperties {
  private String en;

  public String getEn() {
    return en;
  }

  public void setEn(String en) {
    this.en = en;
  }

  @Override
  public String toString() {
    return "TabuyosProperties{" +
      "en='" + en + '\'' +
      '}';
  }
}
