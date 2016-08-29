package weixin.popular.bean.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 门店类目列表
 * 
 * @author Moyq5
 *
 */
public class CategoryListResult {
	@JsonProperty("category_list")
	private String[] categoryList;

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}
}
