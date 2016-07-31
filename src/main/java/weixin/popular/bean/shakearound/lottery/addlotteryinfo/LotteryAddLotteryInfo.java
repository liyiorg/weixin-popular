package weixin.popular.bean.shakearound.lottery.addlotteryinfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－摇一摇红包－创建红包活动－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class LotteryAddLotteryInfo {

	/**
	 * 抽奖活动名称（选择使用模板时，也作为摇一摇消息主标题），最长6个汉字，12个英文字母。
	 */
	private String title;
	
	/**
	 * 抽奖活动描述（选择使用模板时，也作为摇一摇消息副标题），最长7个汉字，14个英文字母。
	 */
	private String desc;
	
	/**
	 * 抽奖开关。0关闭，1开启，默认为1
	 */
	private Integer onoff;
	
	/**
	 * 抽奖活动开始时间，unix时间戳，单位秒
	 */
	@JSONField(name = "begin_time")
	private Long beginTime;
	
	/**
	 * 抽奖活动结束时间，unix时间戳，单位秒,红包活动有效期最长为91天
	 */
	@JSONField(name = "expire_time")
	private Long expireTime;
	
	/**
	 * 红包提供商户公众号的appid，需与预下单中的公众账号appid（wxappid）一致
	 */
	@JSONField(name = "sponsor_appid")
	private String sponsorAppId;
	
	/**
	 * 红包总数，红包总数是录入红包ticket总数的上限，因此红包总数应该大于等于预下单时红包ticket总数。
	 */
	private Long total;
	
	/**
	 * 红包关注界面后可以跳转到第三方自定义的页面
	 */
	@JSONField(name = "jump_url")
	private String jumpUrl;
	
	/**
	 * 开发者自定义的key，用来生成活动抽奖接口的签名参数，长度32位。使用方式见sign生成规则
	 */
	private String key;

	/**
	 * 抽奖活动名称（选择使用模板时，也作为摇一摇消息主标题），最长6个汉字，12个英文字母。
	 * @return 抽奖活动名称
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 抽奖活动名称（选择使用模板时，也作为摇一摇消息主标题），最长6个汉字，12个英文字母。
	 * @param title 抽奖活动名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 抽奖活动描述（选择使用模板时，也作为摇一摇消息副标题），最长7个汉字，14个英文字母。
	 * @return 抽奖活动描述
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 抽奖活动描述（选择使用模板时，也作为摇一摇消息副标题），最长7个汉字，14个英文字母。
	 * @param desc 抽奖活动描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 抽奖开关。0关闭，1开启，默认为1
	 * @return 抽奖开关
	 */
	public Integer getOnoff() {
		return onoff;
	}

	/**
	 * 抽奖开关。0关闭，1开启，默认为1
	 * @param onoff 抽奖开关
	 */
	public void setOnoff(Integer onoff) {
		this.onoff = onoff;
	}

	/**
	 * 抽奖活动开始时间，unix时间戳，单位秒
	 * @return 抽奖活动开始时间
	 */
	public Long getBeginTime() {
		return beginTime;
	}

	/**
	 * 抽奖活动开始时间，unix时间戳，单位秒
	 * @param beginTime 抽奖活动开始时间
	 */
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 抽奖活动结束时间，unix时间戳，单位秒,红包活动有效期最长为91天
	 * @return 抽奖活动结束时间
	 */
	public Long getExpireTime() {
		return expireTime;
	}

	/**
	 * 抽奖活动结束时间，unix时间戳，单位秒,红包活动有效期最长为91天
	 * @param expireTime 抽奖活动结束时间
	 */
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * 红包提供商户公众号的appid，需与预下单中的公众账号appid（wxappid）一致
	 * @return 红包提供商户公众号的appid
	 */
	public String getSponsorAppId() {
		return sponsorAppId;
	}

	/**
	 * 红包提供商户公众号的appid，需与预下单中的公众账号appid（wxappid）一致
	 * @param sponsorAppId 红包提供商户公众号的appid
	 */
	public void setSponsorAppId(String sponsorAppId) {
		this.sponsorAppId = sponsorAppId;
	}

	/**
	 * 红包总数，红包总数是录入红包ticket总数的上限，因此红包总数应该大于等于预下单时红包ticket总数。
	 * @return 红包总数
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * 红包总数，红包总数是录入红包ticket总数的上限，因此红包总数应该大于等于预下单时红包ticket总数。
	 * @param total 红包总数
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return 红包关注界面后可以跳转到第三方自定义的页面
	 */
	public String getJumpUrl() {
		return jumpUrl;
	}

	/**
	 * @param jumpUrl 红包关注界面后可以跳转到第三方自定义的页面
	 */
	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	/**
	 * 开发者自定义的key，用来生成活动抽奖接口的签名参数，长度32位。使用方式见sign生成规则
	 * @return 开发者自定义的key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 开发者自定义的key，用来生成活动抽奖接口的签名参数，长度32位。使用方式见sign生成规则
	 * @param key 开发者自定义的key
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
