package weixin.popular.bean.wxa;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class GetCategoryResult extends BaseResult {

	private List<Category> category_list;

	public List<Category> getCategory_list() {
		return category_list;
	}

	public void setCategory_list(List<Category> category_list) {
		this.category_list = category_list;
	}

	public static class Category {

		private String first_class;
		private String second_class;
		private String third_class;
		private Integer first_id;
		private Integer second_id;
		private Integer third_id;

		public String getFirst_class() {
			return first_class;
		}

		public void setFirst_class(String first_class) {
			this.first_class = first_class;
		}

		public String getSecond_class() {
			return second_class;
		}

		public void setSecond_class(String second_class) {
			this.second_class = second_class;
		}

		public String getThird_class() {
			return third_class;
		}

		public void setThird_class(String third_class) {
			this.third_class = third_class;
		}

		public Integer getFirst_id() {
			return first_id;
		}

		public void setFirst_id(Integer first_id) {
			this.first_id = first_id;
		}

		public Integer getSecond_id() {
			return second_id;
		}

		public void setSecond_id(Integer second_id) {
			this.second_id = second_id;
		}

		public Integer getThird_id() {
			return third_id;
		}

		public void setThird_id(Integer third_id) {
			this.third_id = third_id;
		}
	}
}
