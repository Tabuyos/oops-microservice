package com.tabuyos.microservice.oops.common.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>tabuyos-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.common.config
 *   <b>class: </b>OopsCoreConfig
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/3/21 2:07 PM
 */
@Component
@ConfigurationPropertiesScan(basePackages = {"com.tabuyos.microservice.oops.common.config.properties"})
public class OopsCoreConfig {}
