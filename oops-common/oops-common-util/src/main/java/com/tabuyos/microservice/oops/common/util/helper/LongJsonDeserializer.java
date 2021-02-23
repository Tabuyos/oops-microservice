package com.tabuyos.microservice.oops.common.util.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util.helper</i>
 *   <b>class: </b><i>LongJsonDeserializer</i>
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
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class LongJsonDeserializer extends JsonDeserializer<Long> {

  private final Logger log = LoggerFactory.getLogger(LongJsonDeserializer.class);

	/**
	 * Deserialize long.
	 *
	 * @param jsonParser             the json parser
	 * @param deserializationContext the deserialization context
	 *
	 * @return the long
	 */
	@Override
	public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
		String value = null;
		try {
			value = jsonParser.getText();
		} catch (IOException e) {
			log.error("deserialize={}", e.getMessage(), e);
		}
		try {
			return value == null ? null : Long.parseLong(value);
		} catch (NumberFormatException e) {
			log.error("解析长整形错误", e);
			return null;
		}
	}
}
