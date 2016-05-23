package weixin.popular.support.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.AuthorizerAccessToken;

/**
 * 第三方平台authorizer_access_token刷新类
 * 
 * @author Moyq5
 *
 */
public class AuthorizerRefreshInvoker extends RefreshInvokerAbstract<AuthorizerRefreshInfo, AuthorizerTokenInfo> {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorizerRefreshInvoker.class);
	
	private static AuthorizerRefreshInvoker instance = new AuthorizerRefreshInvoker();

	private AuthorizerRefreshInvoker() {
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public static AuthorizerRefreshInvoker getInstance() {
		return instance;
	}

	/**
	 * 刷新并返回新授权令牌
	 */
	@Override
	protected AuthorizerTokenInfo execute(AuthorizerRefreshInfo refreshInfo) {
		AuthorizerRefreshInfo ari = (AuthorizerRefreshInfo) refreshInfo;
		AuthorizerAccessToken aat = ComponentAPI.api_authorizer_token(
				ari.getComponentAccessToken(), ari.getComponentAppId(),
				ari.getAuthorizerAppId(), ari.getAuthorizerRefreshToken());
		
		if (!aat.isSuccess()) {
			logger.warn("第三方平台公众号授权令牌刷新失败：componentAppId={},appId={},code={},msg={}", 
					new Object[]{ari.getComponentAppId(), ari.getAuthorizerAppId(), aat.getErrcode(), aat.getErrmsg()});
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
		return AuthorizerManager.getTokenStorage();
	}

}
