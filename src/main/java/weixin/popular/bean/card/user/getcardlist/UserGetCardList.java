package weixin.popular.bean.card.user.getcardlist;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 管理卡券－获取用户已领取卡券接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class UserGetCardList {

	/**
	 * 卡券ID。不填写时默认查询当前appid下的卡券。<br>
	 * 必填：否
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 需要查询的用户openid<br>
	 * 必填：是
	 */
	private String openid;

	/**
	 * 卡券ID。不填写时默认查询当前appid下的卡券。
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。不填写时默认查询当前appid下的卡券。<br>
	 * 必填：否
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 需要查询的用户openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 需要查询的用户openid<br>
	 * 必填：是
	 * @param openid 需要查询的用户openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
