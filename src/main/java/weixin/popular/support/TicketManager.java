package weixin.popular.support;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import weixin.popular.api.TicketAPI;
import weixin.popular.bean.ticket.Ticket;

/**
 * TicketManager ticket 自动刷新
 * @author LiYi
 *
 */
public class TicketManager {

	private static ScheduledExecutorService scheduledExecutorService;

	private static Map<String,String> ticketMap = new LinkedHashMap<String,String>();

	private static Map<String,ScheduledFuture<?>> futureMap = new HashMap<String, ScheduledFuture<?>>();

	private static int poolSize = 2;
	
	private static boolean daemon = Boolean.TRUE;

	/**
	 * 初始化 scheduledExecutorService
	 */
	private static void initScheduledExecutorService(){
		scheduledExecutorService =  Executors.newScheduledThreadPool(poolSize,new ThreadFactory() {

			@Override
			public Thread newThread(Runnable arg0) {
				Thread thread = Executors.defaultThreadFactory().newThread(arg0);
				//设置守护线程
				thread.setDaemon(daemon);
				return thread;
			}
		});
	}

	/**
	 * 设置线程池
	 * @param poolSize
	 */
	public static void setPoolSize(int poolSize){
		TicketManager.poolSize = poolSize;
	}

	/**
	 * 设置线程方式
	 * @param daemon
	 */
	public static void setDaemon(boolean daemon) {
		TicketManager.daemon = daemon;
	}
	
	/**
	 * 初始化ticket 刷新，每119分钟刷新一次。
	 * 依赖TokenManager
	 * @param appid
	 */
	public static void init(final String appid){
		if(scheduledExecutorService == null){
			initScheduledExecutorService();
		}
		if(futureMap.containsKey(appid)){
			return;
		}
		ScheduledFuture<?> scheduledFuture =  scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				String access_token = TokenManager.getToken(appid);
				Ticket ticket = TicketAPI.ticketGetticket(access_token);
				ticketMap.put(appid,ticket.getTicket());
			}
		},0,119,TimeUnit.MINUTES);
		futureMap.put(appid,scheduledFuture);
	}

	/**
	 * 取消 ticket 刷新
	 */
	public static void destroyed(){
		scheduledExecutorService.shutdownNow();
	}

	/**
	 * 获取 jsapi ticket
	 * @param appid
	 * @return
	 */
	public static String getTicket(final String appid){
		return ticketMap.get(appid);
	}

	/**
	 * 获取第一个appid 的  jsapi ticket
	 * 适用于单一微信号
	 * @param appid
	 * @return
	 */
	public static String getDefaultTicket(){
		Object[] objs = ticketMap.values().toArray();
		return objs.length>0?objs[0].toString():null;
	}

}
