package com.tabuyos.microservice.oops.common.core.support;

import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import com.tabuyos.microservice.oops.common.base.dto.LoginAuthDto;
import com.tabuyos.microservice.oops.common.base.enums.ErrorCodeEnum;
import com.tabuyos.microservice.oops.common.base.exception.BusinessException;
import com.tabuyos.microservice.oops.common.util.PublicUtil;
import com.tabuyos.microservice.oops.common.util.ThreadLocalMap;
import com.tabuyos.microservice.oops.common.util.wrapper.WrapMapper;
import com.tabuyos.microservice.oops.common.util.wrapper.Wrapper;
import com.tabuyos.microservice.oops.common.zk.generator.IncrementIdGenerator;
import com.tabuyos.microservice.oops.common.zk.generator.UniqueIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.support</i>
 *   <b>class: </b><i>BaseController</i>
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
 * @since 0.1.0 - 2/22/21 1:32 PM
 */
public class BaseController {


  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * Gets login auth dto.
   *
   * @return the login auth dto
   */
  protected LoginAuthDto getLoginAuthDto() {
    LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
    if (PublicUtil.isEmpty(loginAuthDto)) {
      throw new BusinessException(ErrorCodeEnum.UAC10011041);
    }
    return loginAuthDto;
  }

  /**
   * Handle result wrapper.
   *
   * @param <T>    the type parameter
   * @param result the result
   *
   * @return the wrapper
   */
  protected <T> Wrapper<T> handleResult(T result) {
    boolean flag = isFlag(result);

    if (flag) {
      return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", result);
    } else {
      return WrapMapper.wrap(Wrapper.ERROR_CODE, "操作失败", result);
    }
  }

  /**
   * Handle result wrapper.
   *
   * @param <E>      the type parameter
   * @param result   the result
   * @param errorMsg the error msg
   *
   * @return the wrapper
   */
  protected <E> Wrapper<E> handleResult(E result, String errorMsg) {
    boolean flag = isFlag(result);

    if (flag) {
      return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", result);
    } else {
      return WrapMapper.wrap(Wrapper.ERROR_CODE, errorMsg, result);
    }
  }

  private boolean isFlag(Object result) {
    boolean flag;
    if (result instanceof Integer) {
      flag = (Integer) result > 0;
    } else if (result instanceof Boolean) {
      flag = (Boolean) result;
    } else {
      flag = PublicUtil.isNotEmpty(result);
    }
    return flag;
  }

  protected long generateId() {
    return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
  }
}
