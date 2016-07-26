package weixin.popular.bean.component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 推送 component_verify_ticket协议 或 取消授权通知 XML 数据
 * 
 * @author LiYi
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComponentReceiveXML {

	@XmlElement(name = "AppId")
	private String appId;

	@XmlElement(name = "CreateTime")
	private Integer createTime;

	@XmlElement(name = "InfoType")
	private String infoType; // component_verify_ticket
								// 推送component_verify_ticket协议
								// unauthorized 取消授权
								// updateauthorized 更新授权
								// authorized 授权成功通知

	@XmlElement(name = "ComponentVerifyTicket")
	private String componentVerifyTicket;

	@XmlElement(name = "AuthorizerAppid")
	private String authorizerAppid; // 公众号

	@XmlElement(name = "AuthorizationCode")
	private String authorizationCode; // 授权码（code）

	@XmlElement(name = "AuthorizationCodeExpiredTime")
	private String authorizationCodeExpiredTime; // 过期时间

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getAuthorizationCodeExpiredTime() {
		return authorizationCodeExpiredTime;
	}

	public void setAuthorizationCodeExpiredTime(
			String authorizationCodeExpiredTime) {
		this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * component_verify_ticket 推送component_verify_ticket协议
	 * unauthorized 取消授权
	 * updateauthorized 更新授权 
	 * authorized 授权成功通知
	 * 
	 * @return infoType
	 */
	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

}
