package weixin.popular.bean.poi;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 门店信息－响应对象
 * 
 * @author Moyq5
 *
 */
public class BaseInfoResult extends BaseInfo {
	/**
	 * 门店是否可用状态。1 表示系统错误、2 表示审核中、3 审核通过、4 审核驳回。当该字段为1、2、4 状态时，poi_id 为空
	 */
	@JSONField(name = "available_state")
	private Integer availableState;
	/**
	 * 扩展字段是否正在更新中。1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
	 */
	@JSONField(name = "update_status")
	private Integer updateStatus;

	public Integer getAvailableState() {
		return availableState;
	}

	public void setAvailableState(Integer availableState) {
		this.availableState = availableState;
	}

	public Integer getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(Integer updateStatus) {
		this.updateStatus = updateStatus;
	}

}
