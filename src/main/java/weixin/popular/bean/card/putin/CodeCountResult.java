package weixin.popular.bean.card.putin;

/**
 * 投放卡券－查询导入code数目接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CodeCountResult {

	/**
	 * 已经成功存入的code数目。
	 */
	private Integer count;

	/**
	 * 已经成功存入的code数目。
	 * 
	 * @return
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 已经成功存入的code数目。
	 * 
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
