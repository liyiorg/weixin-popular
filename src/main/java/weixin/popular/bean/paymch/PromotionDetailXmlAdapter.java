package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.alibaba.fastjson.JSON;

public class PromotionDetailXmlAdapter extends XmlAdapter<String, PromotionDetail> {

	@Override
	public PromotionDetail unmarshal(String v) throws Exception {
		return JSON.parseObject(v, PromotionDetail.class);
	}

	@Override
	public String marshal(PromotionDetail v) throws Exception {
		return "<![CDATA[" + JSON.toJSONString(v) + "]]>";
	}

}
