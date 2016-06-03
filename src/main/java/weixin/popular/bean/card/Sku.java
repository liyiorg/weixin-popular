package weixin.popular.bean.card;

/**
 * 商品信息
 * 
 * @author Moyq5
 *
 */
public class Sku {

	/**
	 * 卡券库存的数量，上限为100000000。<br>
	 * 必填：是
	 */
	private Integer quantity;

	/**
	 * 卡券库存的数量，上限为100000000。
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 卡券库存的数量，上限为100000000。<br>
	 * 必填：是
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
