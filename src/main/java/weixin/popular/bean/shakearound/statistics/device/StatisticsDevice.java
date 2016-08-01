/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.device;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;
import weixin.popular.bean.shakearound.statistics.AbstractStatistics;

/**
 * 微信摇一摇周边－以设备为维度的数据统计接口－请求参数
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsDevice extends AbstractStatistics {

	/**
	 * 指定页面的设备ID<br>
	 * 必填
	 */
	@JSONField(name = "device_identifier")
	private DeviceIdentifier deviceIdentifier;
	
	/**
	 * @return 页面的设备ID
	 */
	public DeviceIdentifier getDeviceIdentifier() {
		return deviceIdentifier;
	}

	/**
	 * 指定页面的设备ID<br>
	 * 必填
	 * @param deviceIdentifier 页面的设备ID
	 */
	public void setDeviceIdentifier(DeviceIdentifier deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

}
