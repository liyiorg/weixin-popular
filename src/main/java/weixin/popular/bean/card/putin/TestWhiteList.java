package weixin.popular.bean.card.putin;

/**
 * 投放卡券－设置测试白名单－提求对象
 * 
 * @author Moyq5
 *
 */
public class TestWhiteList {

	/**
	 * 测试的openid列表
	 */
	private String[] openid;
	
	/**
	 * 测试的微信号列表
	 */
	private String[] username;

	/**
	 * 测试的openid列表
	 * @return
	 */
	public String[] getOpenid() {
		return openid;
	}

	/**
	 * 测试的openid列表<br>
	 * 必填：否
	 * @param openid
	 */
	public void setOpenid(String[] openid) {
		this.openid = openid;
	}

	/**
	 * 测试的微信号列表
	 * @return
	 */
	public String[] getUsername() {
		return username;
	}

	/**
	 * 测试的微信号列表<br>
	 * 必填：否
	 * @param username
	 */
	public void setUsername(String[] username) {
		this.username = username;
	}
}
