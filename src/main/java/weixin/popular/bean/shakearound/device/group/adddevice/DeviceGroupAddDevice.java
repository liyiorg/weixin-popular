/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.adddevice;

import java.util.List;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－添加设备到分组－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupAddDevice {

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 必填
	 */
	@JSONField(name = "group_id")
	private Integer groupId;
	
	/**
	 * 设备id列表<br>
	 * 必填
	 */
	@JSONField(name = "device_identifiers")
	private List<DeviceIdentifier>  deviceIdentifiers;

	/**
	 * @return 分组唯一标识
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 必填
	 * @param groupId 分组唯一标识
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return 设备id列表
	 */
	public List<DeviceIdentifier> getDeviceIdentifiers() {
		return deviceIdentifiers;
	}

	/**
	 * 设备id列表<br>
	 * 必填
	 * @param deviceIdentifiers 设备id列表
	 */
	public void setDeviceIdentifiers(List<DeviceIdentifier> deviceIdentifiers) {
		this.deviceIdentifiers = deviceIdentifiers;
	}
}
