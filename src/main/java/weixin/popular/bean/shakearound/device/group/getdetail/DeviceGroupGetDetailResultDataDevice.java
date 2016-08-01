/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.getdetail;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－查询分组详情－响应参数－分组详情－设备信息
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupGetDetailResultDataDevice extends DeviceIdentifier {

	/**
	 * 设备的备注信息
	 */
	private String comment;
	
	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 门店相关信息具体可查看门店相关的接口文档 
	 */
	@JSONField(name = "poi_id")
	private Integer poiId;

	/**
	 * @return 设备的备注信息
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment 设备的备注信息
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return 设备关联的门店ID
	 */
	public Integer getPoiId() {
		return poiId;
	}

	/**
	 * @param poiId 设备关联的门店ID
	 */
	public void setPoiId(Integer poiId) {
		this.poiId = poiId;
	}
}
