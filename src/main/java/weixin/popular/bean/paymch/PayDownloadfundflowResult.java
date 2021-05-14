package weixin.popular.bean.paymch;

import weixin.popular.bean.paymch.base.BillResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayDownloadfundflowResult extends MchBase implements BillResult {

	private String data;

	@Override
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * CSV 格式数据，包含UTF-8 头部信息。
	 * @since 2.8.31
	 * @return
	 */
	public String csvData() {
		if (data != null) {
			// UTF-8编码
			byte[] headCode = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
			return new String(headCode) + data;
		}
		return null;
	}
}
