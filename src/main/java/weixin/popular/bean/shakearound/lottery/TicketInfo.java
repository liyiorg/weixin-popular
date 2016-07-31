/**
 * 
 */
package weixin.popular.bean.shakearound.lottery;

/**
 * 微信摇一摇周边－摇一摇红包－录入红包信息－请求参数－红包ticket
 * @author Moyq5
 * @date 2016年7月30日
 */
public class TicketInfo {

	/**
	 * 预下单时返回的红包ticket，<br>
	 * 添加时：单个活动红包ticket数量上限为100000个，可添加多次。
	 */
	private String ticket;

	/**
	 * 预下单时返回的红包ticket，<br>
	 * 添加时：单个活动红包ticket数量上限为100000个，可添加多次。
	 * @return 预下单时返回的红包ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 预下单时返回的红包ticket，<br>
	 * 添加时：单个活动红包ticket数量上限为100000个，可添加多次。
	 * @param ticket 预下单时返回的红包ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
