package weixin.popular.support.token;


/**
 * 第三方平台授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public class ComponentManager extends ComponentTokenManager {

	private static ComponentTokenManager manager;

	static {
		TokenContext context = new TokenContext();
		context.setRefreshScheduler(ComponentRefreshScheduler.getInstance());
		context.setTokenStorage(new DefaultComponentStorage());
		context.setType(TokenType.COMPONENT);
		manager = new ComponentManager(context);
	}

	private ComponentManager(TokenContext context) {
		super(context);
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public synchronized static ComponentTokenManager getInstance() {
		return manager;
	}

	/**
	 * 获取token存储器对象
	 * 
	 * @return
	 */
	public static TokenStorage getTokenStorage() {
		return manager.context.getTokenStorage();
	}

	/**
	 * 指定token存储器对象
	 * 
	 * @param tokenStorage
	 */
	public static void setTokenStorage(TokenStorage tokenStorage) {
		manager.context.setTokenStorage(tokenStorage);
	}
	
}
