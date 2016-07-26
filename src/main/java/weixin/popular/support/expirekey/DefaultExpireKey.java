package weixin.popular.support.expirekey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.support.ExpireKey;

public class DefaultExpireKey implements ExpireKey{
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultExpireKey.class);

	private Map<String,Integer> map = new HashMap<String,Integer>();

	private Integer period = 60;

	private ScheduledExecutorService scheduledExecutorService;

	public DefaultExpireKey(){
		cleanExpireKey();
	}

	/**
	 *
	 * @param period 清理key 间隔时间，默认60秒。
	 */
	public DefaultExpireKey(int period){
		this.period = period;
		cleanExpireKey();
	}

	private void cleanExpireKey(){
		if(scheduledExecutorService != null){
			scheduledExecutorService.shutdownNow();
		}
		//守护线程 自动清理过期key ，间隔时间60秒
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

			@Override
			public Thread newThread(Runnable arg0) {
				Thread thread = Executors.defaultThreadFactory().newThread(arg0);
				thread.setDaemon(true);
				return thread;
			}
		});

		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				logger.debug("in clean");
				List<String> removeKey = new ArrayList<String>();
				for(String key : map.keySet()){
					Integer value = map.get(key);
					if(value!=null&&value <= System.currentTimeMillis()/1000){
						removeKey.add(key);
					}
				}
				for(String key : removeKey){
					map.remove(key);
				}
				logger.debug("clean {} keys",removeKey.size());
			}
		},10,period,TimeUnit.SECONDS);
	}


	@Override
	public boolean add(String key, int expire) {
		map.put(key,(int)(System.currentTimeMillis()/1000)+expire);
		return false;
	}

	@Override
	public boolean add(String key) {
		return add(key,DEFAULT_EXPIRE);
	}

	@Override
	public boolean exists(String key) {
		Integer value = map.get(key);
		if(value == null){
			return false;
		}else{
			return value > System.currentTimeMillis()/1000;
		}
	}

}
