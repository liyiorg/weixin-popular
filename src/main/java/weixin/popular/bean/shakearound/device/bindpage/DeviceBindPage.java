/**
 * 
 */
package weixin.popular.bean.shakearound.device.bindpage;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－配置设备与页面的关联关系－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceBindPage {

	/**
	 * 指定页面的设备ID<br>
	 * 必填
	 */
	@JSONField(name = "device_identifier")
	private DeviceIdentifier deviceIdentifier;
	
	/**
	 * 待关联的页面列表<br>
	 * 必填
	 */
	@JSONField(name = "page_ids")
	private Integer[] pageIds;

	/**
	 * 指定页面的设备ID<br>
	 * 必填
	 * @return 指定页面的设备ID
	 */
	public DeviceIdentifier getDeviceIdentifier() {
		return deviceIdentifier;
	}

	/**
	 * 指定页面的设备ID<br>
	 * 必填
	 * @param deviceIdentifier 指定页面的设备ID
	 */
	public void setDeviceIdentifier(DeviceIdentifier deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	/**
	 * 待关联的页面列表<br>
	 * 必填
	 * @return 待关联的页面列表
	 */
	public Integer[] getPageIds() {
		return pageIds;
	}

	/**
	 * 待关联的页面列表<br>
	 * 必填
	 * @param pageIds 待关联的页面列表
	 */
	public void setPageIds(Integer[] pageIds) {
		this.pageIds = pageIds;
	}
}
