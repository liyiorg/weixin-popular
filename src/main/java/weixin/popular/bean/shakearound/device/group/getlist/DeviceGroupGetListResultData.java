/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.getlist;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.device.group.GroupInfo;

/**
 * 微信摇一摇周边－查询分组列表－响应参数－分组数据
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupGetListResultData {

	/**
	 * 分组列表
	 */
	private List<GroupInfo> groups;
	
	/**
	 * 此账号下现有的总分组数
	 */
	@JSONField(name = "total_count")
	private Integer totalCount;

	/**
	 * @return 分组列表
	 */
	public List<GroupInfo> getGroups() {
		return groups;
	}

	/**
	 * @param groups 分组列表
	 */
	public void setGroups(List<GroupInfo> groups) {
		this.groups = groups;
	}

	/**
	 * @return 此账号下现有的总分组数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 此账号下现有的总分组数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
