package weixin.popular.bean.shakearound.device.applyid;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－设备管理－申请设备ID－响应参数
 * @author Moyq5
 * @date 2016年7月25日
 */
public class DeviceApplyIdResult extends BaseResult {

	/**
	 * 申请状态信息
	 */
	private DeviceApplyIdResultData data;

	/**
	 * @return 申请状态信息
	 */
	public DeviceApplyIdResultData getData() {
		return data;
	}

	/**
	 * @param data 申请状态信息
	 */
	public void setData(DeviceApplyIdResultData data) {
		this.data = data;
	}
}
