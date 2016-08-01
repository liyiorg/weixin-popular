/**
 * 
 */
package weixin.popular.bean.shakearound.device.search;

import weixin.popular.bean.shakearound.device.DeviceIdentifier;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－设备管理－查询设备列表－响应参数－设备信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class DeviceSearchResultDataDevice extends DeviceIdentifier {

	/**
	 * 设备的备注信息
	 */
	private String comment;
	
	/**
	 * 激活状态，0：未激活，1：已激活
	 */
	private Integer status;
	
	/**
	 * 设备最近一次被摇到的日期（最早只能获取前一天的数据）；新申请的设备该字段值为0
	 */
	@JSONField(name = "last_active_time")
	private Long lastActiveTime;
	
	/**
	 * 若配置了设备与其他公众账号门店关联关系，则返回配置门店归属的公众账号appid。<br>
	 * 查看配置设备与其他公众账号门店关联关系接口
	 */
	@JSONField(name = "poi_appid")
	private String poiAppId;
	
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
	 * 激活状态，0：未激活，1：已激活
	 * @return 激活状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 激活状态，0：未激活，1：已激活
	 * @param status 激活状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设备最近一次被摇到的日期（最早只能获取前一天的数据）；新申请的设备该字段值为0
	 * @return 设备最近一次被摇到的日期
	 */
	public Long getLastActiveTime() {
		return lastActiveTime;
	}

	/**
	 * 设备最近一次被摇到的日期（最早只能获取前一天的数据）；新申请的设备该字段值为0
	 * @param lastActiveTime 设备最近一次被摇到的日期
	 */
	public void setLastActiveTime(Long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	/**
	 * 若配置了设备与其他公众账号门店关联关系，则返回配置门店归属的公众账号appid。<br>
	 * 查看配置设备与其他公众账号门店关联关系接口
	 * @return 公众账号appid
	 */
	public String getPoiAppId() {
		return poiAppId;
	}
	
	/**
	 * 若配置了设备与其他公众账号门店关联关系，则返回配置门店归属的公众账号appid。<br>
	 * 查看配置设备与其他公众账号门店关联关系接口
	 * @param poiAppId 公众账号appid
	 */
	public void setPoiAppId(String poiAppId) {
		this.poiAppId = poiAppId;
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
