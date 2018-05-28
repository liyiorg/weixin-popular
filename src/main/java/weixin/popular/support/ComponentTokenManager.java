package weixin.popular.support;

import weixin.popular.bean.component.ApiQueryAuthResult;

/**
 * ComponentTokenManager 第三方平台token 管理
 * 
 * @author LiYi
 * @since 2.8.20
 */
public interface ComponentTokenManager {

	/**
	 * 获取 component_access_token
	 * 
	 * @param component_appid
	 * @return
	 */
	String getComponentAccessToken(String component_appid);

	/**
	 * 获取 component_access_token <br>
	 * 适用于单一第三方平台环境
	 * 
	 * @return
	 */
	String getComponentAccessToken();

	/**
	 * 获取 authorizer_access_token
	 * 
	 * @param component_appid
	 * @param authorizer_appid
	 * @return
	 */
	String getAuthorizerAccessToken(String component_appid, String authorizer_appid);

	/**
	 * 获取 authorizer_access_token<br>
	 * 适用于单一第三方平台环境
	 * 
	 * @param authorizer_appid
	 * @return
	 */
	String getAuthorizerAccessToken(String authorizer_appid);

	/**
	 * 刷新 component_access_token
	 * 
	 * @param component_appid
	 * @param component_verify_ticket
	 */
	void component_verify_ticket(String component_appid, String component_appsecret, String component_verify_ticket);

	/**
	 * 授权事件
	 * 
	 * @param component_appid
	 * @param authorizationCode
	 * @return
	 */
	ApiQueryAuthResult authorized(String component_appid, String authorizationCode);

	/**
	 * 取消授权事件
	 * 
	 * @param component_appid
	 * @param authorizer_appid
	 */
	void unauthorized(String component_appid, String authorizer_appid);
}
