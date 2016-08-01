package weixin.popular.bean.card;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class Discount extends AbstractInfo {

	/**
	 * 表示打折额度（百分比）。填30就是七折。<br>
	 * 添加必填，不支持修改 
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
	 * 添加必填，不支持修改 
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
