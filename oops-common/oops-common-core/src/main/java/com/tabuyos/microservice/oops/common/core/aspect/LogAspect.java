package com.tabuyos.microservice.oops.common.core.aspect;

import com.tabuyos.microservice.oops.common.base.dto.LoginAuthDto;
import com.tabuyos.microservice.oops.common.core.annotation.LogAnnotation;
import com.tabuyos.microservice.oops.common.core.annotation.OperationLogDto;
import com.tabuyos.microservice.oops.common.core.utils.RequestUtil;
import com.tabuyos.microservice.oops.common.util.JacksonUtil;
import com.tabuyos.microservice.oops.common.util.PubUtils;
import com.tabuyos.microservice.oops.common.util.wrapper.Wrapper;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.aspect</i>
 *   <b>class: </b><i>LogAspect</i>
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
 * @since 0.1.0 - 2/22/21 9:55 AM
 */
@Aspect
@Component
public class LogAspect {

  private final Logger log = LoggerFactory.getLogger(LogAspect.class);

  private ThreadLocal<Date> threadLocal = new ThreadLocal<>();

  @Resource
  private RestTemplate restTemplate;

  @Resource
  private TaskExecutor taskExecutor;

  private static final int MAX_SIZE = 2000;

  /**
   * Log annotation.
   */
  @Pointcut("@annotation(com.tabuyos.microservice.oops.common.core.annotation.LogAnnotation)")
  public void logAnnotation() {
  }

  /**
   * Do before.
   */
  @Before("logAnnotation()")
  public void doBefore() {
    this.threadLocal.set(new Date(System.currentTimeMillis()));
  }

  /**
   * Do after.
   *
   * @param joinPoint   the join point
   * @param returnValue the return value
   */
  @AfterReturning(pointcut = "logAnnotation()", returning = "returnValue")
  public void doAfter(final JoinPoint joinPoint, final Object returnValue) {
    if (returnValue instanceof Wrapper) {
      Wrapper result = (Wrapper) returnValue;

      if (!PubUtils.isNull(result) && result.getCode() == Wrapper.SUCCESS_CODE) {
        this.handleLog(joinPoint, result);
      }

    }

  }

  private void handleLog(final JoinPoint joinPoint, final Object result) {
    final Date startTime = this.threadLocal.get();
    final Date endTime = new Date(System.currentTimeMillis());
    HttpServletRequest request = RequestUtil.getRequest();
    final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
    String requestURI = request.getRequestURI();

    try {
      LogAnnotation relog = giveController(joinPoint);
      LoginAuthDto loginUser = RequestUtil.getLoginUser();
      if (relog == null) {
        return;
      }
      //获取客户端操作系统
      final String os = userAgent.getOperatingSystem().getName();
      //获取客户端浏览器
      final String browser = userAgent.getBrowser().getName();
      final String ipAddress = RequestUtil.getRemoteAddr(request);

      OperationLogDto operationLogDto = new OperationLogDto();
      operationLogDto.setClassName(joinPoint.getTarget().getClass().getName());
      operationLogDto.setMethodName(joinPoint.getSignature().getName());
      operationLogDto.setExcuteTime(endTime.getTime() - startTime.getTime());
      operationLogDto.setStartTime(startTime);
      operationLogDto.setEndTime(endTime);
      operationLogDto.setIp(ipAddress);
      operationLogDto.setOs(os);
      operationLogDto.setBrowser(browser);
      operationLogDto.setRequestUrl(requestURI);

      operationLogDto.setGroupId(loginUser.getGroupId());
      operationLogDto.setGroupName(loginUser.getGroupName());
      operationLogDto.setCreatedTime(new Date());
      operationLogDto.setCreator(loginUser.getUserName());
      operationLogDto.setCreatorId(loginUser.getUserId());
      operationLogDto.setLastOperator(loginUser.getUserName());
      operationLogDto.setLastOperatorId(loginUser.getUserId());

      operationLogDto.setLogType(relog.logType().getType());
      operationLogDto.setLogName(relog.logType().getName());

      getControllerMethodDescription(relog, operationLogDto, result, joinPoint);
      threadLocal.remove();
      taskExecutor.execute(() -> this.restTemplate.postForObject("http://oops-provider-uac/auth/saveLog", operationLogDto, Integer.class));
    } catch (Exception ex) {
      log.error("获取注解类出现异常={}", ex.getMessage(), ex);
    }
  }


  private void getControllerMethodDescription(LogAnnotation relog, OperationLogDto operationLog, Object result, JoinPoint joinPoint) {


    if (relog.isSaveRequestData()) {
      setRequestData(operationLog, joinPoint);
    }
    if (relog.isSaveResponseData()) {
      setResponseData(operationLog, result);
    }
  }

  private void setResponseData(OperationLogDto requestLog, Object result) {
    try {
      requestLog.setResponseData(String.valueOf(result));
    } catch (Exception e) {
      log.error("获取响应数据,出现错误={}", e.getMessage(), e);
    }
  }

  private void setRequestData(OperationLogDto uacLog, JoinPoint joinPoint) {

    try {
      Object[] args = joinPoint.getArgs();
      if (args.length == 0) {
        return;
      }
      Object[] parameter = new Object[args.length];
      int index = 0;
      for (Object object : parameter) {
        if (object instanceof HttpServletRequest) {
          continue;
        }
        parameter[index] = object;
        index++;
      }

      String requestData = JacksonUtil.toJsonWithFormat(parameter);

      if (requestData.length() > MAX_SIZE) {
        requestData = requestData.substring(MAX_SIZE);
      }

      uacLog.setRequestData(requestData);
    } catch (Exception e) {
      log.error("获取响应数据,出现错误={}", e.getMessage(), e);
    }
  }

  /**
   * 是否存在注解, 如果存在就记录日志
   */
  private static LogAnnotation giveController(JoinPoint joinPoint) {
    Method[] methods = joinPoint.getTarget().getClass().getDeclaredMethods();
    String methodName = joinPoint.getSignature().getName();
    if (null != methods && 0 < methods.length) {
      for (Method met : methods) {
        LogAnnotation relog = met.getAnnotation(LogAnnotation.class);
        if (null != relog && methodName.equals(met.getName())) {
          return relog;
        }
      }
    }

    return null;
  }
}
