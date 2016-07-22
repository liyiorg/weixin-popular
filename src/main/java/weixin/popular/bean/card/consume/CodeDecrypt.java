package weixin.popular.bean.card.consume;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－Code解码接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class CodeDecrypt {
	
	/**
	 * 经过加密的Code码。<br>
	 * 必填：是
	 */
	@JSONField(name = "encrypt_code")
	private String encryptCode;

	/**
	 * 经过加密的Code码。
	 * @return
	 */
	public String getEncryptCode() {
		return encryptCode;
	}

	/**
	 * 经过加密的Code码。<br>
	 * 必填：是
	 * @param encryptCode
	 */
	public void setEncryptCode(String encryptCode) {
		this.encryptCode = encryptCode;
	}
	
}
