package weixin.popular.support.token;


/**
 * 第三方平台授权令牌管理类
 * 
 * @author Moyq5
 *
 */
public class ComponentManager extends ComponentManagerAbstract {

	private static ComponentManagerAbstract manager;

	static {
		TokenContext context = new TokenContext();
		context.setRefreshScheduler(ComponentRefreshScheduler.getInstance());
		context.setTokenStorage(new DefaultComponentStorage());
		context.setType(TokenType.COMPONENT);
		context.setRefreshMsgHandler(new RefreshMsgHandler());
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
	public synchronized static ComponentManagerAbstract getInstance() {
		return manager;
	}

}
