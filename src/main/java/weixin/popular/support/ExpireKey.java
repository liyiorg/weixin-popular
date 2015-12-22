package weixin.popular.support;

/**
 * key 过期
 * @author SLYH
 *
 */
public interface ExpireKey {

	//12 s
	public static final Integer DEFAULT_EXPIRE = 12;

	/**
	 * 添加key
	 * @param key
	 * @param expire 有效时间（秒）
	 * @return
	 */
	public boolean add(String key,int expire);

	/**
	 * 添加key
	 * @param key
	 * @return
	 */
	public boolean add(String key);

	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(String key);

}
