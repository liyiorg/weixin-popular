package weixin.popular.bean.datacube.wxapp;

import java.util.List;

public class SummarytrendResult {

	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public static class Item {
		private String ref_date;

		private Integer visit_total;

		private Integer share_pv;

		private Integer share_uv;

		public String getRef_date() {
			return ref_date;
		}

		public void setRef_date(String ref_date) {
			this.ref_date = ref_date;
		}

		public Integer getVisit_total() {
			return visit_total;
		}

		public void setVisit_total(Integer visit_total) {
			this.visit_total = visit_total;
		}

		public Integer getShare_pv() {
			return share_pv;
		}

		public void setShare_pv(Integer share_pv) {
			this.share_pv = share_pv;
		}

		public Integer getShare_uv() {
			return share_uv;
		}

		public void setShare_uv(Integer share_uv) {
			this.share_uv = share_uv;
		}
	}

}
