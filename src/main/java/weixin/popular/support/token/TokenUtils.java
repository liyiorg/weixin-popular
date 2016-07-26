package weixin.popular.support.token;

/**
 * token管理工具类
 * 
 * @author Moyq5
 *
 */
public abstract class TokenUtils {

	/**
	 * 获取第三方平台"应用"access_token
	 * @param componentAppId
	 * @return
	 */
	public static String getComponentAccessToken(String componentAppId) {
		return ComponentManager.getInstance().getAccessToken(componentAppId);
	}

	/**
	 * 获取第三方平台"公众号"access_token
	 * @param componentAppId
	 * @param authorizeAppId
	 * @return
	 */
	public static String getAuthorizerAccessToken(String componentAppId, String authorizeAppId) {
		return AuthorizerManager.getInstance().getAccessToken(componentAppId, authorizeAppId);
	}

	/**
	 * 指定第三方平台“应用”token信息存储实现，
	 * 默认使用DefaultComponentStorage
	 * @param tokenStorage
	 * @see DefaultComponentStorage
	 */
	public static void setComponentTokenStorage(TokenStorage tokenStorage) {
		ComponentManager.setTokenStorage(tokenStorage);
	}

	/**
	 * 指定第三方平台“公众号”token信息存储实现，
	 * 默认使用DefaultAuthorizerStorage
	 * @param tokenStorage
	 * @see DefaultAuthorizerStorage
	 */
	public static void setAuthorizerTokenStorage(TokenStorage tokenStorage) {
		AuthorizerManager.setTokenStorage(tokenStorage);
	}

	/**
	 * 添加第三方平台“应用”授权信息，
	 * 即在系统中增加一个第三方平台应用的信息时，用来记录新应用的授权信息
	 * @param tokenInfo
	 */
	public static void addComponentTokenInfo(ComponentTokenInfo tokenInfo) {
		ComponentManager.getInstance().addTokenInfo(tokenInfo);
	}

	/**
	 * 添加第三方平台“公众号”授权信息，
	 * 即公众号授权第三方平台应用后，用来记录授权信息
	 * @param tokenInfo
	 */
	public static void addAuthorizerTokenInfo(AuthorizerTokenInfo tokenInfo) {
		AuthorizerManager.getInstance().addTokenInfo(tokenInfo);
	}
}
