package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.alibaba.fastjson.JSON;

/**
 * 场景信息，不同业务场景设置不同的值
 * 
 * @author around
 *
 */
public class SceneInfo {

	private String start_time;
	private String end_time;
	private String plate_number;
	private String notify_url;
	private String car_type;
	private String parking_name;
	private String free_time;
	private String openid;
	private String sub_openid;
	private String space_number;
	private String charging_time;
	private String gas_station;
	private String gas_label_name;
	private String gas_type;
	private String gas_standard;
	private String gas_amount;
	private String gas_gun_no;
	private String entrance_name;
	private String exit_name;
	private String carrying_capacity;
	private String carrying_range;
	private String channel_type;
	private String deduct_mode;
	private String support_deduct_mode;

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getParking_name() {
		return parking_name;
	}

	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}

	public String getFree_time() {
		return free_time;
	}

	public void setFree_time(String free_time) {
		this.free_time = free_time;
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

	public String getSpace_number() {
		return space_number;
	}

	public void setSpace_number(String space_number) {
		this.space_number = space_number;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCharging_time() {
		return charging_time;
	}

	public void setCharging_time(String charging_time) {
		this.charging_time = charging_time;
	}

	public String getGas_station() {
		return gas_station;
	}

	public void setGas_station(String gas_station) {
		this.gas_station = gas_station;
	}

	public String getGas_label_name() {
		return gas_label_name;
	}

	public void setGas_label_name(String gas_label_name) {
		this.gas_label_name = gas_label_name;
	}

	public String getGas_type() {
		return gas_type;
	}

	public void setGas_type(String gas_type) {
		this.gas_type = gas_type;
	}

	public String getGas_standard() {
		return gas_standard;
	}

	public void setGas_standard(String gas_standard) {
		this.gas_standard = gas_standard;
	}

	public String getGas_amount() {
		return gas_amount;
	}

	public void setGas_amount(String gas_amount) {
		this.gas_amount = gas_amount;
	}

	public String getGas_gun_no() {
		return gas_gun_no;
	}

	public void setGas_gun_no(String gas_gun_no) {
		this.gas_gun_no = gas_gun_no;
	}

	public String getEntrance_name() {
		return entrance_name;
	}

	public void setEntrance_name(String entrance_name) {
		this.entrance_name = entrance_name;
	}

	public String getExit_name() {
		return exit_name;
	}

	public void setExit_name(String exit_name) {
		this.exit_name = exit_name;
	}

	public String getCarrying_capacity() {
		return carrying_capacity;
	}

	public void setCarrying_capacity(String carrying_capacity) {
		this.carrying_capacity = carrying_capacity;
	}

	public String getCarrying_range() {
		return carrying_range;
	}

	public void setCarrying_range(String carrying_range) {
		this.carrying_range = carrying_range;
	}

	public String getChannel_type() {
		return channel_type;
	}

	public void setChannel_type(String channel_type) {
		this.channel_type = channel_type;
	}

	public String getDeduct_mode() {
		return deduct_mode;
	}

	public void setDeduct_mode(String deduct_mode) {
		this.deduct_mode = deduct_mode;
	}

	public String getSupport_deduct_mode() {
		return support_deduct_mode;
	}

	public void setSupport_deduct_mode(String support_deduct_mode) {
		this.support_deduct_mode = support_deduct_mode;
	}

	static class JsonXmlAdapter extends XmlAdapter<String, SceneInfo> {

		@Override
		public String marshal(SceneInfo v) throws Exception {
			return "{\"scene_info\":" + JSON.toJSONString(v) + "}";
		}

		@Override
		public SceneInfo unmarshal(String v) throws Exception {
			return JSON.parseObject(v, PartnerpayNotification.class).getScene_info();
		}

	}

}
