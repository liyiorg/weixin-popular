package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import weixin.popular.bean.vehicle.enums.DeductMode;

/**
 * 入场通知结果
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartnerpayNotificationResult extends VehicleBaseResult {

	private String user_state;
	private String openid;
	private String sub_openid;
	/**
	 * 3.0新增字段, 发起扣费的方式 PROACTIVE：表示用户主动发起的免密支付 AUTOPAY：表示用户无感的支付
	 */
	private DeductMode deduct_mode;

	public final String getUser_state() {
		return user_state;
	}

	public final void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public final String getOpenid() {
		return openid;
	}

	public final void setOpenid(String openid) {
		this.openid = openid;
	}

	public final String getSub_openid() {
		return sub_openid;
	}

	public final void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public DeductMode getDeduct_mode() {
		return deduct_mode;
	}

	public void setDeduct_mode(DeductMode deduct_mode) {
		this.deduct_mode = deduct_mode;
	}

}
