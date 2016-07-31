/**
 * 
 */
package weixin.popular.bean.shakearound.lottery.addlotteryinfo;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－摇一摇红包－创建红包活动－响应参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class LotteryAddLotteryInfoResult extends BaseResult {

	/**
	 * 生成的红包活动id
	 */
	@JSONField(name = "lottery_id")
	private String lotteryId;
	
	/**
	 * 生成的模板页面ID
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 生成的红包活动id
	 */
	public String getLotteryId() {
		return lotteryId;
	}

	/**
	 * @param lotteryId 生成的红包活动id
	 */
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}

	/**
	 * @return 生成的模板页面ID
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId 生成的模板页面ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
