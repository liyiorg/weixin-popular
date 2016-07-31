/**
 * 
 */
package weixin.popular.bean.shakearound.device.group;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分组信息
 * @author Moyq5
 * @date 2016年7月30日
 */
public class GroupInfo {

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 修改必填
	 */
	@JSONField(name = "group_id")
	private Integer groupId;
	
	/**
	 * 分组名<br>
	 * 修改必填
	 */
	@JSONField(name = "group_name")
	private String groupName;

	/**
	 * 分组唯一标识，全局唯一
	 * @return 分组唯一标识
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * 分组唯一标识，全局唯一<br>
	 * 修改必填
	 * @param groupId 分组唯一标识
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return 分组名
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * 分组名<br>
	 * 修改必填
	 * @param groupName 分组名
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
