package com.tabuyos.microservice.oops.tabuyos;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.sun.jdi.connect.Transport;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>oops-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.tabuyos</i>
 *   <b>class: </b><i>TabuyosTest</i>
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
 * @since 0.1.0 - 2/24/21 10:36 AM
 */
public class TabuyosTest {

  @BeforeEach
  void setUp() {
    System.out.println("Test Before.");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test After.");
  }

  @Test
  public void testMonoBasic() {
    Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
    Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
    Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
  }

  @Test
  public void testBasic() {
    Flux.just("Hello", "World").subscribe(System.out::println);
    Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
    Flux.empty().subscribe(System.out::println);
    Flux.range(1, 10).subscribe(System.out::println);
    Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
  }

  @Test
  public void testEMail() throws Exception {
    Email email = new SimpleEmail();
    //设置主机名
    email.setHostName("smtp.office365.com");
    email.setStartTLSEnabled(true);
//    email.setStartTLSRequired(true);
    email.setSSLOnConnect(false);
    email.setSmtpPort(587);
    // 用户名和密码为邮箱的账号和授权码（不需要进行base64编码）
    email.setAuthenticator(new DefaultAuthenticator("tabuyos@outlook.com", "aaronliew95"));
    //设置来源,就是发送方的邮箱地址
    email.setFrom("tabuyos@outlook.com");
    //设置主题,可以不设置
    email.setSubject("java 发送邮件");
    //设置信息,就是内容,这个必须要有
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    email.setMsg("这是测试邮件 ... :-) 当前时间: " + format.format(new Date()));
    //接收人邮箱地址
    email.addTo("746289172@qq.com");
    email.send();
  }

  @Test
  public void testDigest() {
    Digester sha512 = new Digester(DigestAlgorithm.SHA512);
    String hex = sha512.digestHex("tabuyos0, tabuyos1", StandardCharsets.UTF_8);
    System.out.println(hex.hashCode());
  }
}
