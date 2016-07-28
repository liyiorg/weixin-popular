package weixin.popular.bean.card.qrcode.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券投放－创建领取多张卡券二维码信息接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class QrCodeCreateMultiple {

	@JSONField(name = "action_name")
	private String actionName = "QR_MULTIPLE_CARD";
	
	@JSONField(name = "action_info")
	private ActionInfoMultiple actionInfo;

	/**
	 * QR_MULTIPLE_CARD
	 * @return  卡券领取类型
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 不必填写，已经默认为QR_MULTIPLE_CARD
	 * @param actionName 卡券领取类型
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActionInfoMultiple getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfoMultiple actionInfo) {
		this.actionInfo = actionInfo;
	}
}
