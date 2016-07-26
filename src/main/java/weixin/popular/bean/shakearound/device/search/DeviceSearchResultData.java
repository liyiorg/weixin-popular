/**
 * 
 */
package weixin.popular.bean.shakearound.device.search;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 微信摇一摇周边－设备管理－查询设备列表－响应参数－设备信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceSearchResultData {

	/**
	 * 设备列表
	 */
	private List<DeviceSearchResultDataDevice> devices;
	
	/**
	 * 商户名下的设备总量
	 */
	@JSONField(name = "total_count")
	private Integer totalCount;

	/**
	 * @return 设备列表
	 */
	public List<DeviceSearchResultDataDevice> getDevices() {
		return devices;
	}

	/**
	 * @param devices 设备列表
	 */
	public void setDevices(List<DeviceSearchResultDataDevice> devices) {
		this.devices = devices;
	}

	/**
	 * @return 商户名下的设备总量
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 商户名下的设备总量
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
