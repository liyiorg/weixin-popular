package weixin.popular.util;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * XML 数据接收对象转换工具类
 * @author LiYi
 *
 */
public class XMLConverUtil{

	private static final ThreadLocal<Map<Class<?>,Marshaller>> mMapLocal = new ThreadLocal<Map<Class<?>,Marshaller>>() {
		@Override
		protected Map<Class<?>, Marshaller> initialValue() {
			return new HashMap<>();
		}
	};

	private static final ThreadLocal<Map<Class<?>,Unmarshaller>> uMapLocal = new ThreadLocal<Map<Class<?>,Unmarshaller>>(){
		@Override
		protected Map<Class<?>, Unmarshaller> initialValue() {
			return new HashMap<>();
		}
	};

	/**
	 * XML to Object
	 * @param <T>
	 * @param clazz
	 * @param xml
	 * @return
	 */
	public static <T> T convertToObject(Class<T> clazz,String xml){
		return convertToObject(clazz,new StringReader(xml));
	}

	/**
	 * XML to Object
	 * @param <T>
	 * @param clazz
	 * @param inputStream
	 * @return
	 */
	public static <T> T convertToObject(Class<T> clazz,InputStream inputStream){
		return convertToObject(clazz,new InputStreamReader(inputStream));
	}

	/**
	 * XML to Object
	 * @param <T>
	 * @param clazz
	 * @param reader
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(Class<T> clazz,Reader reader){
		try {
			Map<Class<?>, Unmarshaller> uMap = uMapLocal.get();
			if(!uMap.containsKey(clazz)){
				JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				uMap.put(clazz, unmarshaller);
			}
			return (T) uMap.get(clazz).unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object to XML
	 * @param object
	 * @return
	 */
	public static String convertToXML(Object object){
		try {
			Map<Class<?>, Marshaller> mMap = mMapLocal.get();
			if(!mMap.containsKey(object.getClass())){
				JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
	                public void escape(char[] ac, int i, int j, boolean flag,Writer writer) throws IOException {
	                writer.write( ac, i, j ); }
	            });
				mMap.put(object.getClass(), marshaller);
			}
			StringWriter stringWriter = new StringWriter();
			mMap.get(object.getClass()).marshal(object,stringWriter);
			return stringWriter.getBuffer().toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
