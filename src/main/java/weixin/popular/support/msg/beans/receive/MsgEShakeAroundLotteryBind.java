package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 红包绑定用户事件通知
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEShakeAroundLotteryBind extends MsgE {
	private String LotteryId;
	private String Ticket;
	private float Money;
	
	public String getLotteryId() {
		return LotteryId;
	}
	public void setLotteryId(String lotteryId) {
		LotteryId = lotteryId;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public float getMoney() {
		return Money;
	}
	public void setMoney(float money) {
		Money = money;
	}
	
}
