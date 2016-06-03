package weixin.popular.bean.card;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class Discount extends CardInfo {

	/**
	 * 表示打折额度（百分比）。填30就是七折。<br>
	 * 必填：是
	 */
	private Integer discount;

	/**
	 * 表示打折额度（百分比）。填30就是七折。
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * 表示打折额度（百分比）。填30就是七折。<br>
	 * 必填：是
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
