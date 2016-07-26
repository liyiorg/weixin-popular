/**
 * 
 */
package weixin.popular.bean.shakearound.device.search;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－设备管理－查询设备列表－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceSearchResult extends BaseResult {

	/**
	 * 设备信息
	 */
	private DeviceSearchResultData data;

	/**
	 * @return 设备信息
	 */
	public DeviceSearchResultData getData() {
		return data;
	}

	/**
	 * @param data 设备信息
	 */
	public void setData(DeviceSearchResultData data) {
		this.data = data;
	}
}
