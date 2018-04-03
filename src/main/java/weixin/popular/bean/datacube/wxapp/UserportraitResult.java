package weixin.popular.bean.datacube.wxapp;

import java.util.List;

public class UserportraitResult {

	private String ref_date;

	private VisitUv visit_uv_new;

	private VisitUv visit_uv;

	public String getRef_date() {
		return ref_date;
	}

	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public VisitUv getVisit_uv_new() {
		return visit_uv_new;
	}

	public void setVisit_uv_new(VisitUv visit_uv_new) {
		this.visit_uv_new = visit_uv_new;
	}

	public VisitUv getVisit_uv() {
		return visit_uv;
	}

	public void setVisit_uv(VisitUv visit_uv) {
		this.visit_uv = visit_uv;
	}

	public static class VisitUv {
		private List<Item> province;

		private List<Item> city;

		private List<Item> genders;

		private List<Item> platforms;

		private List<Item> devices;

		private List<Item> ages;

		public List<Item> getProvince() {
			return province;
		}

		public void setProvince(List<Item> province) {
			this.province = province;
		}

		public List<Item> getCity() {
			return city;
		}

		public void setCity(List<Item> city) {
			this.city = city;
		}

		public List<Item> getGenders() {
			return genders;
		}

		public void setGenders(List<Item> genders) {
			this.genders = genders;
		}

		public List<Item> getPlatforms() {
			return platforms;
		}

		public void setPlatforms(List<Item> platforms) {
			this.platforms = platforms;
		}

		public List<Item> getDevices() {
			return devices;
		}

		public void setDevices(List<Item> devices) {
			this.devices = devices;
		}

		public List<Item> getAges() {
			return ages;
		}

		public void setAges(List<Item> ages) {
			this.ages = ages;
		}

	}

	public static class Item {
		private Integer id;

		private String name;

		private Integer value;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

	}
}
