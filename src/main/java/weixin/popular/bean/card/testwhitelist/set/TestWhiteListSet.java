package weixin.popular.bean.card.testwhitelist.set;

/**
 * 投放卡券－设置测试白名单－请求参数
 * 
 * @author Moyq5
 *
 */
public class TestWhiteListSet {

	/**
	 * 测试的openid列表
	 */
	private String[] openid;
	
	/**
	 * 测试的微信号列表
	 */
	private String[] username;

	/**
	 * @return 测试的openid列表
	 */
	public String[] getOpenid() {
		return openid;
	}

	/**
	 * 测试的openid列表<br>
	 * 必填：否
	 * @param openid 测试的openid列表
	 */
	public void setOpenid(String[] openid) {
		this.openid = openid;
	}

	/**
	 * @return 测试的微信号列表
	 */
	public String[] getUsername() {
		return username;
	}

	/**
	 * 测试的微信号列表<br>
	 * 必填：否
	 * @param username 测试的微信号列表
	 */
	public void setUsername(String[] username) {
		this.username = username;
	}
}
