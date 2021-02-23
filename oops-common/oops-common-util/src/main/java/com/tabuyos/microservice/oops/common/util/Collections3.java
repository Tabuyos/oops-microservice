package com.tabuyos.microservice.oops.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>Collections3</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class Collections3 {

  /**
   * 返回a+b的新List.
   *
   * @param <T> the type parameter
   * @param a the a
   * @param b the b
   * @return the list
   */
  public static <T> List<T> union(final Collection<T> a, final Collection<T> b) {
    List<T> result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 返回a-b的新List.
   *
   * @param <T> the type parameter
   * @param a the a
   * @param b the b
   * @return the list
   */
  public static <T> List<T> subtract(final Collection<T> a, final Collection<T> b) {
    List<T> list = new ArrayList<>(a);
    for (T element : b) {
      list.remove(element);
    }

    return list;
  }

  /**
   * 返回a与b的交集的新List.
   *
   * @param <T> the type parameter
   * @param a the a
   * @param b the b
   * @return the list
   */
  public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
    List<T> list = new ArrayList<>();

    for (T element : a) {
      if (b.contains(element)) {
        list.add(element);
      }
    }
    return list;
  }
}
