package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * 卡券－会员卡内容更新事件消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEUpdateMemberCard extends MsgECardCode {

	/**
	 * 变动的积分值。
	 */
	private Integer ModifyBonus;

	/**
	 * 变动的余额值。
	 */
	private Integer ModifyBalance;

	/**
	 * 变动的积分值。
	 * 
	 * @return
	 */
	public Integer getModifyBonus() {
		return ModifyBonus;
	}

	public void setModifyBonus(Integer modifyBonus) {
		ModifyBonus = modifyBonus;
	}

	/**
	 * 变动的余额值。
	 * 
	 * @return
	 */
	public Integer getModifyBalance() {
		return ModifyBalance;
	}

	public void setModifyBalance(Integer modifyBalance) {
		ModifyBalance = modifyBalance;
	}
}
