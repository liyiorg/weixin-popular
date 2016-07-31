/**
 * 
 */
package weixin.popular.bean.shakearound.user.getshakeinfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－获取设备及用户信息－响应参数－设备及用户信息
 * @author Moyq5
 * @date 2016年7月30日
 */
public class UserGetShakeInfoResultData {

	/**
	 * 摇周边页面唯一ID
	 */
	@JSONField(name = "page_id")
	private Integer pageId;
	
	/**
	 * 设备信息，包括UUID、major、minor，以及距离
	 */
	@JSONField(name = "beacon_info")
	private UserGetShakeInfoResultDataBeaconInfo beaconInfo;
	
	/**
	 * 商户AppID下用户的唯一标识
	 */
	@JSONField(name = "openid")
	private String openId;
	
	/**
	 * 门店ID，有的话则返回，反之不会在JSON格式内
	 */
	@JSONField(name = "poi_id")
	private Integer poiId;

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

	/**
	 * 设备信息，包括UUID、major、minor，以及距离
	 * @return 设备信息
	 */
	public UserGetShakeInfoResultDataBeaconInfo getBeaconInfo() {
		return beaconInfo;
	}

	/**
	 * 设备信息，包括UUID、major、minor，以及距离
	 * @param beaconInfo 设备信息
	 */
	public void setBeaconInfo(UserGetShakeInfoResultDataBeaconInfo beaconInfo) {
		this.beaconInfo = beaconInfo;
	}

	/**
	 * @return 商户AppID下用户的唯一标识
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId 商户AppID下用户的唯一标识
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * 门店ID，有的话则返回，反之不会在JSON格式内
	 * @return 门店ID
	 */
	public Integer getPoiId() {
		return poiId;
	}

	/**
	 * @param poiId 门店ID
	 */
	public void setPoiId(Integer poiId) {
		this.poiId = poiId;
	}
}
