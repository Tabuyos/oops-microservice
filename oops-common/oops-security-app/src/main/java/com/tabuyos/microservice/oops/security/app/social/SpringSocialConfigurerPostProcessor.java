package com.tabuyos.microservice.oops.security.app.social;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import com.tabuyos.microservice.oops.security.core.social.support.PcSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.app.social
 *   <b>class: </b>SpringSocialConfigurerPostProcessor
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
 * @since 0.1.0 - 3/1/21 5:22 PM
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {
  /**
   * Post process before initialization object.
   *
   * @param bean     the bean
   * @param beanName the bean name
   *
   * @return the object
   *
   * @throws BeansException the beans exception
   */
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

  /**
   * Post process after initialization object.
   *
   * @param bean     the bean
   * @param beanName the bean name
   *
   * @return the object
   *
   * @throws BeansException the beans exception
   */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    String pcSocialSecurityConfig = "pcSocialSecurityConfig";
    if (StringUtils.equals(beanName, pcSocialSecurityConfig)) {
      PcSpringSocialConfigurer config = (PcSpringSocialConfigurer) bean;
      config.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
      return config;
    }
    return bean;
  }
}
