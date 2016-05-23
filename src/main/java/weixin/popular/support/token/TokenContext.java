package weixin.popular.support.token;


/**
 * access_token信息管理类的上下文类
 * @author Moyq5
 *
 */
public class TokenContext {

	private RefreshInvoker refreshInvoker;

	private TokenStorage tokenStorage;

	private TokenType type;

	public RefreshInvoker getRefreshInvoker() {
		return refreshInvoker;
	}

	public void setRefreshInvoker(RefreshInvoker refreshInvoker) {
		this.refreshInvoker = refreshInvoker;
	}

	public TokenStorage getTokenStorage() {
		return tokenStorage;
	}

	public void setTokenStorage(TokenStorage tokenStorage) {
		this.tokenStorage = tokenStorage;
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}
}
