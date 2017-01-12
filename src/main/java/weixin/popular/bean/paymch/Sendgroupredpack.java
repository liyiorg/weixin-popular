package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sendgroupredpack {

	private String nonce_str;

	private String sign;

	private String mch_billno;

	private String mch_id;

	private String sub_mch_id;
	
	private String msgappid;		//触达用户appid 服务商模式下触达用户时的appid(可填服务商自己的appid或子商户的appid)，服务商模式下必填，服务商模式下填入的子商户appid必须在微信支付商户平台中先录入，否则会校验不过。

	private String wxappid;

	private String send_name;

	private String re_openid;

	private Integer total_amount;

	private Integer total_num;

	private String amt_type;

	private String wishing;

	private String act_name;

	private String remark;

	private String scene_id;		/*场景id
									发放红包使用场景，红包金额大于200时必传
									PRODUCT_1:商品促销
									PRODUCT_2:抽奖
									PRODUCT_3:虚拟物品兑奖 
									PRODUCT_4:企业内部福利
									PRODUCT_5:渠道分润
									PRODUCT_6:保险回馈
									PRODUCT_7:彩票派奖
									PRODUCT_8:税务刮奖*/
	private String risk_info;	 	/*活动信息 
									posttime:用户操作的时间戳
									mobile:业务系统账号的手机号，国家代码-手机号。不需要+号
									deviceid :mac 地址或者设备唯一标识 
									clientversion :用户操作的客户端版本
									把值为非空的信息用key=value进行拼接，再进行urlencode
									urlencode(posttime=xx& mobile =xx&deviceid=xx)*/

	private String consume_mch_id;	/*资金授权商户号
									资金授权商户号服务商替特约商户发放时使用*/
	
	private String sign_type;

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

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
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

	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

	public String getAmt_type() {
		return amt_type;
	}

	public void setAmt_type(String amt_type) {
		this.amt_type = amt_type;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMsgappid() {
		return msgappid;
	}

	public void setMsgappid(String msgappid) {
		this.msgappid = msgappid;
	}

	public String getScene_id() {
		return scene_id;
	}

	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

	public String getRisk_info() {
		return risk_info;
	}

	public void setRisk_info(String risk_info) {
		this.risk_info = risk_info;
	}

	public String getConsume_mch_id() {
		return consume_mch_id;
	}

	public void setConsume_mch_id(String consume_mch_id) {
		this.consume_mch_id = consume_mch_id;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

}
