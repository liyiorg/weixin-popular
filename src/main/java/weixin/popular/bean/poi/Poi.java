package weixin.popular.bean.poi;

/**
 * 门店信息－提交对象
 * 
 * @author Moyq5
 *
 */
public class Poi {

	private Business business;

	public Poi() {
	}

	public Poi(Business business) {
		this.business = business;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
}
