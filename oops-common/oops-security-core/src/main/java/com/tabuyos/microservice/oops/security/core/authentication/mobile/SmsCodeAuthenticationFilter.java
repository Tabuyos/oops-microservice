package com.tabuyos.microservice.oops.security.core.authentication.mobile;

import com.tabuyos.microservice.oops.security.core.properties.SecurityConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.authentication.mobile
 *   <b>class: </b>SmsCodeAuthenticationFilter
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
 * @since 0.1.0 - 3/1/21 11:11 AM
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  private static final String POST = "POST";
  // ~ Static fields/initializers
  // =====================================================================================

  private String mobileParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
  private boolean postOnly = true;

  // ~ Constructors
  // ===================================================================================================

  /**
   * Instantiates a new Sms code authentication filter.
   */
  public SmsCodeAuthenticationFilter() {
    super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE, "POST"));
  }

  // ~ Methods
  // ========================================================================================================

  /**
   * Attempt authentication authentication.
   *
   * @param request  the request
   * @param response the response
   *
   * @return the authentication
   *
   * @throws AuthenticationException the authentication exception
   */
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    throws AuthenticationException {
    if (postOnly && !POST.equals(request.getMethod())) {
      throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
    }

    String mobile = obtainMobile(request);

    if (mobile == null) {
      mobile = "";
    }

    mobile = mobile.trim();

    SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);

    // Allow subclasses to set the "details" property
    setDetails(request, authRequest);

    return this.getAuthenticationManager().authenticate(authRequest);
  }


  /**
   * 获取手机号
   *
   * @param request the request
   *
   * @return the string
   */
  protected String obtainMobile(HttpServletRequest request) {
    return request.getParameter(mobileParameter);
  }

  /**
   * Provided so that subclasses may configure what is put into the
   * authentication request's details property.
   *
   * @param request     that an authentication request is being created for
   * @param authRequest the authentication request object that should have its details            set
   */
  protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }

  /**
   * Sets the parameter name which will be used to obtain the username from
   * the login request.
   *
   * @param usernameParameter the parameter name. Defaults to "username".
   */
  public void setMobileParameter(String usernameParameter) {
    Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
    this.mobileParameter = usernameParameter;
  }


  /**
   * Defines whether only HTTP POST requests will be allowed by this filter.
   * If set to true, and an authentication request is received which is not a
   * POST request, an exception will be raised immediately and authentication
   * will not be attempted. The <tt>unsuccessfulAuthentication()</tt> method
   * will be called as if handling a failed authentication.
   * <p>
   * Defaults to <tt>true</tt> but may be overridden by subclasses.
   *
   * @param postOnly the post only
   */
  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  /**
   * Gets mobile parameter.
   *
   * @return the mobile parameter
   */
  public final String getMobileParameter() {
    return mobileParameter;
  }
}
