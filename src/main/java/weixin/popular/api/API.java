package weixin.popular.api;

/**
 * API 设置
 * 
 * 
 * 2.6.0
 * @author SLYH
 *
 */
public class API {

	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	private static Integer mode;
	
	public static final int MODE_POPULAR = 1;
	
	public static final int MODE_COMPONENT = 2;
	
	

	/**
	 * 设置默认的API模式
	 * 
	 * @param mode
	 *   1 公众号平台API,2 公众号第三方平台API
	 */
	public static void defaultMode(int mode) {
		API.mode = mode;
	}

	/**
	 * 设置API模式
	 * 
	 * @param mode 模式，可选值 1 or 2
	 */
	public static void mode(int mode) {
		threadLocal.set(mode);
	}

	/**
	 * 获取当前API模式
	 * @return 当前状态
	 */
	public static int currentMode() {
		if (mode == null && threadLocal.get() == null) {
			return MODE_POPULAR;
		} else if (threadLocal.get() != null) {
			return threadLocal.get();
		} else if (mode != null) {
			return mode;
		} else {
			return MODE_POPULAR;
		}
	}

}
