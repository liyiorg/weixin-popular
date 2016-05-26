package weixin.popular.support.token;


/**
 * 公众号授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public class AuthorizerManager extends AuthorizerTokenManager {

	private static AuthorizerTokenManager manager;

	private static TokenStorage tokenStorage = new DefaultAuthorizerStorage();

	static {
		TokenContext context = new TokenContext();
		context.setRefreshScheduler(AuthorizerRefreshScheduler.getInstance());
		context.setTokenStorage(tokenStorage);
		context.setType(TokenType.AUTHORIZER);
		manager = new AuthorizerManager(context);
	}

	private AuthorizerManager(TokenContext context) {
		super(context);
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public static AuthorizerTokenManager getInstance() {
		return manager;
	}

	/**
	 * 获取token存储器对象
	 * 
	 * @return
	 */
	public static TokenStorage getTokenStorage() {
		return tokenStorage;
	}

	/**
	 * 指定token存储器对象
	 * 
	 * @param tokenStorage
	 */
	public static void setTokenStorage(TokenStorage tokenStorage) {
		AuthorizerManager.tokenStorage = tokenStorage;
	}

}
