package weixin.popular.bean.card.consume;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－Code解码接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CodeConsumeResult extends BaseResult {

	/**
	 * 解密后获取的真实Code码
	 */
	private String code;

	/**
	 * 解密后获取的真实Code码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 解密后获取的真实Code码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
