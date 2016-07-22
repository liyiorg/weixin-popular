package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 管理卡券－获取用户已领取卡券接口－提交对象
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
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。不填写时默认查询当前appid下的卡券。<br>
	 * 必填：否
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 需要查询的用户openid
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 需要查询的用户openid<br>
	 * 必填：是
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
