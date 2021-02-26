package com.tabuyos.microservice.oops.tabuyos.factories.from;

import com.tabuyos.microservice.oops.tabuyos.factories.from.properties.TabuyosProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.tabuyos.factories.from
 *   <b>class: </b>TabuyosConfig
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
 * @since 0.1.0 - 2/25/21 4:55 PM
 */
@Configuration
@EnableConfigurationProperties(TabuyosProperties.class)
public class TabuyosConfig {

}
