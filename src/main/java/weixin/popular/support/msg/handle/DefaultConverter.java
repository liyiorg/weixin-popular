package weixin.popular.support.msg.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 默认的消息对象转换器
 * 
 * @author Moyq5
 *
 */
public class DefaultConverter implements Converter {

	private static Logger log = LoggerFactory.getLogger(DefaultConverter.class);

	private static ObjectMapper xmlMapper = new XmlMapper();

	static {
		xmlMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		xmlMapper.disable(MapperFeature.AUTO_DETECT_GETTERS);
		xmlMapper.disable(MapperFeature.AUTO_DETECT_SETTERS);
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	@Override
	public <T> T toObject(Class<T> clazz, String msg) {
		try {
			return xmlMapper.readValue(msg, clazz);
		} catch (Exception e) {
			log.error("xml 转 java 失败", e);
		}
		return null;
	}

	@Override
	public String toXml(Object obj) {
		try {
			return xmlMapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("java 转  xml 失败", e);
		}
		return null;
	}

}
