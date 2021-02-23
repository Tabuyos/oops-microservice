/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：RandomUtil.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.tabuyos.microservice.oops.common.util;

import java.util.Random;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>RandomUtil</i>
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
public class RandomUtil {

	private static final int MAX_LENGTH = 50;

	/**
	 * 生成一个随机验证码 大小写字母+数字
	 *
	 * @param length the length
	 *
	 * @return 随机验证码 string
	 */
	public static String createComplexCode(int length) {

		if (length > MAX_LENGTH) {
			length = MAX_LENGTH;
		}

		Random r = new Random();

		StringBuilder code = new StringBuilder();

		while (true) {
			if (code.length() == length) {
				break;
			}
			int tmp = r.nextInt(127);
			if (tmp < 33 || tmp == 92 || tmp == 47 || tmp == 34) {
				continue;
			}
			char x = (char) (tmp);
			if (code.toString().indexOf(x) > 0) {
				continue;
			}
			code.append(x);
		}

		return code.toString();
	}

	/**
	 * Create number code string.
	 *
	 * @param length the length
	 *
	 * @return the string
	 */
	public static String createNumberCode(int length) {
		return randomString("0123456789", length);
	}

	private static String randomString(String baseString, int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		if (length < 1) {
			length = 1;
		}

		int baseLength = baseString.length();

		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(baseLength);
			sb.append(baseString.charAt(number));
		}

		return sb.toString();
	}
}
