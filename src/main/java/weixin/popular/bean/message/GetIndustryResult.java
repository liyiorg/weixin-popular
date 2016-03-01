package weixin.popular.bean.message;

import weixin.popular.bean.BaseResult;

public class GetIndustryResult extends BaseResult{

	private Industry primary_industry;
	
	private Industry secondary_industry;

	public Industry getPrimary_industry() {
		return primary_industry;
	}

	public void setPrimary_industry(Industry primary_industry) {
		this.primary_industry = primary_industry;
	}

	public Industry getSecondary_industry() {
		return secondary_industry;
	}

	public void setSecondary_industry(Industry secondary_industry) {
		this.secondary_industry = secondary_industry;
	}
	
	
}
