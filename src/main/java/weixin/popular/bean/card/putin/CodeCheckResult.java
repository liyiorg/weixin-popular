package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－核查code接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CodeCheckResult {

	/**
	 * 已经成功存入的code。
	 */
	@JSONField(name = "exist_code")
	private String[] existCode;
	
	/**
	 * 没有存入的code。
	 */
	@JSONField(name = "not_exist_code")
	private String[] notExistCode;

	/**
	 * 已经成功存入的code。
	 * @return
	 */
	public String[] getExistCode() {
		return existCode;
	}

	/**
	 * 已经成功存入的code。
	 * @param existCode
	 */
	public void setExistCode(String[] existCode) {
		this.existCode = existCode;
	}

	/**
	 * 没有存入的code。
	 * @return
	 */
	public String[] getNotExistCode() {
		return notExistCode;
	}

	/**
	 * 没有存入的code。
	 * @param notExistCode
	 */
	public void setNotExistCode(String[] notExistCode) {
		this.notExistCode = notExistCode;
	}
}
