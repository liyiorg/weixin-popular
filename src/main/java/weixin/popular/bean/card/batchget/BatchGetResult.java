package weixin.popular.bean.card.batchget;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券管理－批量查询卡券列表－响应参数
 * 
 * @author Moyq5
 *
 */
public class BatchGetResult extends BaseResult {

	/**
	 * 卡券ID列表。
	 */
	@JSONField(name = "card_id_list")
	private String[] cardIdList;

	/**
	 * 该商户名下卡券ID总数。
	 */
	@JSONField(name = "total_num")
	private Integer totalNum;

	/**
	 * @return 卡券ID列表
	 */
	public String[] getCardIdList() {
		return cardIdList;
	}

	/**
	 * @param cardIdList 卡券ID列表
	 */
	public void setCardIdList(String[] cardIdList) {
		this.cardIdList = cardIdList;
	}

	/**
	 * @return 该商户名下卡券ID总数
	 */
	public Integer getTotalNum() {
		return totalNum;
	}

	/**
	 * @param totalNum 该商户名下卡券ID总数
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
}
