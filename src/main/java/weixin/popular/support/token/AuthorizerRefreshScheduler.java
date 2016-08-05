package weixin.popular.support.token;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.AuthorizerAccessToken;

/**
 * 第三方平台authorizer_access_token刷新类
 * 
 * @author Moyq5
 *
 */
public class AuthorizerRefreshScheduler extends RefreshSchedulerAbstract<AuthorizerRefreshInfo, AuthorizerTokenInfo> {
	
	private static AuthorizerRefreshScheduler instance = new AuthorizerRefreshScheduler();

	private AuthorizerRefreshScheduler() {
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public static AuthorizerRefreshScheduler getInstance() {
		return instance;
	}

	/**
	 * 刷新并返回新授权令牌
	 */
	@Override
	protected AuthorizerTokenInfo execute(AuthorizerRefreshInfo ari) {
		AuthorizerAccessToken aat = ComponentAPI.api_authorizer_token(
				ari.getComponentAccessToken(), ari.getComponentAppId(),
				ari.getAuthorizerAppId(), ari.getAuthorizerRefreshToken());
		
		if (!aat.isSuccess()) {
			AuthorizerManager.getInstance().getContext().getRefreshMsgHandler().handle(ari.getAuthorizerAppId(), aat.getErrcode(), aat.getErrmsg());
			return null;
		}
		
		AuthorizerTokenInfo ati = new AuthorizerTokenInfo();
		ati.setAppId(ari.getAuthorizerAppId());
		ati.setRefreshToken(aat.getAuthorizer_refresh_token());
		ati.setComponentAppId(ari.getComponentAppId());
		ati.setExpiresIn(aat.isSuccess() ? aat.getExpires_in():0);
		ati.setAccessToken(aat.getAuthorizer_access_token());
		ati.setType(TokenType.AUTHORIZER);
		return ati;
	}

	@Override
	protected TokenStorage  getTokenStorage() {
		return AuthorizerManager.getInstance().getContext().getTokenStorage();
	}

}
