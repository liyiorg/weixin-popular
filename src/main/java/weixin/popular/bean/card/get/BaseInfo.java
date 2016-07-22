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
	private DateInfo dateInfo;
	
	private Sku sku;

	public DateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}
}
