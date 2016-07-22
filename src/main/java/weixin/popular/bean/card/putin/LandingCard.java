package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 货架投放的卡券列表
 * 
 * @author Moyq5
 *
 */
public class LandingCard {

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
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 所要在页面投放的card_id<br>
	 * 必填：是
	 * 
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 缩略图url
	 * @return
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}
	
	/**
	 * 缩略图url<br>
	 * 必填：是
	 * @param thumbUrl
	 */
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
}
