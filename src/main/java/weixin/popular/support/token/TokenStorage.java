package weixin.popular.support.token;


/**
 * 令牌信息提供者
 * @author Moyq5
 *
 */
public interface TokenStorage {
	
	/**
	 * 获取最快要过期的刷新令牌
	 * @return
	 */
	public RefreshInfo getOverdue();
	
	/**
	 * 获取接下来会有令牌过期的日期时间(毫秒)
	 * @return
	 */
	public long nextTime();
	
	/**
	 * 保存新的授权令牌
	 * @param tokenInfo
	 */
	public void update(TokenInfo tokenInfo);

	/**
	 * 根据应用appId和类型获取 access_token
	 * @param type
	 * @param componentAppId
	 * @param authorizerAppId
	 * @param openId
	 * @return
	 */
	public String getAccessToken(TokenType type, String componentAppId, String authorizerAppId, String openId);
	
}
