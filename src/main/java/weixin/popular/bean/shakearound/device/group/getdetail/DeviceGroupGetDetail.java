/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.getdetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－查询分组详情－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupGetDetail {

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 必填
	 */
	@JSONField(name = "group_id")
	private Integer groupId;
	
	/**
	 * 分组里设备的起始索引值<br>
	 * 必填
	 */
	private Integer begin;
	
	/**
	 * 待查询的分组里设备的数量，不能超过1000个<br>
	 * 必填
	 */
	private Integer count;

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
	 * @return 分组里设备的起始索引值
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * 分组里设备的起始索引值<br>
	 * 必填
	 * @param begin 分组里设备的起始索引值
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * @return 待查询的分组里设备的数量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 待查询的分组里设备的数量，不能超过1000个<br>
	 * 必填
	 * @param count 待查询的分组里设备的数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
