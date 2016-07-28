package weixin.popular.bean.card.get;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券基础信息
 * 
 * @author Moyq5
 *
 */
public class BaseInfo extends weixin.popular.bean.card.create.BaseInfo {

	@JSONField(name = "date_info")
	private BaseInfoDateInfo dateInfo;
	
	private BaseInfoSku sku;

	public BaseInfoDateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(BaseInfoDateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	public BaseInfoSku getSku() {
		return sku;
	}

	public void setSku(BaseInfoSku sku) {
		this.sku = sku;
	}
}
