package weixin.popular.bean.card.consume;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－核销Code接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CodeDecryptResult extends BaseResult {

	private CodeConsumeCard card;

	/**
	 * 用户在该公众号内的唯一身份标识。
	 */
	private String openid;

	public CodeConsumeCard getCard() {
		return card;
	}

	public void setCard(CodeConsumeCard card) {
		this.card = card;
	}

	/**
	 * 用户在该公众号内的唯一身份标识。
	 * 
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 用户在该公众号内的唯一身份标识。
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
