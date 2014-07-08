package weixin.popular.bean;

public class User extends BaseResult{

	private Integer subscribe;		//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。

	private String openid;			//用户的标识，对当前公众号唯一

	private String nickname;

	private Integer sex;			//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知

	private String language;

	private String city;

	private String province;

	private String country;

	private String headimgurl;

	private Integer subscribe_time;

	private String[] privilege;		//sns 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）

	private String unionid;			//多个公众号之间用户帐号互通UnionID机制

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Integer getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(Integer subscribeTime) {
		subscribe_time = subscribeTime;
	}

	public String[] getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
