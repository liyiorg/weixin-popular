/**
 * 
 */
package weixin.popular.bean.shakearound.device.search;

import java.util.List;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－查询设备列表－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceSearch {

	/**
	 * 查询类型。<br>
	 * 1：查询设备id列表中的设备；<br>
	 * 2：分页查询所有设备信息；<br>
	 * 3：分页查询某次申请的所有设备信息<br>
	 * 必填
	 */
	private Integer type;
	
	/**
	 * 指定的设备 ； 当type为1时，此项为必填
	 */
	@JSONField(name = "device_identifiers")
	private List<DeviceIdentifier> deviceIdentifiers;
	
	/**
	 * 批次ID，申请设备ID时所返回的批次ID；当type为3时，此项为必填
	 */
	@JSONField(name = "apply_id")
	private Integer applyId;
	
	/**
	 * 前一次查询列表末尾的设备ID ， 第一次查询last_seen 为0
	 */
	@JSONField(name = "last_seen")
	private Integer lastSeen;
	
	/**
	 * 待查询的设备数量，不能超过50个
	 */
	private Integer count;

	/**
	 * 查询类型。<br>
	 * 1：查询设备id列表中的设备；<br>
	 * 2：分页查询所有设备信息；<br>
	 * 3：分页查询某次申请的所有设备信息<br>
	 * 必填
	 * @return 查询类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 查询类型。<br>
	 * 1：查询设备id列表中的设备；<br>
	 * 2：分页查询所有设备信息；<br>
	 * 3：分页查询某次申请的所有设备信息<br>
	 * 必填
	 * @param type 查询类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 指定的设备 ； 当type为1时，此项为必填
	 * @return 指定的设备
	 */
	public List<DeviceIdentifier> getDeviceIdentifiers() {
		return deviceIdentifiers;
	}

	/**
	 * 指定的设备 ； 当type为1时，此项为必填
	 * @param deviceIdentifiers 指定的设备
	 */
	public void setDeviceIdentifiers(List<DeviceIdentifier> deviceIdentifiers) {
		this.deviceIdentifiers = deviceIdentifiers;
	}

	/**
	 * 批次ID，申请设备ID时所返回的批次ID；当type为3时，此项为必填
	 * @return 批次ID
	 */
	public Integer getApplyId() {
		return applyId;
	}

	/**
	 * 批次ID，申请设备ID时所返回的批次ID；当type为3时，此项为必填
	 * @param applyId 批次ID
	 */
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	/**
	 * 前一次查询列表末尾的设备ID ， 第一次查询last_seen 为0
	 * @return 前一次查询列表末尾的设备ID
	 */
	public Integer getLastSeen() {
		return lastSeen;
	}

	/**
	 * 前一次查询列表末尾的设备ID ， 第一次查询last_seen 为0
	 * @param lastSeen 前一次查询列表末尾的设备ID
	 */
	public void setLastSeen(Integer lastSeen) {
		this.lastSeen = lastSeen;
	}

	/**
	 * 待查询的设备数量，不能超过50个
	 * @return 待查询的设备数量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 待查询的设备数量，不能超过50个
	 * @param count 待查询的设备数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
