package weixin.popular.bean.card.code.getdepositcount;

/**
 * 投放卡券－查询导入code数目接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class CodeGetDepositCountResult {

	/**
	 * 已经成功存入的code数目。
	 */
	private Integer count;

	/**
	 * @return 已经成功存入的code数目
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count 已经成功存入的code数目
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
