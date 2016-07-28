package weixin.popular.bean.card.qrcode.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class ActionInfoCard {

	/**
	 * 卡券ID。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
	 */
	private String code;
	
	/**
	 * 指定领取者的openid，只有该用户能领取。<br>
	 * bind_openid字段为true的卡券必须填写，非指定openid不必填写。
	 */
	private String openid;
	
	/**
	 * 指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。<br>
	 * 默认false，注意填写该字段时，卡券须通过审核且库存不为0。
	 */
	@JSONField(name = "is_unique_code")
	private Boolean isUniqueCode;
	
	/**
	 * 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。<br>
	 * 用户领取卡券后触发的事件推送中会带上此自定义场景值。
	 */
	@JSONField(name = "outer_id")
	private Integer outerId;
	
	/**
	 * 支持开发者自定义字符串，该字符串会带入当次扫码打开的会员卡界面，传入快速买单的链接中。<br>
	 * 通常用于特定客桌的消费标记，用于对账。
	 */
	@JSONField(name = "outer_str")
	private String outerStr;

	/**
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 卡券Code码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
	 * @param code 卡券Code码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return 领取者的openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 指定领取者的openid，只有该用户能领取。<br>
	 * bind_openid字段为true的卡券必须填写，非指定openid不必填写。
	 * @param openid 领取者的openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。<br>
	 * 默认false，注意填写该字段时，卡券须通过审核且库存不为0。
	 * @return 是否只能领取一次
	 */
	public Boolean getIsUniqueCode() {
		return isUniqueCode;
	}

	/**
	 * 指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。<br>
	 * 默认false，注意填写该字段时，卡券须通过审核且库存不为0。
	 * @param isUniqueCode 是否只能领取一次
	 */
	public void setIsUniqueCode(Boolean isUniqueCode) {
		this.isUniqueCode = isUniqueCode;
	}

	/**
	 * 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。<br>
	 * 用户领取卡券后触发的事件推送中会带上此自定义场景值。
	 * @return 领取场景值
	 */
	public Integer getOuterId() {
		return outerId;
	}

	/**
	 * 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。<br>
	 * 用户领取卡券后触发的事件推送中会带上此自定义场景值。
	 * @param outerId 领取场景值
	 */
	public void setOuterId(Integer outerId) {
		this.outerId = outerId;
	}

	/**
	 * 支持开发者自定义字符串，该字符串会带入当次扫码打开的会员卡界面，传入快速买单的链接中。<br>
	 * 通常用于特定客桌的消费标记，用于对账。
	 * @return 开发者自定义字符串
	 */
	public String getOuterStr() {
		return outerStr;
	}

	/**
	 * 支持开发者自定义字符串，该字符串会带入当次扫码打开的会员卡界面，传入快速买单的链接中。<br>
	 * 通常用于特定客桌的消费标记，用于对账。
	 * @param outerStr 开发者自定义字符串
	 */
	public void setOuterStr(String outerStr) {
		this.outerStr = outerStr;
	}
}
