package weixin.popular.support.token;

/**
 * 授权令牌管理抽象
 * 
 * @author Moyq5
 *
 */
public abstract class TokenManager<T extends TokenInfo> {

	protected TokenContext context;

	protected TokenManager(TokenContext context) {
		this.context = context;
	}

	public synchronized void refreshOverdue() {
		context.getRefreshScheduler().execute();
	}

	public void addTokenInfo(T tokenInfo) {
		context.getTokenStorage().update(tokenInfo);
	}

}
