package weixin.popular.bean.card.code.decrypt;

import weixin.popular.bean.BaseResult;

/**
 * 卡券核销－Code解码接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class CodeDecryptResult extends BaseResult {

	/**
	 * 解密后获取的真实Code码
	 */
	private String code;

	/**
	 * @return 解密后获取的真实Code码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code 解密后获取的真实Code码
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
