package com.tabuyos.microservice.oops.common.config;

import com.tabuyos.microservice.oops.common.config.properties.OopsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
//@Configuration
@EnableConfigurationProperties(OopsProperties.class)
public class OopsCoreConfig {}
