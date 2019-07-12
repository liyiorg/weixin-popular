package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户状态查询
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryState extends VehicleBaseReq {

	private String openid;

	private String sub_openid;

	/**
	 * 委托代扣的交易场景值，目前支持 ： 1. PARKING：车场停车场景 ； 2. PARKING SPACE 车位停车场景； 3. GAS 加油场景；
	 * 4. HIGHWAY 高速场景； 5. BRIDGE 路桥场景； 该值会向微信用户进行展示
	 */
	private String trade_scene;
	/**
	 * 商户跳转的业务场景，不传默认是小程序，也支持APP和公众号H5跳转
	 * 
	 * APP:通过APP跳转
	 * 
	 * H5:通过公众号H5跳转
	 */
	private String jump_scene;
	private String plate_number;

	public String getTrade_scene() {
		return trade_scene;
	}

	public void setTrade_scene(String trade_scene) {
		this.trade_scene = trade_scene;
	}

	public String getJump_scene() {
		return jump_scene;
	}

	public void setJump_scene(String jump_scene) {
		this.jump_scene = jump_scene;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

}
