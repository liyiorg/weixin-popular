package weixin.popular.bean.shakearound.device.applystatus;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－查询设备ID申请审核状态－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceApplyStatus {

	/**
	 * 批次ID，申请设备ID时所返回的批次ID<br>
	 * 必填
	 */
	@JSONField(name = "apply_id")
	private Integer applyId;

	/**
	 * 批次ID，申请设备ID时所返回的批次ID<br>
	 * 必填
	 * @return 批次ID
	 */
	public Integer getApplyId() {
		return applyId;
	}

	/**
	 * 批次ID，申请设备ID时所返回的批次ID<br>
	 * 必填
	 * @param applyId 批次ID
	 */
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
}
