package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券管理－修改库存接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class ModifyStock {

	/**
	 * 卡券ID。<br>
	 * 必填：是
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 增加多少库存，支持不填或填0。
	 */
	@JSONField(name = "increase_stock_value")
	private Integer increaseStockValue;
	
	/**
	 * 减少多少库存，可以不填或填0。
	 */
	@JSONField(name = "reduce_stock_value")
	private Integer reduceStockValue;
	
	/**
	 * 卡券ID。
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}
	
	/**
	 * 卡券ID。<br>
	 * 必填：是
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	/**
	 * 增加多少库存，支持不填或填0。
	 * @return
	 */
	public Integer getIncreaseStockValue() {
		return increaseStockValue;
	}
	
	/**
	 * 增加多少库存，支持不填或填0。
	 * @param increaseStockValue
	 */
	public void setIncreaseStockValue(Integer increaseStockValue) {
		this.increaseStockValue = increaseStockValue;
	}
	
	/**
	 * 减少多少库存，可以不填或填0。
	 * @return
	 */
	public Integer getReduceStockValue() {
		return reduceStockValue;
	}
	
	/**
	 * 减少多少库存，可以不填或填0。
	 * @param reduceStockValue
	 */
	public void setReduceStockValue(Integer reduceStockValue) {
		this.reduceStockValue = reduceStockValue;
	}
}
