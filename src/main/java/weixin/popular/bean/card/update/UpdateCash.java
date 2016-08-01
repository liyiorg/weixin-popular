/**
 * 
 */
package weixin.popular.bean.card.update;

import weixin.popular.bean.card.Cash;

/**
 * 微信卡券－卡券管理－更改卡券信息接口（代金券）－请求参数 
 * @author Moyq5
 * @date 2016年7月30日
 */
public class UpdateCash extends AbstractUpdate {
	
	/**
	 * 代金券
	 */
	private Cash cash;

	/**
	 * @return 代金券
	 */
	public Cash getCash() {
		return cash;
	}

	/**
	 * @param cash 代金券
	 */
	public void setCash(Cash cash) {
		this.cash = cash;
	}
}
