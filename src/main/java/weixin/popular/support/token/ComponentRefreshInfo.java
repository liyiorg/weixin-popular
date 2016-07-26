package weixin.popular.support.token;

import java.io.Serializable;

/**
 * 第三方平台授权令牌的刷新信息
 * 
 * @author Moyq5
 *
 */
public class ComponentRefreshInfo implements RefreshInfo, Serializable {

	private static final long serialVersionUID = 1L;
	private String appId;
	private String appSecret;
	private String verifyTicket;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getVerifyTicket() {
		return verifyTicket;
	}

	public void setVerifyTicket(String verifyTicket) {
		this.verifyTicket = verifyTicket;
	}
}
