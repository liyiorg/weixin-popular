package weixin.popular.util;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 会值过期的Set
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class ExpireSet<K> extends HashSet<K>{

	/**
	 *
	 */
	private static final long serialVersionUID = 3883547126660410769L;

	{
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				KeyValue<K> kv = null;
				long currentTime = System.currentTimeMillis();
				while(true){
					kv = queue.peek();
					if(kv!=null && kv.value<currentTime){
						set.remove(kv.key);
						queue.poll();
					}else{
						break;
					}
				}

			}
		}, 1000*10, 1000*60);
	}

	private Queue<KeyValue<K>> queue = new ConcurrentLinkedQueue<ExpireSet<K>.KeyValue<K>>();

	private int period = 60;
	private Set<K> set = this;

	public ExpireSet(){}


	/**
	 *
	 * @param period 过期时间(秒)
	 */
	public ExpireSet(int period){
		this.period = period;
	}

	@Override
	public boolean add(K e) {
		queue.offer(new KeyValue<K>(e,System.currentTimeMillis()+1000*period));
		return super.add(e);
	}

	protected class KeyValue<KK>{
		 KK key;
		 long value;

		 public KeyValue(KK key,long value){
			 this.key = key;
			 this.value = value;
		 }
	}

}

