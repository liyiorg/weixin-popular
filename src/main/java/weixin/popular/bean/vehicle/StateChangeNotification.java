package weixin.popular.bean.vehicle;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import weixin.popular.bean.DynamicField;
import weixin.popular.bean.vehicle.enums.DeductMode;

/**
 * 车牌状态变更通知
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateChangeNotification implements DynamicField {

	private String mch_id;
	private String sub_mch_id;
	private String appid;
	private String sub_appid;
	private String plate_number;
	/**
	 * 当前通知车牌的状态变化类型： NORMAL-变为可用状态 BLOCKED-变为不可用状态 注意此状态是车牌状态，而非用户状态
	 */
	private String vehicle_event_type;
	/**
	 * 当前车牌状态，所对应的事件类型为BLOCKED时返回：
	 * 
	 * OVERDUE: 车牌对应用户欠费。商户引导用户还款，请跳转到车主服务
	 * 
	 * REMOVE：用户移除车牌导致车牌不可用。请跳转到授权/开通接口。
	 * 
	 * PAUSE: 用户关闭或已暂停车主服务导致车牌不可用。请跳转到授权/开通接口
	 */
	private String vehicle_event_des;
	private String nonce_str;
	private String sign_type;
	private String sign;
	private String vehicle_event_createtime;

	private String openid;
	private String sub_openid;
	private String plate_number_list;// v2.0前
	// v2.0以后返回这个
	private List<PlateNumberInfo> plate_number_info;
	// 3.0
	private DeductMode deduct_mode;

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public String getVehicle_event_type() {
		return vehicle_event_type;
	}

	public void setVehicle_event_type(String vehicle_event_type) {
		this.vehicle_event_type = vehicle_event_type;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getVehicle_event_createtime() {
		return vehicle_event_createtime;
	}

	public void setVehicle_event_createtime(String vehicle_event_createtime) {
		this.vehicle_event_createtime = vehicle_event_createtime;
	}

	public String getVehicle_event_des() {
		return vehicle_event_des;
	}

	public void setVehicle_event_des(String vehicle_event_des) {
		this.vehicle_event_des = vehicle_event_des;
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

	public String getPlate_number_list() {
		return plate_number_list;
	}

	public void setPlate_number_list(String plate_number_list) {
		this.plate_number_list = plate_number_list;
	}

	public List<PlateNumberInfo> getPlate_number_info() {
		return plate_number_info;
	}

	public void setPlate_number_info(List<PlateNumberInfo> plate_number_info) {
		this.plate_number_info = plate_number_info;
	}

	public DeductMode getDeduct_mode() {
		return deduct_mode;
	}

	public void setDeduct_mode(DeductMode deduct_mode) {
		this.deduct_mode = deduct_mode;
	}

	@Override
	public void buildDynamicField(Map<String, String> dataMap) {
		String json = dataMap.get("plate_number_info");
		if (json != null) {
			// {"plate_number_info":[{"plate_number":"粤B888888","channel_type":"ETC"}]}
			JSONObject info = JSON.parseObject(json);
			this.plate_number_info = JSON.parseArray(info.getString("plate_number_info"), PlateNumberInfo.class);
		}
	}
}
