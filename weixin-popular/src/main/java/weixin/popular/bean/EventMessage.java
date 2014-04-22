package weixin.popular.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class EventMessage {

	//base
	private String toUserName; 		//开发者微信号
	private String fromUserName;	//发送方帐号（一个OpenID）
	private Integer createTime;		//消息创建时间 （整型）
	private String msgType;			//消息类型，event
	private String event;			//事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	
	//----扫描带参数二维码事件
	private String eventKey;		//事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String ticket;			//二维码的ticket，可用来换取二维码图片
	
	
	//----上报地理位置事件
	private String latitude;		//地理位置纬度
	private String longitude;		//地理位置经度
	private String precision;		//地理位置精度
	
	//普通消息
	private String msgId;			//消息ID号 
	//普通消息--文本
	private String content;			//文本消息内容
	//普通消息--图片
	private String picUrl;			//图片消息
	//普通消息--媒体
	private String mediaId;			//mediaId 可以调用多媒体文件下载接口拉取数据
	//普通消息--语音格式
	private String format;			//语音格式
	//普通消息--语音识别
	private String recognition;		//开通语音识别功能的识别结果
	//普通消息--视频
	private String thumbMediaId;	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	//普通消息--地理位置消息
	private String location_X;		//地理位置维度
	private String location_Y;		//地理位置经度
	private String scale;			//地图缩放大小
	private String label;			//地理位置信息
	//普通消息--链接消息
	private String title;
	private String description;
	private String url;
	
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	@XmlElement(name="CreateTime")
	public Integer getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	@XmlElement(name="Ticket")
	public String getTicket() {
		return ticket;
	}
	
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	@XmlElement(name="Latitude")
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@XmlElement(name="Longitude")
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@XmlElement(name="Precision")
	public String getPrecision() {
		return precision;
	}
	
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
	@XmlElement(name="MsgId")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@XmlElement(name="Format")
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	@XmlElement(name="Recognition")
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return location_X;
	}
	public void setLocation_X(String locationX) {
		location_X = locationX;
	}
	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return location_Y;
	}
	public void setLocation_Y(String locationY) {
		location_Y = locationY;
	}
	@XmlElement(name="Scale")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@XmlElement(name="Label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
