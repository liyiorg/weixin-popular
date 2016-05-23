package weixin.popular.support.token;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 授权令牌刷新任务执行者抽象类
 * @author Moyq5
 *
 */
public abstract class RefreshInvokerAbstract<T extends RefreshInfo, E extends TokenInfo> implements RefreshInvoker, Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(RefreshInvokerAbstract.class);
	
	/**
	 * 刷新线程
	 */
	private Thread thread;
	/**
	 * 刷新线程的活动状态
	 */
	private boolean doing = false;
	
	/**
	 * 刷新授权令牌
	 * @param refreshInfo 刷新令牌
	 * @return 新的授权令牌
	 */
	protected abstract E execute(T refreshInfo);
	
	/**
	 * 获取token源信息提供者
	 * @return
	 */
	protected abstract TokenStorage getTokenStorage();
	
	@Override
	public void startRefresh() {
		if (doing) {
			return;			
		}
		if (null == thread || !thread.isAlive()) {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
		} else {
			thread.interrupt();
		}
		
	}
	
	@Override
	public void run() {
		try {
			doing = true;
			TokenStorage tokenStorage = getTokenStorage();
			@SuppressWarnings("unchecked")
			T t = (T) tokenStorage.getOverdue();
			E e = (E) execute(t);
			tokenStorage.update(e);
			long curTime = new Date().getTime();
			long nextTime = tokenStorage.nextTime();
			if (curTime > nextTime) {
				nextTime = curTime + 10000; //6600000;// 默认1小时50分刷新一次，比微信令牌默认有效时间小10分钟
			}
			doing = false;
			try {
				Thread.sleep(nextTime - curTime);
			} catch (InterruptedException ie) {
				logger.debug("access_token refresh interrupted:");
			}
			run();
		} catch (Exception e) {
			logger.error("access_token refresh error:", e);
			doing = false;
		}
		
	}

}
