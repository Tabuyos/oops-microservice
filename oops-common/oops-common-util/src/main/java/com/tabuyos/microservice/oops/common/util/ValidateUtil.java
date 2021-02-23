package com.tabuyos.microservice.oops.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>ValidateUtil</i>
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
public class ValidateUtil {
	/**
	 * 校验手机号码是否合法.
	 *
	 * @param mobile the mobile
	 *
	 * @return the boolean
	 */
	public static boolean isMobileNumber(final String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return false;
		}
		final String reg = "^((\\+?86)|(\\(\\+86\\)))?(13[0-9][0-9]{8}|14[0-9]{9}|15[0-9][0-9]{8}|17[0-9][0-9]{8}|18[0-9][0-9]{8})$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}
}
