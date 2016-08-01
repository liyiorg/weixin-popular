/**
 * 
 */
package weixin.popular.bean.shakearound.relation.search;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－查询设备与页面的关联关系－响应参数－关联信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class RelationSearchResultDataRelation {

	/**
	 * 设备编号
	 */
	@JSONField(name = "device_id")
	private Integer deviceId;
	
	private Integer major;
	
	private Integer minor;
	
	/**
	 * 摇周边页面唯一ID
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 设备编号
	 */
	public Integer getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId 设备编号
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return 设备major
	 */
	public Integer getMajor() {
		return major;
	}

	/**
	 * @param major 设备major
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * @return 设备minor
	 */
	public Integer getMinor() {
		return minor;
	}

	/**
	 * @param minor 设备minor
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	/**
	 * @return 摇周边页面唯一ID
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId 摇周边页面唯一ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	
}
