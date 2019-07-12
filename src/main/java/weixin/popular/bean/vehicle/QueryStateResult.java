package weixin.popular.bean.vehicle;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import weixin.popular.bean.DynamicField;

/**
 * 用户状态查询结果
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryStateResult extends VehicleBaseResult implements DynamicField {

	private String appid;
	private String sub_appid;
	private String mch_id;
	private String sub_mch_id;
	private String nonce_str;
	private String sign;
	private String result_code;
	private String err_code;
	private String err_code_des;

	private String user_state;
	private String openid;
	private String sub_openid;

	/**
	 * 跳转车主小程序的页面路径，如果该参数返回不为空，商户侧需调用‘用户授权/开通接口’引导用户进入车主小程序进行授权/开通的操作，‘用户授权/开通接口’请查看下面的详细说明;
	 * 
	 * H5跳转同理，需跳转的场景有： -用户状态正常，但无车牌 -用户欠费 -用户未授权 -用户未开通/暂停车主服务
	 */
	private String path;
	// 车牌号列表。仅包括省份+车牌，不包括特殊字符。多个车牌时，以分好间隔。
	private String plate_number_list;// v2.0前
	private List<PlateNumberInfo> plate_number_info;// v2.0以后返回这个

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

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
