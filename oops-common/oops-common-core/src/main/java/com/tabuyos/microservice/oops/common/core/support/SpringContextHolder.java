package com.tabuyos.microservice.oops.common.core.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.support</i>
 *   <b>class: </b><i>SpringContextHolder</i>
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
 * @since 0.1.0 - 2/22/21 1:35 PM
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {


  private static ApplicationContext applicationContext;

  /**
   * Sets application context.
   *
   * @param applicationContext the application context
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    SpringContextHolder.applicationContext = applicationContext;
  }

  /**
   * Gets application context.
   *
   * @return the application context
   */
  public static ApplicationContext getApplicationContext() {
    assertApplicationContext();
    return applicationContext;
  }

  /**
   * Gets bean.
   *
   * @param <T>      the type parameter
   * @param beanName the bean name
   *
   * @return the bean
   */
  public static <T> T getBean(String beanName) {
    assertApplicationContext();
    return (T) applicationContext.getBean(beanName);
  }

  /**
   * Gets bean.
   *
   * @param <T>          the type parameter
   * @param requiredType the required type
   *
   * @return the bean
   */
  public static <T> T getBean(Class<T> requiredType) {
    assertApplicationContext();
    return applicationContext.getBean(requiredType);
  }

  public static DefaultListableBeanFactory getDefaultListableBeanFactory() {
    assertApplicationContext();
    return (DefaultListableBeanFactory) ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
  }

  private static void assertApplicationContext() {
    if (SpringContextHolder.applicationContext == null) {
      throw new IllegalArgumentException("applicationContext属性为null,请检查是否注入了SpringContextHolder!");
    }
  }
}
