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
	 * @return the deviceId
	 */
	public Integer getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the major
	 */
	public Integer getMajor() {
		return major;
	}

	/**
	 * @param major the major
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * @return the minor
	 */
	public Integer getMinor() {
		return minor;
	}

	/**
	 * @param minor the minor
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
