package weixin.popular.bean.wxa;

import java.util.ArrayList;
import java.util.List;

public class SubmitAudit {

	private List<Item> item_list;

	public List<Item> getItem_list() {
		return item_list;
	}

	public void setItem_list(List<Item> item_list) {
		this.item_list = item_list;
	}

	public SubmitAudit() {
		item_list = new ArrayList<Item>();
	}

	public SubmitAudit(List<Item> item_list) {
		this.item_list = item_list;
	}
	public void addItem(String address,String tag,String first_class,String second_class,String title){
		Item item = new Item(address,tag,first_class,second_class,title);
		item_list.add(item);
	}
	public void removeItem(Item item){
		item_list.remove(item);
	}
	public void removeItem(int index){
		item_list.remove(index);
	}
	public static class Item {

		private String address;
		private String tag;
		private String first_class;
		private String second_class;
		private String title;

		public Item() {
		}

		public Item(String address, String tag, String first_class, String second_class, String title) {
			this.address = address;
			this.tag = tag;
			this.first_class = first_class;
			this.second_class = second_class;
			this.title = title;
		}

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
