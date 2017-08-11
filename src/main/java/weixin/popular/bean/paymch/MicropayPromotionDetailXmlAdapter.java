package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.alibaba.fastjson.JSON;

public class MicropayPromotionDetailXmlAdapter extends XmlAdapter<String, MicropayPromotionDetail> {

	@Override
	public MicropayPromotionDetail unmarshal(String v) throws Exception {
		return JSON.parseObject(v, MicropayPromotionDetail.class);
	}

	@Override
	public String marshal(MicropayPromotionDetail v) throws Exception {
		return "<![CDATA[" + JSON.toJSONString(v) + "]]>";
	}

}
