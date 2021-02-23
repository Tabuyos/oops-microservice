package com.tabuyos.microservice.oops.common.config.properties;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.config.properties</i>
 *   <b>class: </b><i>QiniuProperties</i>
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
 * @since 0.1.0 - 2/3/21 2:10 PM
 */
public class QiniuProperties {

  private QiniuKeyProperties key = new QiniuKeyProperties();
  private QiniuOssProperties oss = new QiniuOssProperties();

  public QiniuKeyProperties getKey() {
    return key;
  }

  public void setKey(QiniuKeyProperties key) {
    this.key = key;
  }

  public QiniuOssProperties getOss() {
    return oss;
  }

  public void setOss(QiniuOssProperties oss) {
    this.oss = oss;
  }

  static class QiniuKeyProperties {
    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
      return accessKey;
    }

    public void setAccessKey(String accessKey) {
      this.accessKey = accessKey;
    }

    public String getSecretKey() {
      return secretKey;
    }

    public void setSecretKey(String secretKey) {
      this.secretKey = secretKey;
    }

    @Override
    public String toString() {
      return "QiniuKeyProperties{" +
        "accessKey='" + accessKey + '\'' +
        ", secretKey='" + secretKey + '\'' +
        '}';
    }
  }

  static class QiniuOssProperties {
    private String privateHost;
    private String publicHost;
    private Long fileMaxSize;

    public String getPrivateHost() {
      return privateHost;
    }

    public void setPrivateHost(String privateHost) {
      this.privateHost = privateHost;
    }

    public String getPublicHost() {
      return publicHost;
    }

    public void setPublicHost(String publicHost) {
      this.publicHost = publicHost;
    }

    public Long getFileMaxSize() {
      return fileMaxSize;
    }

    public void setFileMaxSize(Long fileMaxSize) {
      this.fileMaxSize = fileMaxSize;
    }

    @Override
    public String toString() {
      return "QiniuOssProperties{" +
        "privateHost='" + privateHost + '\'' +
        ", publicHost='" + publicHost + '\'' +
        ", fileMaxSize=" + fileMaxSize +
        '}';
    }
  }

  @Override
  public String toString() {
    return "QiniuProperties{" +
      "key=" + key +
      ", oss=" + oss +
      '}';
  }
}
