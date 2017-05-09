package weixin.popular.bean.datacube.wxapp;

import java.util.List;

public class VisittrendResult {

	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public static class Item {
		private String ref_date;

		private Integer session_cnt;
		private Integer visit_pv;
		private Integer visit_uv;
		private Integer visit_uv_new;
		private Double stay_time_uv;
		private Double stay_time_session;
		private Double visit_depth;

		public String getRef_date() {
			return ref_date;
		}

		public void setRef_date(String ref_date) {
			this.ref_date = ref_date;
		}

		public Integer getSession_cnt() {
			return session_cnt;
		}

		public void setSession_cnt(Integer session_cnt) {
			this.session_cnt = session_cnt;
		}

		public Integer getVisit_pv() {
			return visit_pv;
		}

		public void setVisit_pv(Integer visit_pv) {
			this.visit_pv = visit_pv;
		}

		public Integer getVisit_uv() {
			return visit_uv;
		}

		public void setVisit_uv(Integer visit_uv) {
			this.visit_uv = visit_uv;
		}

		public Integer getVisit_uv_new() {
			return visit_uv_new;
		}

		public void setVisit_uv_new(Integer visit_uv_new) {
			this.visit_uv_new = visit_uv_new;
		}

		public Double getStay_time_uv() {
			return stay_time_uv;
		}

		public void setStay_time_uv(Double stay_time_uv) {
			this.stay_time_uv = stay_time_uv;
		}

		public Double getStay_time_session() {
			return stay_time_session;
		}

		public void setStay_time_session(Double stay_time_session) {
			this.stay_time_session = stay_time_session;
		}

		public Double getVisit_depth() {
			return visit_depth;
		}

		public void setVisit_depth(Double visit_depth) {
			this.visit_depth = visit_depth;
		}

	}
}
