/**
 * 
 */
package weixin.popular.bean.shakearound.device.update;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－编辑设备信息－请求参数－设备信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceUpdateDeviceIdentifier {

	/**
	 * 设备编号，若填了UUID、major、minor，则可不填设备编号，若二者都填，则以设备编号为优先<br>
	 * 必填
	 */
	@JSONField(name = "device_id")
	private Integer deviceId;
	
	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 */
	private String uuid;
	
	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 */
	private Integer major;
	
	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 */
	private Integer minor;

	/**
	 * 设备编号，若填了UUID、major、minor，则可不填设备编号，若二者都填，则以设备编号为优先<br>
	 * 必填
	 * @return 设备编号
	 */
	public Integer getDeviceId() {
		return deviceId;
	}

	/**
	 * 设备编号，若填了UUID、major、minor，则可不填设备编号，若二者都填，则以设备编号为优先<br>
	 * 必填
	 * @param deviceId 设备编号
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @return UUID
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @param uuid UUID
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @return major
	 */
	public Integer getMajor() {
		return major;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @param major major
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @return minor
	 */
	public Integer getMinor() {
		return minor;
	}

	/**
	 * UUID、major、minor，三个信息需填写完整，若填了设备编号，则可不填此信息。<br>
	 * 必填
	 * @param minor minor
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}
}
