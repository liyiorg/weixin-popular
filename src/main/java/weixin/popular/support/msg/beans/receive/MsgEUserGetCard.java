package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * 卡券－领取事件推送消息<br>
 * （微信卡券－投放卡券－投放渠道数据统计事件推送消息）
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEUserGetCard extends MsgECardCode {
	/**
	 * 赠送方账号（一个OpenID），"IsGiveByFriend”为1时填写该参数。
	 */
	private String FriendUserName;
	
	/**
	 * 是否为转赠，1代表是，0代表否。
	 */
	private Boolean IsGiveByFriend;
	
	/**
	 * 转赠前的code序列号。
	 */
	private String OldUserCardCode;
	
	/**
	 * 领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加JS API接口中自定义该字段的整型值。
	 */
	private Integer OuterId;

	/**
	 * 赠送方账号（一个OpenID），"IsGiveByFriend”为1时填写该参数。
	 * 
	 * @return
	 */
	public String getFriendUserName() {
		return FriendUserName;
	}

	public void setFriendUserName(String friendUserName) {
		FriendUserName = friendUserName;
	}

	/**
	 * 是否为转赠，1代表是，0代表否。
	 * 
	 * @return
	 */
	public Boolean getIsGiveByFriend() {
		return IsGiveByFriend;
	}

	public void setIsGiveByFriend(Boolean isGiveByFriend) {
		IsGiveByFriend = isGiveByFriend;
	}

	/**
	 * 领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加JS API接口中自定义该字段的整型值。
	 * 
	 * @return
	 */
	public Integer getOuterId() {
		return OuterId;
	}

	public void setOuterId(Integer outerId) {
		OuterId = outerId;
	}

	/**
	 * 转赠前的code序列号。
	 * 
	 * @return
	 */
	public String getOldUserCardCode() {
		return OldUserCardCode;
	}

	public void setOldUserCardCode(String oldUserCardCode) {
		OldUserCardCode = oldUserCardCode;
	}

}
