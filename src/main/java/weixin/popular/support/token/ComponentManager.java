package weixin.popular.support.token;

import java.util.HashMap;


/**
 * 第三方平台授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public class ComponentManager extends ComponentTokenManager {

	private static ComponentTokenManager manager;

	private static TokenStorage tokenStorage = new DefaultComponentStorage(new HashMap<String, DefaultComponentStorage.RowData>());

	static {
		TokenContext context = new TokenContext();
		context.setRefreshInvoker(ComponentRefreshInvoker.getInstance());
		context.setTokenStorage(tokenStorage);
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
		return tokenStorage;
	}

	/**
	 * 指定token存储器对象
	 * 
	 * @param tokenStorage
	 */
	public static void setTokenStorage(TokenStorage tokenStorage) {
		ComponentManager.tokenStorage = tokenStorage;
	}
	
}
