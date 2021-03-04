package com.tabuyos.microservice.oops.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.security.core.social.support
 *   <b>class: </b>PcSpringSocialConfigurer
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
 * @since 0.1.0 - 3/1/21 4:22 PM
 */
public class PcSpringSocialConfigurer extends SpringSocialConfigurer {
  private String filterProcessesUrl;

  private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

  /**
   * Instantiates a new Pc spring social configurer.
   *
   * @param filterProcessesUrl the filter processes url
   */
  public PcSpringSocialConfigurer(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  /**
   * Post process t.
   *
   * @param <T>    the type parameter
   * @param object the object
   *
   * @return the t
   */
  @SuppressWarnings("unchecked")
  @Override
  protected <T> T postProcess(T object) {
    SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
    filter.setFilterProcessesUrl(filterProcessesUrl);
    if (socialAuthenticationFilterPostProcessor != null) {
      socialAuthenticationFilterPostProcessor.process(filter);
    }
    return (T) filter;
  }

  /**
   * Gets filter processes url.
   *
   * @return the filter processes url
   */
  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  /**
   * Sets filter processes url.
   *
   * @param filterProcessesUrl the filter processes url
   */
  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  /**
   * Gets social authentication filter post processor.
   *
   * @return the social authentication filter post processor
   */
  public SocialAuthenticationFilterPostProcessor getSocialAuthenticationFilterPostProcessor() {
    return socialAuthenticationFilterPostProcessor;
  }

  /**
   * Sets social authentication filter post processor.
   *
   * @param socialAuthenticationFilterPostProcessor the social authentication filter post processor
   */
  public void setSocialAuthenticationFilterPostProcessor(SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor) {
    this.socialAuthenticationFilterPostProcessor = socialAuthenticationFilterPostProcessor;
  }

}
