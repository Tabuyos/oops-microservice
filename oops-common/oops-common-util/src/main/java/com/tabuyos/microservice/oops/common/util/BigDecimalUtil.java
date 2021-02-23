package com.tabuyos.microservice.oops.common.util;

import java.math.BigDecimal;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>BigDecimalUtil</i>
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
public class BigDecimalUtil {

  /**
   * Add big decimal.
   *
   * @param v1 the v 1
   * @param v2 the v 2
   * @return the big decimal
   */
  public static BigDecimal add(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.add(b2);
  }

  /**
   * Sub big decimal.
   *
   * @param v1 the v 1
   * @param v2 the v 2
   * @return the big decimal
   */
  public static BigDecimal sub(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.subtract(b2);
  }

  /**
   * Mul big decimal.
   *
   * @param v1 the v 1
   * @param v2 the v 2
   * @return the big decimal
   */
  public static BigDecimal mul(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.multiply(b2);
  }

  /**
   * Div big decimal.
   *
   * @param v1 the v 1
   * @param v2 the v 2
   * @return the big decimal
   */
  public static BigDecimal div(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
  }
}
