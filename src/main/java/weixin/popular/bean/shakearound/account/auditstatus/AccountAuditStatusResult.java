package weixin.popular.bean.shakearound.account.auditstatus;

import weixin.popular.bean.BaseResult;

/**
 * 周边摇一摇周边－申请开通功能－参数对象－响应参数
 * @author Moyq5
 * @date 2016年7月25日
 */
public class AccountAuditStatusResult extends BaseResult {
	
	/**
	 * 申请状态信息
	 */
	private AccountAuditStatusResultData data;

	/**
	 * @return 申请状态信息
	 */
	public AccountAuditStatusResultData getData() {
		return data;
	}

	/**
	 * @param data 申请状态信息
	 */
	public void setData(AccountAuditStatusResultData data) {
		this.data = data;
	}
}
