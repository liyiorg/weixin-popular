package weixin.popular.support.token;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * token刷新线程类
 * 
 * @author Moyq5
 *
 * @param <T> 刷新时需要的信息类
 * @param <E> 更新时得到的信息类
 */
public class RefreshRunnable<T extends RefreshInfo, E extends TokenInfo> implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(RefreshRunnable.class);

	/**
	 * 下一个acess_token到期时间，0马上到期
	 */
	private long nextTime = 0;

	/**
	 * 任务调度管理类
	 */
	private RefreshSchedulerAbstract<T, E> invoker;

	public RefreshRunnable(RefreshSchedulerAbstract<T, E> invoker) {
		this.invoker = invoker;
	}

	@Override
	public void run() {
		long curTime = new Date().getTime();
		if (nextTime > curTime) {
			// 还没到刷新access_token时间，跳过处理逻辑
			logger.debug("access_token refresh skip");
			return;
		}
		try {
			TokenStorage tokenStorage = invoker.getTokenStorage();
			@SuppressWarnings("unchecked")
			T t = (T) tokenStorage.getOverdue();
			if (null != t) {
				E e = (E) invoker.execute(t);
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
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		} else {

			Date date = new Date();
			date.setTime(nextTime);
			logger.debug("next access_token expiration time： {}",
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		}
	}

}
