package weixin.popular.bean.card.datacube;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取免费券数据接口－响应对象（每行记录对象）
 * 
 * @author Moyq5
 *
 */
public class FreeCardInfo extends BizuinInfo {

	/**
	 * 卡券ID
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * cardtype:0：折扣券，1：代金券，2：礼品券，3：优惠券，4：团购券<br>
	 * （暂不支持拉取特殊票券类型数据，电影票、飞机票、会议门票、景区门票）
	 */
	@JSONField(name = "card_type")
	private String cardType;
	
	/**
	 * 卡券ID
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}
	
	/**
	 * 卡券ID
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	/**
	 * cardtype:0：折扣券，1：代金券，2：礼品券，3：优惠券，4：团购券<br>
	 * （暂不支持拉取特殊票券类型数据，电影票、飞机票、会议门票、景区门票）
	 * @return
	 */
	public String getCardType() {
		return cardType;
	}
	
	/**
	 * cardtype:0：折扣券，1：代金券，2：礼品券，3：优惠券，4：团购券<br>
	 * （暂不支持拉取特殊票券类型数据，电影票、飞机票、会议门票、景区门票）
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
