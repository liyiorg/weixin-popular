package weixin.popular.bean.card.code.get;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－查询Code接口－响应参数－卡券信息
 * 
 * @author Moyq5
 *
 */
public class CodeGetResultCard {

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
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 起始使用时间
	 */
	public Integer getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime 起始使用时间
	 */
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return 结束时间
	 */
	public Integer getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime 结束时间
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
}
