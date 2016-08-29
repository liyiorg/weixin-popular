package weixin.popular.support.msg.handle;

/**
 * 消息对象转换器
 * @author Moyq5
 *
 */
public interface Converter {
	
	/**
	 * 将xml转换成java对象
	 * @param clazz
	 * @param msg
	 * @return
	 */
	public <T> T toObject(Class<T> clazz, String msg);
	
	/**
	 * 将java对象转换成xml
	 * @param obj
	 * @return
	 */
	public String toXml(Object obj);
}
