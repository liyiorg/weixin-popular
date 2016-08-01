package weixin.popular.bean.card;

/**
 * 兑换券
 * 
 * @author Moyq5
 *
 */
public class Gift extends AbstractInfo {

	/**
	 * 填写兑换内容的名称。<br>
	 * 添加必填，不支持修改 
	 */
	private String gift;

	/**
	 * 兑换内容的名称。
	 */
	public String getGift() {
		return gift;
	}

	/**
	 * 填写兑换内容的名称。<br>
	 * 添加必填，不支持修改 
	 */
	public void setGift(String gift) {
		this.gift = gift;
	}

}
