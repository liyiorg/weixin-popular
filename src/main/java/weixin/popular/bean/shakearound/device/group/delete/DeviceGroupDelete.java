/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.delete;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－删除分组－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupDelete {

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 必填
	 */
	@JSONField(name = "group_id")
	private Integer groupId;

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
}
