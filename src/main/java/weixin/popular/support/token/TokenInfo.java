package weixin.popular.support.token;

/**
 * 授权令牌信息，如公众号、第三方平台等类型的令牌
 * 
 * @author Moyq5
 *
 */
public abstract class TokenInfo {
	private TokenType type;
	private String appId;
	private String accessToken;
	private int expiresIn;

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
