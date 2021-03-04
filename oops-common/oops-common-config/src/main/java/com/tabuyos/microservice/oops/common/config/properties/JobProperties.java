package com.tabuyos.microservice.oops.common.config.properties;

import com.tabuyos.microservice.oops.common.base.constant.GlobalConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.config.properties</i>
 *   <b>class: </b><i>JobProperties</i>
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
 * @since 0.1.0 - 2/3/21 2:10 PM
 */
@Component
@ConfigurationProperties(prefix = GlobalConstant.OOPS_JOB_PREFIX)
public class JobProperties {

  private JobTask task = new JobTask();

  public JobTask getTask() {
    return task;
  }

  public void setTask(JobTask task) {
    this.task = task;
  }

  static class JobTask {
    private JobCoreProperties dingTalk = new JobCoreProperties();
    private JobCoreProperties sendingMessage = new JobCoreProperties();
    private JobCoreProperties waitingMessage = new JobCoreProperties();

    public JobCoreProperties getDingTalk() {
      return dingTalk;
    }

    public void setDingTalk(JobCoreProperties dingTalk) {
      this.dingTalk = dingTalk;
    }

    public JobCoreProperties getSendingMessage() {
      return sendingMessage;
    }

    public void setSendingMessage(JobCoreProperties sendingMessage) {
      this.sendingMessage = sendingMessage;
    }

    public JobCoreProperties getWaitingMessage() {
      return waitingMessage;
    }

    public void setWaitingMessage(JobCoreProperties waitingMessage) {
      this.waitingMessage = waitingMessage;
    }

    static class JobCoreProperties {
      /** 作业名称 */
      private String jobName;
      /** cron表达式，用于控制作业触发时间 */
      private String cron;
      /** 作业分片总数 */
      private int shardingTotalCount;
      /** 分片序列号和参数用等号分隔，多个键值对用逗号分隔,分片序列号从0开始，不可大于或等于作业分片总数如：0=a,1=b,2=c */
      private String shardingItemParameters;

      /** 作业自定义参数，可通过传递该参数为作业调度的业务方法传参，用于实现带参数的作业例：每次获取的数据量、作业实例从数据库读取的主键等 */
      private String jobParameter;
      /** 是否开启任务执行失效转移，开启表示如果作业在一次任务执行中途宕机，允许将该次未完成的任务在另一作业节点上补偿执行 */
      private boolean failover;
      /** 是否开启错过任务重新执行 */
      private boolean misfire = true;
      /** 作业描述信息 */
      private String description;

      /**
       * 配置jobProperties定义的枚举控制Elastic-Job的实现细节JOB_EXCEPTION_HANDLER用于扩展异常处理类EXECUTOR_SERVICE_HANDLER用于扩展作业处理线程池类
       */
      private Enum<?> jobProperties;

      public String getJobName() {
        return jobName;
      }

      public void setJobName(String jobName) {
        this.jobName = jobName;
      }

      public String getCron() {
        return cron;
      }

      public void setCron(String cron) {
        this.cron = cron;
      }

      public int getShardingTotalCount() {
        return shardingTotalCount;
      }

      public void setShardingTotalCount(int shardingTotalCount) {
        this.shardingTotalCount = shardingTotalCount;
      }

      public String getShardingItemParameters() {
        return shardingItemParameters;
      }

      public void setShardingItemParameters(String shardingItemParameters) {
        this.shardingItemParameters = shardingItemParameters;
      }

      public String getJobParameter() {
        return jobParameter;
      }

      public void setJobParameter(String jobParameter) {
        this.jobParameter = jobParameter;
      }

      public boolean isFailover() {
        return failover;
      }

      public void setFailover(boolean failover) {
        this.failover = failover;
      }

      public boolean isMisfire() {
        return misfire;
      }

      public void setMisfire(boolean misfire) {
        this.misfire = misfire;
      }

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public Enum<?> getJobProperties() {
        return jobProperties;
      }

      public void setJobProperties(Enum<?> jobProperties) {
        this.jobProperties = jobProperties;
      }

      @Override
      public String toString() {
        return "JobCoreProperties{"
            + "jobName='"
            + jobName
            + '\''
            + ", cron='"
            + cron
            + '\''
            + ", shardingTotalCount="
            + shardingTotalCount
            + ", shardingItemParameters='"
            + shardingItemParameters
            + '\''
            + ", jobParameter='"
            + jobParameter
            + '\''
            + ", failover="
            + failover
            + ", misfire="
            + misfire
            + ", description='"
            + description
            + '\''
            + ", jobProperties="
            + jobProperties
            + '}';
      }
    }

    @Override
    public String toString() {
      return "JobTask{"
          + "dingTalk="
          + dingTalk
          + ", sendingMessage="
          + sendingMessage
          + ", waitingMessage="
          + waitingMessage
          + '}';
    }
  }

  @Override
  public String toString() {
    return "JobProperties{" + "task=" + task + '}';
  }
}
