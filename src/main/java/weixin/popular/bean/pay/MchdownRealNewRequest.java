package weixin.popular.bean.pay;

/**
 * 对帐单下载请求参数
 * @author LiYi
 *
 */
public class MchdownRealNewRequest {

	private String spid;			//商户号 （如1201200001）
	private String trans_time;		//下载交易单的日期，格式： 2007-12-26
	private String stamp;			//UNIX 时间戳
	private String cft_signtype;	//返回结果签名类型 	0:默认值，不需要财付通签名，效率最高；	其他保留
	private String mchtype;			/*订单类型 
									下载对账单类型
									0：默认值，返回当日所有订单；
									1：返回当日成功支付的订单
									2：返回当日退款的订单*/
	private String sign;			//MD5 签名原串按照上面字段顺序再加商户key
	
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getTrans_time() {
		return trans_time;
	}
	public void setTrans_time(String transTime) {
		trans_time = transTime;
	}
	public String getStamp() {
		return stamp;
	}
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
	public String getCft_signtype() {
		return cft_signtype;
	}
	public void setCft_signtype(String cftSigntype) {
		cft_signtype = cftSigntype;
	}
	public String getMchtype() {
		return mchtype;
	}
	public void setMchtype(String mchtype) {
		this.mchtype = mchtype;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
