/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.getdetail;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.device.group.GroupInfo;

/**
 * 微信摇一摇周边－查询分组详情－响应参数－分组详情
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupGetDetailResultData extends GroupInfo {

	/**
	 * 此分组现有的总设备数
	 */
	@JSONField(name = "total_count")
	private Integer totalCount;
	
	/**
	 * 分组下的设备列表
	 */
	private List<DeviceGroupGetDetailResultDataDevice> devices;

	/**
	 * @return 此分组现有的总设备数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 此分组现有的总设备数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return 分组下的设备列表
	 */
	public List<DeviceGroupGetDetailResultDataDevice> getDevices() {
		return devices;
	}

	/**
	 * @param devices 分组下的设备列表
	 */
	public void setDevices(List<DeviceGroupGetDetailResultDataDevice> devices) {
		this.devices = devices;
	}

}
