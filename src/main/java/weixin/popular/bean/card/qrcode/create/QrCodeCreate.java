package weixin.popular.bean.card.qrcode.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券投放－创建领取单个卡券二维码信息接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class QrCodeCreate {

	@JSONField(name = "action_name")
	private String actionName = "QR_CARD";

	/**
	 * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 */
	@JSONField(name = "expire_seconds")
	private Integer expireSeconds;
	
	@JSONField(name = "action_info")
	private ActionInfo actionInfo;

	/**
	 * 卡券领取类型：QR_CARD
	 * @return 卡券领取类型
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 不必填，已经默认为QR_CARD
	 * @param actionName 卡券领取类型
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * 二维码的有效时间，范围是60 ~ 1800秒。
	 * 
	 * @return 二维码的有效时间
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 * 
	 * @param expireSeconds 二维码的有效时间
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
}
