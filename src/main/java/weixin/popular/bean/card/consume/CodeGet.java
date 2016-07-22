package weixin.popular.bean.card.consume;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－查询Code接口－提交对象
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
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID代表一类卡券。自定义code卡券必填。
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 单张卡券的唯一标准。
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 单张卡券的唯一标准。<br>
	 * 必填：是
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
	 * @return
	 */
	public Boolean getCheckConsume() {
		return checkConsume;
	}

	/**
	 * 是否校验code核销状态，填入true和false时的code异常状态返回数据不同。<br>
	 * 必填：否
	 * @param checkConsume
	 */
	public void setCheckConsume(Boolean checkConsume) {
		this.checkConsume = checkConsume;
	}
}
