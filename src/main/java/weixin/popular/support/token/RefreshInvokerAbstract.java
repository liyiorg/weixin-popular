package weixin.popular.support.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 授权令牌刷新任务执行者抽象类
 * @author Moyq5
 *
 */
public abstract class RefreshInvokerAbstract<T extends RefreshInfo, E extends TokenInfo> implements RefreshInvoker {
	
	private static final Logger logger = LoggerFactory.getLogger(RefreshInvokerAbstract.class);
	/**
	 * 刷新线程每30秒执行一次
	 */
	private static final int scheduleDelay = 30;
	/**
	 * 下一个acess_token到期时间，0马上到期
	 */
	private long nextTime = 0;
	
	public RefreshInvokerAbstract() {
		startExecutorService();
	}
	
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
		// 使线程进行检查刷新逻辑（最多延迟scheduleDelay秒）
		nextTime = 0;
	}
	
	private void startExecutorService() {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				//设置守护线程
				Thread thread = Executors.defaultThreadFactory().newThread(r);
				thread.setDaemon(true);
				return thread;
			}
		});
		
		service.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				long curTime = new Date().getTime();
				if (nextTime > curTime) {
					// 还没到刷新access_token时间，跳过处理逻辑
					logger.debug("access_token refresh skip");
					return;
				}
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
				
				curTime = new Date().getTime();
				if (curTime > nextTime) {
					// 默认10分检查access_token有效性一次
					nextTime = curTime + 600000; 
					
					Date date = new Date();
					date.setTime(nextTime);
					logger.debug("next access_token expiration check time： {}", 
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
				} else {
					
					Date date = new Date();
					date.setTime(nextTime);
					logger.debug("next access_token expiration time： {}", 
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
				}
				
			}
		}, 0, scheduleDelay, TimeUnit.SECONDS);
		
	}

}
