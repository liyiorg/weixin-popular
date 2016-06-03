package weixin.popular.bean.poi;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 门店类目列表
 * 
 * @author Moyq5
 *
 */
public class CategoryListResult {
	@JSONField(name = "category_list")
	private String[] categoryList;

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}
}
