/**
 * 
 */
package weixin.popular.bean.shakearound.device.bindlocation;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－配置设备与(或者其它公众号的)门店的关联关系－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceBindLocation {

	/**
	 * 指定的设备ID<br>
	 * 必填
	 */
	@JSONField(name = "device_identifier")
	private DeviceIdentifier deviceIdentifier;
	
	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 当值为0时，将清除设备已关联的门店ID。<br>
	 * 门店相关信息具体可查看门店相关的接口文档<br>
	 * 必填
	 */
	@JSONField(name = "poi_id")
	private Integer poiId;
	
	/**
	 * 为1时，关联的门店和设备归属于同一公众账号；<br>
	 * 为2时，关联的门店为其他公众账号的门店<br>
	 * 不填默认为1
	 */
	private Integer type;
	
	/**
	 * 关联门店所归属的公众账号的APPID<br>
	 * 当Type为2时，必填
	 */
	@JSONField(name = "poi_appid")
	private String poiAppid;

	/**
	 * 指定的设备ID<br>
	 * 必填
	 * @return 指定的设备ID
	 */
	public DeviceIdentifier getDeviceIdentifier() {
		return deviceIdentifier;
	}

	/**
	 * 指定的设备ID<br>
	 * 必填
	 * @param deviceIdentifier 指定的设备ID
	 */
	public void setDeviceIdentifier(DeviceIdentifier deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 当值为0时，将清除设备已关联的门店ID。<br>
	 * 门店相关信息具体可查看门店相关的接口文档<br>
	 * 必填
	 * @return 设备关联的门店ID
	 */
	public Integer getPoiId() {
		return poiId;
	}

	/**
	 * 设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会。<br>
	 * 当值为0时，将清除设备已关联的门店ID。<br>
	 * 门店相关信息具体可查看门店相关的接口文档<br>
	 * 必填
	 * @param poiId 设备关联的门店ID
	 */
	public void setPoiId(Integer poiId) {
		this.poiId = poiId;
	}

	/**
	 * 为1时，关联的门店和设备归属于同一公众账号；<br>
	 * 为2时，关联的门店为其他公众账号的门店<br>
	 * 不填默认为1
	 * @return 门店与公众号关系类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 为1时，关联的门店和设备归属于同一公众账号；<br>
	 * 为2时，关联的门店为其他公众账号的门店<br>
	 * 不填默认为1
	 * @param type 门店与公众号关系类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 关联门店所归属的公众账号的APPID<br>
	 * 当Type为2时，必填
	 * @return 关联门店所归属的公众账号的APPID
	 */
	public String getPoiAppid() {
		return poiAppid;
	}

	/**
	 * 关联门店所归属的公众账号的APPID<br>
	 * 当Type为2时，必填
	 * @param poiAppid 关联门店所归属的公众账号的APPID
	 */
	public void setPoiAppid(String poiAppid) {
		this.poiAppid = poiAppid;
	}
}
