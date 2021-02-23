package com.tabuyos.microservice.oops.common.config.properties;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.config.properties</i>
 *   <b>class: </b><i>OopsProperties</i>
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
 * @since 0.1.0 - 2/3/21 2:08 PM
 */
public class OopsProperties {

  private ReliableMessageProperties message = new ReliableMessageProperties();
  private AliyunProperties aliyun = new AliyunProperties();
  private AsyncTaskProperties task = new AsyncTaskProperties();
  private SwaggerProperties swagger = new SwaggerProperties();
  private QiniuProperties qiniu = new QiniuProperties();
  private GaodeProperties gaode = new GaodeProperties();
  private JobProperties job = new JobProperties();
  private ZookeeperProperties zk = new ZookeeperProperties();

  public ReliableMessageProperties getMessage() {
    return message;
  }

  public void setMessage(ReliableMessageProperties message) {
    this.message = message;
  }

  public AliyunProperties getAliyun() {
    return aliyun;
  }

  public void setAliyun(AliyunProperties aliyun) {
    this.aliyun = aliyun;
  }

  public AsyncTaskProperties getTask() {
    return task;
  }

  public void setTask(AsyncTaskProperties task) {
    this.task = task;
  }

  public SwaggerProperties getSwagger() {
    return swagger;
  }

  public void setSwagger(SwaggerProperties swagger) {
    this.swagger = swagger;
  }

  public QiniuProperties getQiniu() {
    return qiniu;
  }

  public void setQiniu(QiniuProperties qiniu) {
    this.qiniu = qiniu;
  }

  public GaodeProperties getGaode() {
    return gaode;
  }

  public void setGaode(GaodeProperties gaode) {
    this.gaode = gaode;
  }

  public JobProperties getJob() {
    return job;
  }

  public void setJob(JobProperties job) {
    this.job = job;
  }

  public ZookeeperProperties getZk() {
    return zk;
  }

  public void setZk(ZookeeperProperties zk) {
    this.zk = zk;
  }

  @Override
  public String toString() {
    return "OopsProperties{" +
      "message=" + message +
      ", aliyun=" + aliyun +
      ", task=" + task +
      ", swagger=" + swagger +
      ", qiniu=" + qiniu +
      ", gaode=" + gaode +
      ", job=" + job +
      ", zk=" + zk +
      '}';
  }
}
