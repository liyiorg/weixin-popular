/**
 * 
 */
package weixin.popular.bean.shakearound.lottery.setprizebucket;

import java.util.List;

import weixin.popular.bean.shakearound.lottery.TicketInfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－摇一摇红包－录入红包信息－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class LotterySetPrizeBucket {

	/**
	 * 红包抽奖id，来自addlotteryinfo返回的lottery_id
	 */
	@JSONField(name = "lottery_id")
	private String lotteryId;
	
	/**
	 * 红包提供者的商户号，需与预下单中的商户号mch_id一致
	 */
	@JSONField(name = "mchid")
	private String mchId;
	
	/**
	 * 红包提供商户公众号的appid，需与预下单中的公众账号appid（wxappid）一致
	 */
	@JSONField(name = "sponsor_appid")
	private String sponsorAppId;
	
	/**
	 * 红包ticket列表，如果红包数较多，可以一次传入多个红包，批量调用该接口设置红包信息。<br>
	 * 每次请求传入的红包个数上限为100
	 */
	@JSONField(name = "prize_info_list")
	private List<TicketInfo> prizeInfoList;

	/**
	 * 红包抽奖id，来自addlotteryinfo返回的lottery_id
	 * @return 红包抽奖id
	 */
	public String getLotteryId() {
		return lotteryId;
	}

	/**
	 * 红包抽奖id，来自addlotteryinfo返回的lottery_id
	 * @param lotteryId 红包抽奖id
	 */
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}

	/**
	 * 红包提供者的商户号，需与预下单中的商户号mch_id一致
	 * @return 红包提供者的商户号
	 */
	public String getMchId() {
		return mchId;
	}

	/**
	 * 红包提供者的商户号，需与预下单中的商户号mch_id一致
	 * @param mchId 红包提供者的商户号
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
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
	 * 红包ticket列表，如果红包数较多，可以一次传入多个红包，批量调用该接口设置红包信息。<br>
	 * 每次请求传入的红包个数上限为100
	 * @return 红包ticket列表
	 */
	public List<TicketInfo> getPrizeInfoList() {
		return prizeInfoList;
	}

	/**
	 * 红包ticket列表，如果红包数较多，可以一次传入多个红包，批量调用该接口设置红包信息。<br>
	 * 每次请求传入的红包个数上限为100
	 * @param prizeInfoList 红包ticket列表
	 */
	public void setPrizeInfoList(List<TicketInfo> prizeInfoList) {
		this.prizeInfoList = prizeInfoList;
	}
}
