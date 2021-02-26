package com.tabuyos.microservice.oops.common.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>JacksonUtil</i>
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
public class JacksonUtil {

	private static final ObjectMapper OBJECT_MAPPER;
	private static final ObjectMapper FORMATTED_MAPPER;

	static {
		// 默认的ObjectMapper
		OBJECT_MAPPER = new ObjectMapper();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		OBJECT_MAPPER.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		FORMATTED_MAPPER = new ObjectMapper();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		FORMATTED_MAPPER.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 所有日期格式都统一为固定格式
		FORMATTED_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		FORMATTED_MAPPER.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	/**
	 * 将对象转化为json数据
	 *
	 * @param obj the obj
	 *
	 * @return string string
	 *
	 * @throws IOException the io exception
	 */
	public static String toJson(Object obj) throws IOException {
		Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
		return OBJECT_MAPPER.writeValueAsString(obj);
	}

	/**
	 * json数据转化为对象(Class)
	 * User u = JacksonUtil.parseJson(jsonValue, User.class);
	 * User[] arr = JacksonUtil.parseJson(jsonValue, User[].class);
	 *
	 * @param <T>       the type parameter
	 * @param jsonValue the json value
	 * @param valueType the value type
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	public static <T> T parseJson(String jsonValue, Class<T> valueType) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
		return OBJECT_MAPPER.readValue(jsonValue, valueType);
	}

	/**
	 * json数据转化为对象(JavaType)
	 *
	 * @param <T>       the type parameter
	 * @param jsonValue the json value
	 * @param valueType the value type
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseJson(String jsonValue, JavaType valueType) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
		return (T) OBJECT_MAPPER.readValue(jsonValue, valueType);
	}

	/**
	 * json数据转化为对象(TypeReference)
	 *
	 * @param <T>          the type parameter
	 * @param jsonValue    the json value
	 * @param valueTypeRef the value type ref
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	public static <T> T parseJson(String jsonValue, TypeReference<T> valueTypeRef) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
    return OBJECT_MAPPER.readValue(jsonValue, valueTypeRef);
	}

	/**
	 * 将对象转化为json数据(时间转换格式： "yyyy-MM-dd HH:mm:ss")
	 *
	 * @param obj the obj
	 *
	 * @return string string
	 *
	 * @throws IOException the io exception
	 */
	public static String toJsonWithFormat(Object obj) throws IOException {
		Preconditions.checkArgument(obj != null, "this argument is required; it must not be null");
		return FORMATTED_MAPPER.writeValueAsString(obj);
	}

	/**
	 * json数据转化为对象(时间转换格式： "yyyy-MM-dd HH:mm:ss")
	 * User u = JacksonUtil.parseJsonWithFormat(jsonValue, User.class);
	 * User[] arr = JacksonUtil.parseJsonWithFormat(jsonValue, User[].class);
	 *
	 * @param <T>       the type parameter
	 * @param jsonValue the json value
	 * @param valueType the value type
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	public static <T> T parseJsonWithFormat(String jsonValue, Class<T> valueType) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
		return FORMATTED_MAPPER.readValue(jsonValue, valueType);
	}

	/**
	 * json数据转化为对象(JavaType)
	 *
	 * @param <T>       the type parameter
	 * @param jsonValue the json value
	 * @param valueType the value type
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	public static <T> T parseJsonWithFormat(String jsonValue, JavaType valueType) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "this argument is required; it must not be null");
    return FORMATTED_MAPPER.readValue(jsonValue, valueType);
	}

	/**
	 * json数据转化为对象(TypeReference)
	 *
	 * @param <T>          the type parameter
	 * @param jsonValue    the json value
	 * @param valueTypeRef the value type ref
	 *
	 * @return t t
	 *
	 * @throws IOException the io exception
	 */
	public static <T> T parseJsonWithFormat(String jsonValue, TypeReference<T> valueTypeRef) throws IOException {
		Preconditions.checkArgument(StringUtils.isNotEmpty(jsonValue), "jsonValue is not null");
		return FORMATTED_MAPPER.readValue(jsonValue, valueTypeRef);
	}

}
