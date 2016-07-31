/**
 * 
 */
package weixin.popular.bean.shakearound.device.update;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－编辑设备信息－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceUpdate {

	/**
	 * 指定的设备ID<br>
	 * 必填
	 */
	@JSONField(name = "device_identifier")
	private DeviceIdentifier deviceIdentifier;
	
	/**
	 * 设备的备注信息，不超过15个汉字或30个英文字母。<br>
	 * 必填
	 */
	private String comment;

	/**
	 * 指定的设备ID<br>
	 * 必填
	 * @return
	 */
	public DeviceIdentifier getDeviceIdentifier() {
		return deviceIdentifier;
	}

	/**
	 * 指定的设备ID<br>
	 * 必填
	 * @param deviceIdentifier 指定的设备ID
	 */
	public void setDeviceIdentifier(DeviceIdentifier deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	/**
	 * 设备的备注信息，不超过15个汉字或30个英文字母。<br>
	 * 必填
	 * @return 设备的备注信息
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 设备的备注信息，不超过15个汉字或30个英文字母。<br>
	 * 必填
	 * @param comment 设备的备注信息
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
