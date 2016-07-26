package weixin.popular.support.token;

/**
 * 公众号授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public abstract class AuthorizerTokenManager extends TokenManager<AuthorizerTokenInfo> {

	protected AuthorizerTokenManager(TokenContext context) {
		super(context);
	}

	/**
	 * 获取公众号授权令牌
	 * @param componentAppId 第三方平台应用AppId
	 * @param authorizeAppId 公众号AppId
	 * @return
	 */
	public String getAccessToken(String componentAppId, String authorizeAppId) {
		return context.getTokenStorage().getAccessToken(TokenType.AUTHORIZER, componentAppId, authorizeAppId, null);
	}

	
}
