package weixin.popular.support.token;


/**
 * 公众号授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public class AuthorizerManager extends AuthorizerManagerAbstract {

	private static AuthorizerManagerAbstract manager;

	static {
		TokenContext context = new TokenContext();
		context.setRefreshScheduler(AuthorizerRefreshScheduler.getInstance());
		context.setTokenStorage(new DefaultAuthorizerStorage());
		context.setType(TokenType.AUTHORIZER);
		context.setRefreshMsgHandler(new RefreshMsgHandler());
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
	public static AuthorizerManagerAbstract getInstance() {
		return manager;
	}

}
