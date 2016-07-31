/**
 * 
 */
package weixin.popular.bean.shakearound.user.getshakeinfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－获取设备及用户信息－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class UserGetShakeInfo {

	/**
	 * 摇周边业务的ticket，可在摇到的URL中得到，ticket生效时间为30分钟，每一次摇都会重新生成新的ticket<br>
	 * 必填
	 */
	private String ticket;
	
	/**
	 * 是否需要返回门店poi_id，传1则返回，否则不返回；<br>
	 * 门店相关信息具体可查看<a href="https://mp.weixin.qq.com/zh_CN/htmledition/comm_htmledition/res/store_manage/store_manage_file.zip">门店相关的接口文档</a>
	 */
	@JSONField(name = "need_poi")
	private Integer needPoi;

	/**
	 * @return 摇周边业务的ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 摇周边业务的ticket，可在摇到的URL中得到，ticket生效时间为30分钟，每一次摇都会重新生成新的ticket<br>
	 * 必填
	 * @param ticket 摇周边业务的ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return 是否需要返回门店poi_id
	 */
	public Integer getNeedPoi() {
		return needPoi;
	}

	/**
	 * 是否需要返回门店poi_id，传1则返回，否则不返回；<br>
	 * 门店相关信息具体可查看<a href="https://mp.weixin.qq.com/zh_CN/htmledition/comm_htmledition/res/store_manage/store_manage_file.zip">门店相关的接口文档</a>
	 * @param needPoi 是否需要返回门店poi_id
	 */
	public void setNeedPoi(Integer needPoi) {
		this.needPoi = needPoi;
	}
}
