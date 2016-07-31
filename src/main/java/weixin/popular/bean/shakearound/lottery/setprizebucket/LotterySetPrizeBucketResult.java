/**
 * 
 */
package weixin.popular.bean.shakearound.lottery.setprizebucket;

import java.util.List;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.shakearound.lottery.TicketInfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－摇一摇红包－录入红包信息－响应参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class LotterySetPrizeBucketResult extends BaseResult {

	/**
	 * 重复使用的ticket列表，如为空，将不返回
	 */
	@JSONField(name = "repeat_ticket_list")
	private List<TicketInfo> repeatTicketList;
	
	/**
	 * 过期的ticket列表，如为空，将不返回
	 */
	@JSONField(name = "expire_ticket_list")
	private List<TicketInfo> expireTicketList;
	
	/**
	 * 金额不在大于1元，小于1000元的ticket列表，如为空，将不返回
	 */
	@JSONField(name = "invalid_amount_ticket_list")
	private List<TicketInfo> invalidAmountTicketList;
	
	/**
	 * 原因：生成红包的时候，授权商户号auth_mchid和auth_appid没有写摇周边的商户号
	 */
	@JSONField(name = "wrong_authmchid_ticket_list")
	private List<TicketInfo> wrongAuthmchidTicketList;
	
	/**
	 * ticket解析失败，可能有错别字符或不完整
	 */
	@JSONField(name = "invalid_ticket_list")
	private List<TicketInfo> invalidTicketList;
	
	/**
	 * 成功录入的红包数量
	 */
	@JSONField(name = "success_num")
	private Integer successNum;

	/**
	 * 重复使用的ticket列表，如为空，将不返回
	 * @return 重复使用的ticket列表
	 */
	public List<TicketInfo> getRepeatTicketList() {
		return repeatTicketList;
	}

	/**
	 * @param repeatTicketList 重复使用的ticket列表
	 */
	public void setRepeatTicketList(List<TicketInfo> repeatTicketList) {
		this.repeatTicketList = repeatTicketList;
	}

	/**
	 * 过期的ticket列表，如为空，将不返回
	 * @return 过期的ticket列表
	 */
	public List<TicketInfo> getExpireTicketList() {
		return expireTicketList;
	}

	/**
	 * @param expireTicketList 过期的ticket列表
	 */
	public void setExpireTicketList(List<TicketInfo> expireTicketList) {
		this.expireTicketList = expireTicketList;
	}

	/**
	 * 金额不在大于1元，小于1000元的ticket列表，如为空，将不返回
	 * @return 金额不在大于1元，小于1000元的ticket列表
	 */
	public List<TicketInfo> getInvalidAmountTicketList() {
		return invalidAmountTicketList;
	}

	/**
	 * @param invalidAmountTicketList 金额不在大于1元，小于1000元的ticket列表
	 */
	public void setInvalidAmountTicketList(List<TicketInfo> invalidAmountTicketList) {
		this.invalidAmountTicketList = invalidAmountTicketList;
	}

	/**
	 * 原因：生成红包的时候，授权商户号auth_mchid和auth_appid没有写摇周边的商户号
	 * @return 没写商户号的ticket列表
	 */
	public List<TicketInfo> getWrongAuthmchidTicketList() {
		return wrongAuthmchidTicketList;
	}

	/**
	 * 原因：生成红包的时候，授权商户号auth_mchid和auth_appid没有写摇周边的商户号
	 * @param wrongAuthmchidTicketList 没写商户号的ticket列表
	 */
	public void setWrongAuthmchidTicketList(List<TicketInfo> wrongAuthmchidTicketList) {
		this.wrongAuthmchidTicketList = wrongAuthmchidTicketList;
	}

	/**
	 * ticket解析失败，可能有错别字符或不完整
	 * @return ticket解析失败列表
	 */
	public List<TicketInfo> getInvalidTicketList() {
		return invalidTicketList;
	}

	/**
	 * ticket解析失败，可能有错别字符或不完整
	 * @param invalidTicketList ticket解析失败列表
	 */
	public void setInvalidTicketList(List<TicketInfo> invalidTicketList) {
		this.invalidTicketList = invalidTicketList;
	}

	/**
	 * @return 成功录入的红包数量
	 */
	public Integer getSuccessNum() {
		return successNum;
	}

	/**
	 * @param successNum 成功录入的红包数量
	 */
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
}
