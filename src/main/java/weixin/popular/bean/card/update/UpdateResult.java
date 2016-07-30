/**
 * 
 */
package weixin.popular.bean.card.update;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 微信卡券－卡券管理－更改卡券信息接口－响应参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class UpdateResult extends BaseResult {

	/**
	 * 是否提交审核，false为修改后不会重新提审，true为修改字段后重新提审，该卡券的状态变为审核中。
	 */
	@JSONField(name = "send_check")
	private Boolean sendCheck;

	/**
	 * 是否提交审核，false为修改后不会重新提审，true为修改字段后重新提审，该卡券的状态变为审核中。
	 * @return 是否提交审核
	 */
	public Boolean getSendCheck() {
		return sendCheck;
	}

	/**
	 * @param sendCheck 是否提交审核
	 */
	public void setSendCheck(Boolean sendCheck) {
		this.sendCheck = sendCheck;
	}
}
