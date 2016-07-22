package weixin.popular.bean.card.putin;

import weixin.popular.bean.BaseResult;

import com.alibaba.fastjson.annotation.JSONField;

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
	 * 成功个数
	 * @return
	 */
	public Integer getSuccCode() {
		return succCode;
	}

	/**
	 * 成功个数
	 * @param succCode
	 */
	public void setSuccCode(Integer succCode) {
		this.succCode = succCode;
	}

	/**
	 * 重复导入数
	 * @return
	 */
	public Integer getDuplicateCode() {
		return duplicateCode;
	}

	/**
	 * 重复导入数
	 * @param duplicateCode
	 */
	public void setDuplicateCode(Integer duplicateCode) {
		this.duplicateCode = duplicateCode;
	}

	/**
	 * 失败个数
	 * @return
	 */
	public Integer getFailCode() {
		return failCode;
	}

	/**
	 * 失败个数
	 * @param failCode
	 */
	public void setFailCode(Integer failCode) {
		this.failCode = failCode;
	}
}
