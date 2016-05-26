package weixin.popular.support.token;


/**
 * access_token信息管理类的上下文类
 * @author Moyq5
 *
 */
public class TokenContext {

	private RefreshScheduler refreshScheduler;

	private TokenStorage tokenStorage;

	private TokenType type;

	public RefreshScheduler getRefreshScheduler() {
		return refreshScheduler;
	}

	public void setRefreshScheduler(RefreshScheduler refreshScheduler) {
		this.refreshScheduler = refreshScheduler;
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
