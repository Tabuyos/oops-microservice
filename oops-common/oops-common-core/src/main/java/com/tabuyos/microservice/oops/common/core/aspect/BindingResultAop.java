package com.tabuyos.microservice.oops.common.core.aspect;

import com.tabuyos.microservice.oops.common.core.annotation.ValidateAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.aspect</i>
 *   <b>class: </b><i>BindingResultAop</i>
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
 * @since 0.1.0 - 2/22/21 9:45 AM
 */
@Component
@Aspect
public class BindingResultAop {
  /**
   * Validate annotation.
   */
  @Pointcut("@annotation(com.tabuyos.microservice.oops.common.core.annotation.ValidateAnnotation)")
  public void validateAnnotation() {
  }

  /**
   * Do before.
   */
  @Before("validateAnnotation()")
  public void doBefore() {
  }

  /**
   * Do after.
   *
   * @param joinPoint the join point
   */
  @AfterReturning(pointcut = "validateAnnotation()")
  public void doAfter(final JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    Object target = joinPoint.getTarget();
    //得到拦截的方法
    Method method = getMethodByClassAndName(target.getClass(), methodName);
    Object[] objects = joinPoint.getArgs();
    //方法的参数
    assert method != null;
    ValidateAnnotation annotation = (ValidateAnnotation) getAnnotationByMethod(method, ValidateAnnotation.class);
    if (annotation != null) {
      BindingResult bindingResult = null;
      for (Object arg : objects) {
        if (arg instanceof BindingResult) {
          bindingResult = (BindingResult) arg;
        }
      }
      if (bindingResult != null && bindingResult.hasErrors()) {
        String errorInfo = bindingResult.getFieldError().getDefaultMessage();
        throw new IllegalArgumentException(errorInfo);
      }
    }
  }

  /**
   * 根据目标方法和注解类型  得到该目标方法的指定注解
   */
  private Annotation getAnnotationByMethod(Method method, Class<?> annoClass) {
    Annotation[] all = method.getAnnotations();
    for (Annotation annotation : all) {
      if (annotation.annotationType() == annoClass) {
        return annotation;
      }
    }
    return null;
  }

  /**
   * 根据类和方法名得到方法
   */
  private Method getMethodByClassAndName(Class<?> c, String methodName) {
    Method[] methods = c.getDeclaredMethods();
    for (Method method : methods) {
      if (method.getName().equals(methodName)) {
        return method;
      }
    }
    return null;
  }
}
