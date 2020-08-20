package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 入场通知
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartnerpayNotification extends VehicleBaseReq {

	// 格式为json...
	@XmlJavaTypeAdapter(value = SceneInfo.JsonXmlAdapter.class)
	private SceneInfo scene_info;

	// 委托代扣的交易场景值，目前支持 ： 1. PARKING：车场停车场景 ；2. PARKING SPACE 车位停车场景；该值催缴时会向微信用户进行展示
	private String trade_scene;

	/**
	 * @return the 场景信息
	 */
	public final SceneInfo getScene_info() {
		return scene_info;
	}

	/**
	 * @param 场景信息
	 *            to set
	 */
	public final void setScene_info(SceneInfo scene_info) {
		this.scene_info = scene_info;
	}

	/**
	 * @return 场景
	 */
	public final String getTrade_scene() {
		return trade_scene;
	}

	/**
	 * @param 场景
	 *            to set
	 */
	public final void setTrade_scene(String trade_scene) {
		this.trade_scene = trade_scene;
	}
}
