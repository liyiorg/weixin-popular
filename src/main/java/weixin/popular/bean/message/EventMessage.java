package weixin.popular.bean.message;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventMessage {

	//base
	@XmlElement(name="ToUserName")
	private String toUserName; 		//开发者微信号
	
	@XmlElement(name="FromUserName")
	private String fromUserName;	//发送方帐号（一个OpenID）
	
	@XmlElement(name="CreateTime")
	private Integer createTime;		//消息创建时间 （整型）
	
	@XmlElement(name="MsgType")
	private String msgType;			//消息类型，event
	
	@XmlElement(name="Event")
	private String event;			//事件类型，subscribe(订阅)、unsubscribe(取消订阅)

	//----扫描带参数二维码事件,自定义菜单key
	@XmlElement(name="EventKey")
	private String eventKey;		//事件KEY值，qrscene_为前缀，后面为二维码的参数值
	
	

	

	
	
	
	//接收普通消息------------------------------------ START
	@XmlElement(name="MsgId")
	private String msgId;			//消息ID号
	//文本
	@XmlElement(name="Content")
	private String content;			//文本消息内容
	//图片
	@XmlElement(name="PicUrl")
	private String picUrl;			//图片消息
	//媒体
	@XmlElement(name="MediaId")
	private String mediaId;			//mediaId 可以调用多媒体文件下载接口拉取数据
	//语音格式
	@XmlElement(name="Format")
	private String format;			//语音格式
	//语音识别
	@XmlElement(name="Recognition")
	private String recognition;		//开通语音识别功能的识别结果
	//视频
	@XmlElement(name="ThumbMediaId")
	private String thumbMediaId;	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	
	//地理位置-地理位置维度
	@XmlElement(name="Location_X")
	private String location_X;
	
	//地理位置-地理位置经度
	@XmlElement(name="Location_Y")
	private String location_Y;
	
	//地理位置-地图缩放大小
	@XmlElement(name="Scale")
	private String scale;
	
	//地理位置-地理位置信息
	@XmlElement(name="Label")
	private String label;
	
	//链接
	@XmlElement(name="Title")
	private String title;
	@XmlElement(name="Description")
	private String description;
	@XmlElement(name="Url")
	private String url;
	//接收普通消息------------------------------------ END
	
	
	
	
	
	
	
	//接收事件推送------------------------------------ START
	
	//关注/取消关注事件
	
	//二维码的ticket，可用来换取二维码图片
	@XmlElement(name="Ticket")
	private String ticket;			
	
	//----上报地理位置事件
	@XmlElement(name="Latitude")
	private String latitude;		//地理位置纬度
	
	@XmlElement(name="Longitude")
	private String longitude;		//地理位置经度
	
	@XmlElement(name="Precision")
	private String precision;		//地理位置精度
	//接收事件推送------------------------------------ END

	
	
	//群发消息通知------------------------------------ START
	//Event	 事件信息，此处为MASSSENDJOBFINISH
	@XmlElement(name="Status")
	private String status;/**群发的结构，为“send success”或“send fail”或“err(num)”。
							但send success时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败。err(num)是审核失败的具体原因，可能的情况如下：
							err(10001), 涉嫌广告
							err(20001), 涉嫌政治
							err(20004), 涉嫌社会
							err(20002), 涉嫌色情
							err(20006), 涉嫌违法犯罪
							err(20008), 涉嫌欺诈
							err(20013), 涉嫌版权
							err(22000), 涉嫌互推(互相宣传)
							err(21000), 涉嫌其他*/

	@XmlElement(name="TotalCount")
	private Integer totalCount;	//group_id下粉丝数；或者openid_list中的粉丝数

	@XmlElement(name="FilterCount")
	private Integer filterCount;//过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	
	@XmlElement(name="SentCount")
	private Integer sentCount;//发送成功的粉丝数

	@XmlElement(name="ErrorCount")
	private Integer errorCount;//发送失败的粉丝数
	
	//群发消息通知------------------------------------ END
	
	
	
	
	
	
	//微信认证事件推送-------------------------------- START
	
	@XmlElement(name="ExpiredTime")
	private Integer expiredTime;   //有效期 (整形)，指的是时间戳
	
	@XmlElement(name="FailTime")
	private Integer failTime;   //失败发生时间 (整形)，时间戳
	
	@XmlElement(name="FailReason")
	private String failReason;   //认证失败的原因
	
	//微信认证事件推送-------------------------------- END
	
	
	
	
	//微信门店审核事件推送-------------------------------- START
	
	@XmlElement(name="UniqId")
	private String uniqId;   //商户自己内部ID，即字段中的sid
	
	@XmlElement(name="PoiId")
	private String poiId;   //微信的门店ID，微信内门店唯一标示ID
	
	@XmlElement(name="Result")
	private String result;   //审核结果，成功succ 或失败fail
	
	@XmlElement(name="Msg")
	private String msg;   //成功的通知信息，或审核失败的驳回理由	
	
	//微信门店审核事件推送-------------------------------- END
	
	
	
	//摇一摇周边事件通知-------------------------------- START
	@XmlElement(name="ChosenBeacon")
	private ChosenBeacon chosenBeacon;   //审核结果，成功succ 或失败fail
	
	@XmlElement(name="AroundBeacons")
	private List<AroundBeacon> aroundBeacons;   //审核结果，成功succ 或失败fail
	
	//摇一摇 周边事件通知-------------------------------- END
	
	
	//摇一摇 红包绑定用户事件通知-------------------------------- START
	@XmlElement(name="LotteryId")
	private String lotteryId;
	
	@XmlElement(name="Money")
	private Integer money;
	
	@XmlElement(name="BindTime")
	private Integer bindTime;
	
	//摇一摇 红包绑定用户事件通知-------------------------------- END
	
	
	//WIFI连网后下发消息-------------------------------- START
	@XmlElement(name="ConnectTime")
	private Integer connectTime;		//连网时间
	
	@XmlElement(name="ExpireTime")
	private Integer expireTime;			//系统保留字段，固定值
	
	@XmlElement(name="VendorId")
	private String vendorId;			//系统保留字段，固定值
	
	@XmlElement(name="ShopId")
	private String shopId;				//门店ID，即shop_id
	
	@XmlElement(name="DeviceNo")
	private String deviceNo;			//连网的设备无线mac地址，对应bssid
	
	//WIFI连网后下发消息-------------------------------- END

	
	//扫一扫事件推送-------------------------------- START
	@XmlElement(name="KeyStandard")
	private String keyStandard;		//商品编码标准
	
	@XmlElement(name="KeyStr")
	private String keyStr;			//商品编码内容
	
	@XmlElement(name="Country")
	private String country;			//用户在微信内设置的国家
	
	@XmlElement(name="Province")
	private String province;		//用户在微信内设置的省份
	
	@XmlElement(name="City")
	private String city;			//用户在微信内设置的城市
	
	@XmlElement(name="Sex")
	private Integer sex;			//用户的性别，1为男性，2为女性，0代表未知
	
	@XmlElement(name="Scene")
	private Integer scene;			//打开商品主页的场景，1为扫码，2为其他打开场景（如会话、收藏或朋友圈）
	
	@XmlElement(name="RegionCode")
	private String regionCode;		//用户的实时地理位置信息（目前只精确到省一级），可在国家统计局网站查到对应明细：http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html
	
	@XmlElement(name="ReasonMsg")
	private Integer reasonMsg;		//审核未通过的原因。
	
	//扫一扫事件推送-------------------------------- END
	
	
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getLocation_X() {
		return location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getFilterCount() {
		return filterCount;
	}

	public void setFilterCount(Integer filterCount) {
		this.filterCount = filterCount;
	}

	public Integer getSentCount() {
		return sentCount;
	}

	public void setSentCount(Integer sentCount) {
		this.sentCount = sentCount;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public Integer getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Integer expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Integer getFailTime() {
		return failTime;
	}

	public void setFailTime(Integer failTime) {
		this.failTime = failTime;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	public String getPoiId() {
		return poiId;
	}

	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ChosenBeacon getChosenBeacon() {
		return chosenBeacon;
	}

	public void setChosenBeacon(ChosenBeacon chosenBeacon) {
		this.chosenBeacon = chosenBeacon;
	}

	public List<AroundBeacon> getAroundBeacons() {
		return aroundBeacons;
	}

	public void setAroundBeacons(List<AroundBeacon> aroundBeacons) {
		this.aroundBeacons = aroundBeacons;
	}

	public String getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getBindTime() {
		return bindTime;
	}

	public void setBindTime(Integer bindTime) {
		this.bindTime = bindTime;
	}

	public Integer getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(Integer connectTime) {
		this.connectTime = connectTime;
	}

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getKeyStandard() {
		return keyStandard;
	}

	public void setKeyStandard(String keyStandard) {
		this.keyStandard = keyStandard;
	}

	public String getKeyStr() {
		return keyStr;
	}

	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getScene() {
		return scene;
	}

	public void setScene(Integer scene) {
		this.scene = scene;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public Integer getReasonMsg() {
		return reasonMsg;
	}

	public void setReasonMsg(Integer reasonMsg) {
		this.reasonMsg = reasonMsg;
	}
	
}
