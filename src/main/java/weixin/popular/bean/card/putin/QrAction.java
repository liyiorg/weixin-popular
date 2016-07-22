package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券投放－创建领取单个卡券二维码信息接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class QrAction {

	@JSONField(name = "action_name")
	private String actionName = "QR_CARD";

	/**
	 * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 */
	@JSONField(name = "expire_seconds")
	private Integer expireSeconds;
	
	@JSONField(name = "action_info")
	private QrActionInfo actionInfo;

	/**
	 * QR_CARD
	 * @return
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 不必填，已经默认为QR_CARD
	 * @param actionName
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * 二维码的有效时间，范围是60 ~ 1800秒。
	 * 
	 * @return
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 * 
	 * @param expireSeconds
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public QrActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(QrActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
}
