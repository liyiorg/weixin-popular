package weixin.popular.bean.card.consume;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－查询Code接口－响应对象－卡信息
 * 
 * @author Moyq5
 *
 */
public class CodeGetCard {

	/**
	 * 卡券ID
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 起始使用时间
	 */
	@JSONField(name = "begin_time")
	private Integer beginTime;
	
	/**
	 * 结束时间
	 */
	@JSONField(name = "end_time")
	private Integer endTime;

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
	 * 起始使用时间
	 * @return
	 */
	public Integer getBeginTime() {
		return beginTime;
	}

	/**
	 * 起始使用时间
	 * @param beginTime
	 */
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 结束时间
	 * @return
	 */
	public Integer getEndTime() {
		return endTime;
	}

	/**
	 * 结束时间
	 * @param endTime
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
}
