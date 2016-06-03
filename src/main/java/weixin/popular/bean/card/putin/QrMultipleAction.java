package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券投放－创建领取多张卡券二维码信息接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class QrMultipleAction {

	@JSONField(name = "action_name")
	private String actionName = "QR_MULTIPLE_CARD";
	
	@JSONField(name = "action_info")
	private QrMultipleActionInfo actionInfo;

	/**
	 * QR_MULTIPLE_CARD
	 * @return
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * 不必填写，已经默认为QR_MULTIPLE_CARD
	 * @param actionName
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public QrMultipleActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(QrMultipleActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
}
