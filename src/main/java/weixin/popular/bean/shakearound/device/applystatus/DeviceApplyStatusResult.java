/**
 * 
 */
package weixin.popular.bean.shakearound.device.applystatus;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－设备管理－查询设备ID申请审核状态－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceApplyStatusResult extends BaseResult {

	/**
	 * 审核状态信息
	 */
	private DeviceApplyStatusResultData data;

	/**
	 * @return 审核状态信息
	 */
	public DeviceApplyStatusResultData getData() {
		return data;
	}

	/**
	 * @param data 审核状态信息
	 */
	public void setData(DeviceApplyStatusResultData data) {
		this.data = data;
	}
}
