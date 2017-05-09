package weixin.popular.bean.datacube.wxapp;

import java.util.List;

public class VisitdistributionResult {

	private String ref_date;

	private List<Item> list;

	public String getRef_date() {
		return ref_date;
	}

	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public static class Item {

		private String index;

		private List<Item_list> item_list;

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public List<Item_list> getItem_list() {
			return item_list;
		}

		public void setItem_list(List<Item_list> item_list) {
			this.item_list = item_list;
		}

	}

	public static class Item_list {
		private Integer key;

		private Integer value;

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

	}

}
