package weixin.popular.bean.wxa;

import java.util.List;

public class SubmitAudit {

	private List<Item> item_list;

	public List<Item> getItem_list() {
		return item_list;
	}

	public void setItem_list(List<Item> item_list) {
		this.item_list = item_list;
	}

	public static class Item {

		private String address;
		private String tag;
		private String first_class;
		private String second_class;
		private String title;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}

}
