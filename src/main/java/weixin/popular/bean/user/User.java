package weixin.popular.bean.user;

import weixin.popular.bean.BaseResult;

public class User extends BaseResult {

	private Integer subscribe; // 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。

	private String openid; // 用户的标识，对当前公众号唯一

	private String nickname;

	private String nickname_emoji; // 昵称 表情转义

	private Integer sex; // 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知

	private String language;

	private String city;

	private String province;

	private String country;

	private String headimgurl;

	private Integer subscribe_time;

	private String[] privilege; // sns 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）

	private String unionid; // 多个公众号之间用户帐号互通UnionID机制

	private Integer groupid;

	private String remark; // 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注

	private Integer[] tagid_list; // 用户被打上的标签ID列表

	private String subscribe_scene; // 2.8.20 返回用户关注的渠道来源
									// ADD_SCENE_SEARCH 公众号搜索
									// ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移
									// ADD_SCENE_PROFILE_CARD 名片分享
									// ADD_SCENE_QR_CODE 扫描二维码
									// ADD_SCENEPROFILE LINK 图文页内名称点击
									// ADD_SCENE_PROFILE_ITEM 图文页右上角菜单
									// ADD_SCENE_PAID 支付后关注
									// ADD_SCENE_OTHERS 其他

	private Integer qr_scene; // 2.8.20 二维码扫码场景（开发者自定义）

	private String qr_scene_str; // 2.8.20 二维码扫码场景描述（开发者自定义）

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

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer[] getTagid_list() {
		return tagid_list;
	}

	public void setTagid_list(Integer[] tagid_list) {
		this.tagid_list = tagid_list;
	}

	public String getNickname_emoji() {
		return nickname_emoji;
	}

	public void setNickname_emoji(String nickname_emoji) {
		this.nickname_emoji = nickname_emoji;
	}

	public String getSubscribe_scene() {
		return subscribe_scene;
	}

	public void setSubscribe_scene(String subscribe_scene) {
		this.subscribe_scene = subscribe_scene;
	}

	public Integer getQr_scene() {
		return qr_scene;
	}

	public void setQr_scene(Integer qr_scene) {
		this.qr_scene = qr_scene;
	}

	public String getQr_scene_str() {
		return qr_scene_str;
	}

	public void setQr_scene_str(String qr_scene_str) {
		this.qr_scene_str = qr_scene_str;
	}

}
