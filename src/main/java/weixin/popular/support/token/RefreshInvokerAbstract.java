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
		long nextTime = 0;
		doing = true;
		try {
			TokenStorage tokenStorage = getTokenStorage();
			@SuppressWarnings("unchecked")
			T t = (T) tokenStorage.getOverdue();
			if (null != t) {
				E e = (E) execute(t);
				tokenStorage.update(e);
			}
			nextTime = tokenStorage.nextTime();
		} catch (Exception e) {
			logger.error("access_token refresh error:", e);
		}
		doing = false;
		long curTime = new Date().getTime();
		if (curTime > nextTime) {
			// 默认10分刷新一次，保证刷新线程持续正常进行
			nextTime = curTime + 600000; 
		}
		logger.debug("thread{}: curTime={}, nextTime={}, delay={}", 
				new Object[]{thread.getId(), curTime, nextTime, nextTime - curTime});
		try {
			Thread.sleep(nextTime - curTime);
		} catch (InterruptedException ie) {
			logger.debug("access_token refresh interrupted:");
		}
		run();
		
	}

}
