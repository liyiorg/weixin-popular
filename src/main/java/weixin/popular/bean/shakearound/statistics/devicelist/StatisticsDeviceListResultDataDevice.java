/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.devicelist;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.statistics.AbstractStatisticsResultData;

/**
 * 微信摇一摇周边－批量查询设备统计数据接口－响应参数－统计结果数据－设备统计数据
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsDeviceListResultDataDevice extends AbstractStatisticsResultData {

	/**
	 * 设备编号
	 */
	@JSONField(name = "device_id")
	private Integer deviceId;
	
	private Integer major;
	
	private Integer minor;
	
	private String uuid;
	
	/**
	 * @return 设备编号
	 */
	public Integer getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId 设备编号
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return 设备major
	 */
	public Integer getMajor() {
		return major;
	}
	/**
	 * @param major 设备major
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}
	/**
	 * @return 设备minor
	 */
	public Integer getMinor() {
		return minor;
	}
	/**
	 * @param minor 设备minor
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}
	/**
	 * @return 设备uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid 设备uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
