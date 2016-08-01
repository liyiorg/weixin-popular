/**
 * 
 */
package weixin.popular.bean.shakearound.lottery.querylottery;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－摇一摇红包－红包查询接口－响应参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class LotteryQueryLotteryResult extends BaseResult {

	/**
	 * 红包信息
	 */
	private LotteryQueryLotteryResultResult result;

	/**
	 * @return 红包信息
	 */
	public LotteryQueryLotteryResultResult getResult() {
		return result;
	}

	/**
	 * @param result 红包信息
	 */
	public void setResult(LotteryQueryLotteryResultResult result) {
		this.result = result;
	}
}
