/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.add;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－新增分组－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupAdd {

	/**
	 * 分组名称，不超过100汉字或200个英文字母<br>
	 * 必填
	 */
	@JSONField(name = "group_name")
	private String groupName;

	/**
	 * 分组名称，不超过100汉字或200个英文字母
	 * @return 分组名称
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * 分组名称，不超过100汉字或200个英文字母<br>
	 * 必填
	 * @param groupName 分组名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
