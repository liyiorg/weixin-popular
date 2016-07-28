package weixin.popular.bean.card.user.getcardlist;

import java.util.List;

import weixin.popular.bean.BaseResult;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 管理卡券－获取用户已领取卡券接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class UserGetCardListResult extends BaseResult {

	/**
	 * 已领取的卡券列表
	 */
	@JSONField(name = "card_list")
	private List<UserGetCardListResultCard> cardList;
	
	/**
	 * 是否有可用的朋友的券
	 */
	@JSONField(name = "has_share_card")
	private Boolean hasShareCard;

	/**
	 * @return 已领取的卡券列表
	 */
	public List<UserGetCardListResultCard> getCardList() {
		return cardList;
	}

	/**
	 * @param cardList 已领取的卡券列表
	 */
	public void setCardList(List<UserGetCardListResultCard> cardList) {
		this.cardList = cardList;
	}

	/**
	 * @return 是否有可用的朋友的券
	 */
	public Boolean getHasShareCard() {
		return hasShareCard;
	}

	/**
	 * @param hasShareCard 是否有可用的朋友的券
	 */
	public void setHasShareCard(Boolean hasShareCard) {
		this.hasShareCard = hasShareCard;
	}
}
