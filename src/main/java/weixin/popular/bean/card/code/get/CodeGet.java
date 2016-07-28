package weixin.popular.bean.card.code.get;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－查询Code接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class CodeGet {
	
	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 单张卡券的唯一标准。<br>
	 * 必填：是
	 */
	private String code;
	
	/**
	 * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。<br>
	 * 必填：否
	 */
	@JSONField(name = "check_consume")
	private Boolean checkConsume;

	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 单张卡券的唯一标准
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 单张卡券的唯一标准。<br>
	 * 必填：是
	 * @param code 单张卡券的唯一标准
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
	 * @return 是否校验code核销状态
	 */
	public Boolean getCheckConsume() {
		return checkConsume;
	}

	/**
	 * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。<br>
	 * 必填：否
	 * @param checkConsume 是否校验code核销状态
	 */
	public void setCheckConsume(Boolean checkConsume) {
		this.checkConsume = checkConsume;
	}
}
