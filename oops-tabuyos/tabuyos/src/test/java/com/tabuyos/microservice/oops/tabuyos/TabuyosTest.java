package com.tabuyos.microservice.oops.tabuyos;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>oops-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.tabuyos</i>
 *   <b>class: </b><i>TabuyosTest</i>
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
    Mono.fromSupplier(() -> "Hello")
        .subscribe(System.out::println);
    Mono.justOrEmpty(Optional.of("Hello"))
        .subscribe(System.out::println);
    Mono.create(sink -> sink.success("Hello"))
        .subscribe(System.out::println);
  }

  @Test
  public void testBasic() {
    Flux.just("Hello", "World")
        .subscribe(System.out::println);
    Flux.fromArray(new Integer[]{1, 2, 3})
        .subscribe(System.out::println);
    Flux.empty()
        .subscribe(System.out::println);
    Flux.range(1, 10)
        .subscribe(System.out::println);
    Flux.interval(Duration.of(10, ChronoUnit.SECONDS))
        .subscribe(System.out::println);
  }
}
