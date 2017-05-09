package weixin.popular.bean.datacube.wxapp;

import java.util.List;

public class RetaininfoResult {

	private String ref_date;

	private List<Item> visit_uv_new;

	private List<Item> visit_uv;

	public String getRef_date() {
		return ref_date;
	}

	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public List<Item> getVisit_uv_new() {
		return visit_uv_new;
	}

	public void setVisit_uv_new(List<Item> visit_uv_new) {
		this.visit_uv_new = visit_uv_new;
	}

	public List<Item> getVisit_uv() {
		return visit_uv;
	}

	public void setVisit_uv(List<Item> visit_uv) {
		this.visit_uv = visit_uv;
	}

	public static class Item {
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
