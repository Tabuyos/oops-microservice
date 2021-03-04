package com.tabuyos.microservice.oops.tabuyos.factories.from.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.tabuyos.factories.from.properties
 *   <b>class: </b>CoreProperties
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
 * @since 0.1.0 - 3/4/21 10:20 AM
 */
@Component
@ConfigurationProperties("tabuyos.core")
public class CoreProperties {
  private KeyProperties ck = new KeyProperties();

  public KeyProperties getCk() {
    return ck;
  }

  public void setCk(KeyProperties ck) {
    this.ck = ck;
  }

  static class KeyProperties {
    private String key;
    private String value;

    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "KeyProperties{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
    }
  }

  @Override
  public String toString() {
    return "CoreProperties{" +
      "ck=" + ck +
      '}';
  }
}
