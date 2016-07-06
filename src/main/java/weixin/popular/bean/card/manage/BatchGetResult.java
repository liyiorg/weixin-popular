package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券管理－批量查询卡券列表－相应对象
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
	 * 卡券ID列表。
	 * 
	 * @return
	 */
	public String[] getCardIdList() {
		return cardIdList;
	}

	/**
	 * 卡券ID列表。
	 * 
	 * @param cardIdList
	 */
	public void setCardIdList(String[] cardIdList) {
		this.cardIdList = cardIdList;
	}

	/**
	 * 该商户名下卡券ID总数。
	 * 
	 * @return
	 */
	public Integer getTotalNum() {
		return totalNum;
	}

	/**
	 * 该商户名下卡券ID总数。
	 * 
	 * @param totalNum
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
}
