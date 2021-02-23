package com.tabuyos.microservice.oops.common.core.aspect;

import com.tabuyos.microservice.oops.common.util.ThreadLocalMap;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.aspect</i>
 *   <b>class: </b><i>NotDisplaySqlAspect</i>
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
 * @since 0.1.0 - 2/22/21 9:59 AM
 */
@Aspect
@Component
public class NotDisplaySqlAspect {

  /**
   * The constant DISPLAY_SQL.
   */
  public static final String DISPLAY_SQL = "DISPLAY_SQL";

  @Pointcut("@annotation(com.tabuyos.microservice.oops.common.core.annotation.NotDisplaySql)")
  private void myPointCut() {
  }

  /**
   * Before.
   */
  @Before(value = "myPointCut()")
  public void before() {
    ThreadLocalMap.put(DISPLAY_SQL, Boolean.FALSE);
  }

  /**
   * After.
   */
  @After(value = "myPointCut()")
  public void after() {
    ThreadLocalMap.remove(DISPLAY_SQL);
  }
}
