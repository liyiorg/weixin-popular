/**
 * 
 */
package weixin.popular.bean.qrcode.create;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 生成带参数二维码－请求参数
 * @author Moyq5
 * @date 2016年8月26日
 */
public class Create {

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 */
	@JsonProperty("expire_seconds")
	private Integer expireSeconds;
	
	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	@JsonProperty("action_name")
	private String actionName;
	
	/**
	 * 二维码详细信息
	 */
	@JsonProperty("action_info")
	private ActionInfo actionInfo;

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	 * @return 二维码有效时间
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param expireSeconds 二维码有效时间
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 * @return 二维码类型
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 * @param actionName 二维码类型
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return 二维码详细信息
	 */
	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	/**
	 * @param actionInfo 二维码详细信息
	 */
	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
}
