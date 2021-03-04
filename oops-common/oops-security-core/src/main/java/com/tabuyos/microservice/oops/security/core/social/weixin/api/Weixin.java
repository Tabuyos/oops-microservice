package com.tabuyos.microservice.oops.security.core.social.weixin.api;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.weixin.api
 *   <b>class: </b>Weixin
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 * <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 * <pre><b>email: </b>tabuyos@outlook.com</pre>
 * <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 * @version 0.1.0
 * @since 0.1.0 - 3/1/21 4:26 PM
 */
public interface Weixin {
  /**
   * Gets user info.
   *
   * @param openId the open id
   *
   * @return the user info
   */
  WeixinUserInfo getUserInfo(String openId);
}
