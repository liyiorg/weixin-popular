package weixin.popular.support.token;

import java.io.Serializable;

/**
 * 公众号授权令牌的刷新信息
 * 
 * @author Moyq5
 *
 */
public class AuthorizerRefreshInfo implements RefreshInfo, Serializable {

	private static final long serialVersionUID = 1L;
	private String componentAppId;
	private String componentAccessToken;
	private String authorizerAppId;
	private String authorizerRefreshToken;

	public String getComponentAppId() {
		return componentAppId;
	}

	public void setComponentAppId(String componentAppId) {
		this.componentAppId = componentAppId;
	}

	public String getComponentAccessToken() {
		return componentAccessToken;
	}

	public void setComponentAccessToken(String componentAccessToken) {
		this.componentAccessToken = componentAccessToken;
	}

	public String getAuthorizerAppId() {
		return authorizerAppId;
	}

	public void setAuthorizerAppId(String authorizerAppId) {
		this.authorizerAppId = authorizerAppId;
	}

	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
}
