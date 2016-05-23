package weixin.popular.support.token;

import java.io.Serializable;

/**
 * 第三方平台公众号授权令牌信息
 * 
 * @author Moyq5
 *
 */
public class AuthorizerTokenInfo extends TokenInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String componentAppId;
	private String refreshToken;

	public String getComponentAppId() {
		return componentAppId;
	}

	public void setComponentAppId(String componentAppId) {
		this.componentAppId = componentAppId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
