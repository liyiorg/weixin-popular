package weixin.popular.support.token;

/**
 * 授权令牌刷新任务调度类
 * 
 * @author Moyq5
 *
 */
public interface RefreshScheduler {

	/**
	 * 执行新刷任务
	 */
	public void execute();
}
