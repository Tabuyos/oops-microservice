package com.tabuyos.microservice.oops.security.core.social.qq.connect;

import com.tabuyos.microservice.oops.security.core.social.qq.api.QQ;
import com.tabuyos.microservice.oops.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.qq.connect
 *   <b>class: </b>QQAdapter
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
 * @since 0.1.0 - 3/1/21 4:14 PM
 */
public class QQAdapter implements ApiAdapter<QQ> {
  /**
   * Test boolean.
   *
   * @param api the api
   *
   * @return the boolean
   */
  @Override
  public boolean test(QQ api) {
    return true;
  }

  /**
   * Sets connection values.
   *
   * @param api    the api
   * @param values the values
   */
  @Override
  public void setConnectionValues(QQ api, ConnectionValues values) {
    QQUserInfo userInfo = api.getUserInfo();

    values.setDisplayName(userInfo.getNickname());
    values.setImageUrl(userInfo.getFigureUrlQq1());
    values.setProfileUrl(null);
    values.setProviderUserId(userInfo.getOpenId());
  }

  /**
   * Fetch user profile user profile.
   *
   * @param api the api
   *
   * @return the user profile
   */
  @Override
  public UserProfile fetchUserProfile(QQ api) {
    return null;
  }

  /**
   * Update status.
   *
   * @param api     the api
   * @param message the message
   */
  @Override
  public void updateStatus(QQ api, String message) {
    //do noting
  }
}
