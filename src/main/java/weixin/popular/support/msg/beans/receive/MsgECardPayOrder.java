package weixin.popular.support.msg.beans.receive;

/**
 * 卡券－券点流水详情事件消息
 * 
 * @author Moyq5
 *
 */
public abstract class MsgECardPayOrder extends MsgE {
	/**
	 * 本次推送对应的订单号
	 */
	private String OrderId;

	/**
	 * 本次订单号的状态,<br>
	 * ORDER_STATUS_WAITING 等待支付 <br>
	 * ORDER_STATUS_SUCC 支付成功 <br>
	 * ORDER_STATUS_FINANCE_SUCC 加代币成功 <br>
	 * ORDER_STATUS_QUANTITY_SUCC 加库存成功 <br>
	 * ORDER_STATUS_HAS_REFUND 已退币 <br>
	 * ORDER_STATUS_REFUND_WAITING 等待退币确认 <br>
	 * ORDER_STATUS_ROLLBACK 已回退,系统失败 <br>
	 * ORDER_STATUS_HAS_RECEIPT 已开发票
	 */
	private String Status;

	/**
	 * 购买券点时，支付二维码的生成时间
	 */
	private Integer CreateOrderTime;

	/**
	 * 购买券点时，实际支付成功的时间
	 */
	private Integer PayFinishTime;

	/**
	 * 支付方式，一般为微信支付充值
	 */
	private String Desc;

	/**
	 * 剩余免费券点数量
	 */
	private String FreeCoinCount;

	/**
	 * 剩余付费券点数量
	 */
	private String PayCoinCount;

	/**
	 * 本次变动的免费券点数量
	 */
	private String RefundFreeCoinCount;

	/**
	 * 本次变动的付费券点数量
	 */
	private String RefundPayCoinCount;

	/**
	 * 所要拉取的订单类型<br>
	 * ORDER_TYPE_SYS_ADD 平台赠送券点 <br>
	 * ORDER_TYPE_WXPAY 充值券点 <br>
	 * ORDER_TYPE_REFUND 库存未使用回退券点 <br>
	 * ORDER_TYPE_REDUCE 券点兑换库存 <br>
	 * ORDER_TYPE_SYS_REDUCE 平台扣减
	 */
	private String OrderType;

	/**
	 * 系统备注，说明此次变动的缘由，如开通账户奖励、门店奖励、核销奖励以及充值、扣减。
	 */
	private String Memo;

	/**
	 * 所开发票的详情
	 */
	private String ReceiptInfo;

	/**
	 * 本次推送对应的订单号
	 * 
	 * @return
	 */
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	/**
	 * 本次订单号的状态,<br>
	 * ORDER_STATUS_WAITING 等待支付 <br>
	 * ORDER_STATUS_SUCC 支付成功 <br>
	 * ORDER_STATUS_FINANCE_SUCC 加代币成功 <br>
	 * ORDER_STATUS_QUANTITY_SUCC 加库存成功 <br>
	 * ORDER_STATUS_HAS_REFUND 已退币 <br>
	 * ORDER_STATUS_REFUND_WAITING 等待退币确认 <br>
	 * ORDER_STATUS_ROLLBACK 已回退,系统失败 <br>
	 * ORDER_STATUS_HAS_RECEIPT 已开发票
	 * 
	 * @return
	 */
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * 购买券点时，支付二维码的生成时间
	 * 
	 * @return
	 */
	public Integer getCreateOrderTime() {
		return CreateOrderTime;
	}

	public void setCreateOrderTime(Integer createOrderTime) {
		CreateOrderTime = createOrderTime;
	}

	/**
	 * 购买券点时，实际支付成功的时间
	 * 
	 * @return
	 */
	public Integer getPayFinishTime() {
		return PayFinishTime;
	}

	public void setPayFinishTime(Integer payFinishTime) {
		PayFinishTime = payFinishTime;
	}

	/**
	 * 支付方式，一般为微信支付充值
	 * 
	 * @return
	 */
	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	/**
	 * 剩余免费券点数量
	 * 
	 * @return
	 */
	public String getFreeCoinCount() {
		return FreeCoinCount;
	}

	public void setFreeCoinCount(String freeCoinCount) {
		FreeCoinCount = freeCoinCount;
	}

	/**
	 * 剩余付费券点数量
	 * 
	 * @return
	 */
	public String getPayCoinCount() {
		return PayCoinCount;
	}

	public void setPayCoinCount(String payCoinCount) {
		PayCoinCount = payCoinCount;
	}

	/**
	 * 本次变动的免费券点数量
	 * 
	 * @return
	 */
	public String getRefundFreeCoinCount() {
		return RefundFreeCoinCount;
	}

	public void setRefundFreeCoinCount(String refundFreeCoinCount) {
		RefundFreeCoinCount = refundFreeCoinCount;
	}

	/**
	 * 本次变动的付费券点数量
	 * 
	 * @return
	 */
	public String getRefundPayCoinCount() {
		return RefundPayCoinCount;
	}

	public void setRefundPayCoinCount(String refundPayCoinCount) {
		RefundPayCoinCount = refundPayCoinCount;
	}

	/**
	 * 所要拉取的订单类型<br>
	 * ORDER_TYPE_SYS_ADD 平台赠送券点 <br>
	 * ORDER_TYPE_WXPAY 充值券点 <br>
	 * ORDER_TYPE_REFUND 库存未使用回退券点 <br>
	 * ORDER_TYPE_REDUCE 券点兑换库存 <br>
	 * ORDER_TYPE_SYS_REDUCE 平台扣减
	 * 
	 * @return
	 */
	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}

	/**
	 * 系统备注，说明此次变动的缘由，如开通账户奖励、门店奖励、核销奖励以及充值、扣减。
	 * 
	 * @return
	 */
	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	/**
	 * 所开发票的详情
	 * 
	 * @return
	 */
	public String getReceiptInfo() {
		return ReceiptInfo;
	}

	public void setReceiptInfo(String receiptInfo) {
		ReceiptInfo = receiptInfo;
	}

}
