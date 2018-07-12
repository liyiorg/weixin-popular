package weixin.popular.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

/**
 * XML 数据接收对象转换工具类
 * @author LiYi
 *
 */
public class XMLConverUtil{
	
	private static Logger logger = LoggerFactory.getLogger(XMLConverUtil.class);

	private static Map<Class<?>, Marshaller> M_MAP;

	private static Map<Class<?>, Unmarshaller> U_MAP;
	
	private XMLConverUtil(){}

	static {
		M_MAP = new ConcurrentHashMap<Class<?>, Marshaller>();
		U_MAP = new ConcurrentHashMap<Class<?>, Unmarshaller>();
	}
	
	/**
	 * XML to Object
	 * @param <T> T
	 * @param clazz clazz
	 * @param xml xml
	 * @return T
	 */
	public static <T> T convertToObject(Class<T> clazz,String xml){
		return convertToObject(clazz,new StringReader(xml));
	}

	/**
	 * XML to Object
	 * @param <T> T
	 * @param clazz clazz
	 * @param inputStream  inputStream
	 * @return T
	 */
	public static <T> T convertToObject(Class<T> clazz,InputStream inputStream){
		return convertToObject(clazz,new InputStreamReader(inputStream));
	}
	
	/**
	 * XML to Object
	 * @param <T> T
	 * @param clazz clazz
	 * @param inputStream  inputStream
	 * @param charset charset
	 * @return T
	 */
	public static <T> T convertToObject(Class<T> clazz,InputStream inputStream,Charset charset){
		return convertToObject(clazz,new InputStreamReader(inputStream, charset));
	}

	/**
	 * XML to Object
	 * @param <T> T
	 * @param clazz clazz
	 * @param reader reader
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(Class<T> clazz,Reader reader){
		try {
			if(!U_MAP.containsKey(clazz)){
				JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				U_MAP.put(clazz, unmarshaller);
			}
			return (T) U_MAP.get(clazz).unmarshal(reader);
		} catch (JAXBException e) {
			logger.error("", e);
		}
		return null;
	}

	/**
	 * Object to XML
	 * @param object object
	 * @return xml
	 */
	public static String convertToXML(Object object){
		try {
			if(!M_MAP.containsKey(object.getClass())){
				JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				//设置CDATA输出字符
				marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
					public void escape(char[] ac, int i, int j, boolean flag, Writer writer) throws IOException {
						writer.write(ac, i, j);
					}
				});
				M_MAP.put(object.getClass(), marshaller);
			}
			StringWriter stringWriter = new StringWriter();
			M_MAP.get(object.getClass()).marshal(object,stringWriter);
			return stringWriter.getBuffer().toString();
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	/**
	 * 转换简单的xml to map
	 * @param xml xml
	 * @return map
	 */
	public static Map<String,String> convertToMap(String xml){
		Map<String, String> map = new LinkedHashMap<String,String>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			/*
			 * 避免 XXE 攻击
			 * @since 2.8.21 
			 */
			dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
	        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
	        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
	        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	        dbf.setXIncludeAware(false);
	        dbf.setExpandEntityReferences(false);
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xml);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			if(root != null){
				NodeList childNodes = root.getChildNodes();
				if(childNodes != null && childNodes.getLength()>0){
					for(int i = 0;i < childNodes.getLength();i++){
						Node node = childNodes.item(i); 
						if( node != null && node.getNodeType() == Node.ELEMENT_NODE){
							map.put(node.getNodeName(), node.getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return map;
	}
	
}
