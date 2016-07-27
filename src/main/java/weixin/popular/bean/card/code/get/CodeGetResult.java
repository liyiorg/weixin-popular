package weixin.popular.bean.card.code.get;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－查询Code接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class CodeGetResult extends BaseResult {

	/**
	 * 卡券信息
	 */
	private CodeGetResultCard card;
	
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

	/**
	 * @return 卡券信息
	 */
	public CodeGetResultCard getCard() {
		return card;
	}

	/**
	 * @param card 卡券信息
	 */
	public void setCard(CodeGetResultCard card) {
		this.card = card;
	}

	/**
	 * @return 用户openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid 用户openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 是否可以核销，true为可以核销，false为不可核销
	 * @return 是否可以核销
	 */
	public Boolean getCanConsume() {
		return canConsume;
	}

	/**
	 * 是否可以核销，true为可以核销，false为不可核销
	 * @param canConsume 是否可以核销
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
	 * @return 卡券的状态
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
	 * @param userCardStatus 卡券的状态
	 */
	public void setUserCardStatus(String userCardStatus) {
		this.userCardStatus = userCardStatus;
	}
}
