package weixin.popular.support.token;

/**
 * 授权令牌刷新任务执行者
 * @author Moyq5
 *
 */
public interface RefreshInvoker {
	
	/**
	 * 开始执行新刷任务
	 */
	public void startRefresh();
}
