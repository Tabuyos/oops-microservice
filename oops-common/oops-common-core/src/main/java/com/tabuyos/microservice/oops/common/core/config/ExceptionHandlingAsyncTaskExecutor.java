package com.tabuyos.microservice.oops.common.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.config</i>
 *   <b>class: </b><i>ExceptionHandlingAsyncTaskExecutor</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 10:55 AM
 */
public class ExceptionHandlingAsyncTaskExecutor
    implements AsyncTaskExecutor, InitializingBean, DisposableBean {

  private final Logger log = LoggerFactory.getLogger(ExceptionHandlingAsyncTaskExecutor.class);

  private final AsyncTaskExecutor executor;

  /**
   * Instantiates a new Exception handling async task executor.
   *
   * @param executor the executor
   */
  ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
    this.executor = executor;
  }

  /**
   * Execute.
   *
   * @param task the task
   */
  @Override
  public void execute(Runnable task) {
    executor.execute(createWrappedRunnable(task));
  }

  /**
   * Execute.
   *
   * @param task the task
   * @param startTimeout the start timeout
   */
  @Override
  public void execute(Runnable task, long startTimeout) {
    executor.execute(createWrappedRunnable(task), startTimeout);
  }

  private <T> Callable<T> createCallable(final Callable<T> task) {
    return () -> {
      try {
        return task.call();
      } catch (Exception e) {
        handle(e);
        throw e;
      }
    };
  }

  private Runnable createWrappedRunnable(final Runnable task) {
    return () -> {
      try {
        task.run();
      } catch (Exception e) {
        handle(e);
      }
    };
  }

  /**
   * Handle.
   *
   * @param e the e
   */
  private void handle(Exception e) {
    log.error("Caught async exception", e);
  }

  /**
   * Submit future.
   *
   * @param task the task
   * @return the future
   */
  @Override
  public Future<?> submit(Runnable task) {
    return executor.submit(createWrappedRunnable(task));
  }

  /**
   * Submit future.
   *
   * @param <T> the type parameter
   * @param task the task
   * @return the future
   */
  @Override
  public <T> Future<T> submit(Callable<T> task) {
    return executor.submit(createCallable(task));
  }

  /**
   * Destroy.
   *
   * @throws Exception the exception
   */
  @Override
  public void destroy() throws Exception {
    if (executor instanceof DisposableBean) {
      DisposableBean bean = (DisposableBean) executor;
      bean.destroy();
    }
  }

  /**
   * After properties set.
   *
   * @throws Exception the exception
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    if (executor instanceof InitializingBean) {
      InitializingBean bean = (InitializingBean) executor;
      bean.afterPropertiesSet();
    }
  }
}
