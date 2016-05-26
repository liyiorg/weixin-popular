package weixin.popular.support.token;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 授权令牌刷新任务调度抽象类
 * 
 * @author Moyq5
 *
 */
public abstract class RefreshSchedulerAbstract<T extends RefreshInfo, E extends TokenInfo>
		implements RefreshScheduler {

	/**
	 * 刷新线程默认每1分钟执行一次
	 */
	private int scheduleDelay = 60;

	private ScheduledExecutorService service;

	public RefreshSchedulerAbstract() {
		create();
		startup();
	}

	/**
	 * 刷新授权令牌
	 * 
	 * @param refreshInfo
	 *            刷新令牌
	 * @return 新的授权令牌
	 */
	protected abstract E execute(T refreshInfo);

	/**
	 * 获取token源信息提供者
	 * 
	 * @return
	 */
	protected abstract TokenStorage getTokenStorage();

	@Override
	public void execute() {
		restart();
	}

	/**
	 * 创建守护线程
	 */
	private void create() {
		service = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						// 设置守护线程
						Thread thread = Executors.defaultThreadFactory().newThread(r);
						thread.setDaemon(true);
						return thread;
					}
				});

	}
	
	private void restart() {
		shutdown();
		startup();
	}

	private void startup() {
		service.scheduleWithFixedDelay(new RefreshRunnable<T, E>(this), 0,
				scheduleDelay, TimeUnit.SECONDS);
	}

	private void shutdown() {
		service.shutdown();
	}


	/**
	 * 获取当前刷新线程启动频繁（单位：秒）
	 * 
	 * @return
	 */
	public int getScheduleDelay() {
		return scheduleDelay;
	}

	/**
	 * 指定刷新线程启动频繁（单位：秒）， 注意：启动频繁并不是指查检token信息的频繁， 真正是否执行token检查还跟线程上次执行结果有关，
	 * 它仅相当于线程上次执行完成后，多长时间再次启动(Thread类的start方法))
	 * 
	 * @param scheduleDelay
	 *            刷新线程启动频繁（单位：秒）
	 */
	public void setScheduleDelay(int scheduleDelay) {
		this.scheduleDelay = scheduleDelay;
	}

}
