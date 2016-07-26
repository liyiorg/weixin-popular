package weixin.popular.bean.shakearound.device.applyid;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－申请设备ID－请求参数
 * 
 * @author Moyq5
 * @date 2016年7月25日
 */
public class DeviceApplyId {

	/**
	 * 申请的设备ID的数量，单次新增设备超过500个，需走人工审核流程<br>
	 * 必填
	 */
	private Integer quantity;
	
	/**
	 * 申请理由，不超过100个汉字或200个英文字母<br>
	 * 必填
	 */
	@JSONField(name = "apply_reason")
	private String applyReason;
	
	/**
	 * 备注，不超过15个汉字或30个英文字母
	 */
	private String comment;
	
	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 门店相关信息具体可查看门店相关的接口文档
	 */
	@JSONField(name = "poi_id")
	private Integer poiId;

	/**
	 * @return 申请的设备ID的数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 申请的设备ID的数量，单次新增设备超过500个，需走人工审核流程<br>
	 * 必填
	 * @param quantity 申请的设备ID的数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 申请理由，不超过100个汉字或200个英文字母
	 * @return 申请理由
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 申请理由，不超过100个汉字或200个英文字母<br>
	 * 必填
	 * @param applyReason 申请理由
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * 备注，不超过15个汉字或30个英文字母
	 * @return 备注
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 备注，不超过15个汉字或30个英文字母
	 * @param comment 备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 门店相关信息具体可查看门店相关的接口文档
	 * @return 设备关联的门店ID
	 */
	public Integer getPoiId() {
		return poiId;
	}

	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 门店相关信息具体可查看门店相关的接口文档
	 * @param poiId 设备关联的门店ID
	 */
	public void setPoiId(Integer poiId) {
		this.poiId = poiId;
	}
}
