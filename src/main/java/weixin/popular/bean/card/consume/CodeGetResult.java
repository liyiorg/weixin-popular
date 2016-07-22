package weixin.popular.bean.card.consume;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－查询Code接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CodeGetResult extends BaseResult {

	private CodeGetCard card;
	
	/**
	 * 用户openid
	 */
	private String openid;
	
	/**
	 * 是否可以核销，true为可以核销，false为不可核销
	 */
	@JSONField(name = "can_consume")
	private Boolean canConsume;
	
	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 */
	@JSONField(name = "user_card_status")
	private String userCardStatus;

	public CodeGetCard getCard() {
		return card;
	}

	public void setCard(CodeGetCard card) {
		this.card = card;
	}

	/**
	 * 用户openid
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 用户openid
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 是否可以核销，true为可以核销，false为不可核销
	 * @return
	 */
	public Boolean getCanConsume() {
		return canConsume;
	}

	/**
	 * 是否可以核销，true为可以核销，false为不可核销
	 * @param canConsume
	 */
	public void setCanConsume(Boolean canConsume) {
		this.canConsume = canConsume;
	}

	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 * @return
	 */
	public String getUserCardStatus() {
		return userCardStatus;
	}

	/**
	 * 当前code对应卡券的状态: <br>
	 * NORMAL 正常 <br>
	 * CONSUMED 已核销 <br>
	 * EXPIRE 已过期 <br>
	 * GIFTING 转赠中<br>
	 * GIFT_TIMEOUT 转赠超时<br>
	 * DELETE 已删除<br>
	 * UNAVAILABLE 已失效 <br>
	 * code未被添加或被转赠领取的情况则统一报错：invalid serial code
	 * @param userCardStatus
	 */
	public void setUserCardStatus(String userCardStatus) {
		this.userCardStatus = userCardStatus;
	}
}
