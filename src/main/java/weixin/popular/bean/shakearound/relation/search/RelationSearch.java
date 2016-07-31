/**
 * 
 */
package weixin.popular.bean.shakearound.relation.search;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－查询设备与页面的关联关系－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class RelationSearch {

	/**
	 * 查询方式。1： 查询设备的关联关系；2：查询页面的关联关系<br>
	 * 必填
	 */
	private Integer type;
	
	/**
	 * 指定的设备；当type为1时，此项为必填
	 */
	@JSONField(name = "device_identifier")
	private DeviceIdentifier deviceIdentifier;
	
	/**
	 * 指定的页面id；当type为2时，此项为必填
	 */
	@JSONField(name = "page_id")
	private Integer pageId;
	
	/**
	 * 关联关系列表的起始索引值；当type为2时，此项为必填
	 */
	private Integer begin;
	
	/**
	 * 待查询的关联关系数量，不能超过50个；当type为2时，此项为必填
	 */
	private Integer count;

	/**
	 * 查询方式。1： 查询设备的关联关系；2：查询页面的关联关系<br>
	 * 必填
	 * @return 查询方式
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 查询方式。1： 查询设备的关联关系；2：查询页面的关联关系<br>
	 * 必填
	 * @param type 查询方式
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 指定的设备；当type为1时，此项为必填
	 * @return 指定的设备
	 */
	public DeviceIdentifier getDeviceIdentifier() {
		return deviceIdentifier;
	}

	/**
	 * 指定的设备；当type为1时，此项为必填
	 * @param deviceIdentifier 指定的设备
	 */
	public void setDeviceIdentifier(DeviceIdentifier deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	/**
	 * 指定的页面id；当type为2时，此项为必填
	 * @return 指定的页面id
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * 指定的页面id；当type为2时，此项为必填
	 * @param pageId 指定的页面id
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	/**
	 * 关联关系列表的起始索引值；当type为2时，此项为必填
	 * @return 关联关系列表的起始索引值
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * 关联关系列表的起始索引值；当type为2时，此项为必填
	 * @param begin 关联关系列表的起始索引值
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * 待查询的关联关系数量，不能超过50个；当type为2时，此项为必填
	 * @return 待查询的关联关系数量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 待查询的关联关系数量，不能超过50个；当type为2时，此项为必填
	 * @param count 待查询的关联关系数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
