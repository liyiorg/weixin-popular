package weixin.popular.bean.card.landingpage.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券发放－创建货架接口－请求参数－货架投放的卡券
 * 
 * @author Moyq5
 *
 */
public class LandingPageCreateCard {

	/**
	 * 所要在页面投放的card_id<br>
	 * 必填：是
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 缩略图url<br>
	 * 必填：是
	 */
	@JSONField(name = "thumb_url")
	private String thumbUrl;

	/**
	 * 所要在页面投放的card_id
	 * 
	 * @return 投放的card_id
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 所要在页面投放的card_id<br>
	 * 必填：是
	 * 
	 * @param cardId 投放的card_id
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 缩略图url
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}
	
	/**
	 * 缩略图url<br>
	 * 必填：是
	 * @param thumbUrl 缩略图url
	 */
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
}
