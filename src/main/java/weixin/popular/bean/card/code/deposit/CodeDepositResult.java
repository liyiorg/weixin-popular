package weixin.popular.bean.card.code.deposit;

import weixin.popular.bean.BaseResult;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－导入code接口－响应参数
 * @author Moyq5
 * @date 2016年7月27日
 */
public class CodeDepositResult extends BaseResult {

	/**
	 * 成功个数
	 */
	@JSONField(name = "succ_code")
	private Integer succCode;
	
	/**
	 * 重复导入数
	 */
	@JSONField(name = "duplicate_code")
	private Integer duplicateCode;
	
	/**
	 * 	失败个数
	 */
	@JSONField(name = "fail_code")
	private Integer failCode;

	/**
	 * @return 成功个数
	 */
	public Integer getSuccCode() {
		return succCode;
	}

	/**
	 * @param succCode 成功个数
	 */
	public void setSuccCode(Integer succCode) {
		this.succCode = succCode;
	}

	/**
	 * @return 重复导入数
	 */
	public Integer getDuplicateCode() {
		return duplicateCode;
	}

	/**
	 * @param duplicateCode 重复导入数
	 */
	public void setDuplicateCode(Integer duplicateCode) {
		this.duplicateCode = duplicateCode;
	}

	/**
	 * @return 失败个数
	 */
	public Integer getFailCode() {
		return failCode;
	}

	/**
	 * @param failCode 失败个数
	 */
	public void setFailCode(Integer failCode) {
		this.failCode = failCode;
	}
}
