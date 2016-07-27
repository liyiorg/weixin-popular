package weixin.popular.bean.card.code.consume;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－核销Code接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class CodeConsumeResult extends BaseResult {

	private CodeConsumeResultCard card;

	/**
	 * 用户在该公众号内的唯一身份标识。
	 */
	private String openid;

	public CodeConsumeResultCard getCard() {
		return card;
	}

	public void setCard(CodeConsumeResultCard card) {
		this.card = card;
	}

	/**
	 * @return 用户在该公众号内的唯一身份标识
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid 用户在该公众号内的唯一身份标识
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
