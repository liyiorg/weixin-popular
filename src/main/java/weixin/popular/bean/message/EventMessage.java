package weixin.popular.bean.message;

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

}
