package weixin.popular.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	private static ObjectMapper om = new ObjectMapper();
	
	static {
		om.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
		om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		om.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
		
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		om.disable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
		om.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		try {
			return om.readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJson(Object object) {
		try {
			return om.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
