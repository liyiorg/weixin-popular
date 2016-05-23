package weixin.popular.support.token;

/**
 * 第三方平台应用授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public abstract class ComponentTokenManager extends TokenManager<ComponentTokenInfo> {

	protected ComponentTokenManager(TokenContext context) {
		super(context);
	}

	/**
	 * 第三方平台应用授权令牌
	 * @param componentAppId 第三方平台应用AppId
	 * @return
	 */
	public String getAccessToken(String componentAppId) {
		return context.getTokenStorage().getAccessToken(TokenType.COMPONENT, componentAppId, null, null);
	}
}
