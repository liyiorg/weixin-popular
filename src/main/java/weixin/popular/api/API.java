package weixin.popular.api;

/**
 * API 设置
 * 
 * 
 * 2.8.6
 * 
 * @author LiYi
 *
 */
public class API {

	private static final String KEY_JOIN = "#";

	private static APIHandler apiHandler;

	/**
	 * 判断参数表现形式
	 * 
	 * @param keyParam
	 *            keyParam
	 * @return boolean
	 */
	private static boolean isKeyParam(String keyParam) {
		// ACCESS_TOKEN_LENGTH 138
		// TICKET_LENGTH 86
		// KEY_MAX_LENGTH 18+1+18
		return keyParam != null && keyParam.length() < 50;
	}

	/**
	 * keys 组合
	 * 
	 * @param component_appid
	 *            component_appid
	 * @param authorizer_appid
	 *            authorizer_appid
	 * @return keyParam
	 */
	public static String keyParam(String component_appid, String authorizer_appid) {
		return String.format("%s%s%s", component_appid, KEY_JOIN, authorizer_appid);
	}

	/**
	 * 获取access_token
	 * 
	 * @param key
	 *            key
	 * @return access_token
	 */
	public static String accessToken(String key) {
		if (isKeyParam(key)) {
			String[] keys = key.split(KEY_JOIN);
			if (keys.length == 2) {
				return apiHandler.accessToken(keys[0], keys[1]);
			} else if (keys.length == 1) {
				return apiHandler.accessToken(keys[0]);
			}
		}
		return key;
	}

	/**
	 * 获取component_access_token
	 * 
	 * @param key
	 *            key
	 * @return component_access_token
	 */
	public static String componentAccessToken(String key) {
		if (isKeyParam(key)) {
			return apiHandler.componentAccessToken(key);
		}
		return key;
	}

	/**
	 * 获取ticket
	 * 
	 * @param key
	 *            key
	 * @param type
	 *            类型 jsapi,wx_card
	 * @return ticket
	 */
	public static String ticket(String key, String type) {
		if (isKeyParam(key)) {
			String[] keys = key.split(KEY_JOIN);
			if (keys.length == 2) {
				return apiHandler.ticket(keys[0], keys[1], type);
			} else if (keys.length == 1) {
				return apiHandler.ticket(keys[0], type);
			}
		}
		return key;
	}

	public static APIHandler getApiHandler() {
		return apiHandler;
	}

	public static void setApiHandler(APIHandler apiHandler) {
		API.apiHandler = apiHandler;
	}

	public interface APIHandler {

		public String accessToken(String component_appid, String authorizer_appid);

		public String accessToken(String appid);

		public String componentAccessToken(String component_appid);

		public String ticket(String component_appid, String authorizer_appid, String type);

		public String ticket(String appid, String type);
	}

}
