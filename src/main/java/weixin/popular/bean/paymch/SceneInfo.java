package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import weixin.popular.util.JsonUtil;

public class SceneInfo {

	private H5Info h5_info;

	private StoreInfo store_info;

	public H5Info getH5_info() {
		return h5_info;
	}

	public void setH5_info(H5Info h5_info) {
		this.h5_info = h5_info;
	}

	public StoreInfo getStore_info() {
		return store_info;
	}

	public void setStore_info(StoreInfo store_info) {
		this.store_info = store_info;
	}

	public static class H5Info {

		private String type;

		private String app_name;

		private String package_name;

		private String wap_url;

		private String wap_name;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getApp_name() {
			return app_name;
		}

		public void setApp_name(String app_name) {
			this.app_name = app_name;
		}

		public String getPackage_name() {
			return package_name;
		}

		public void setPackage_name(String package_name) {
			this.package_name = package_name;
		}

		public String getWap_url() {
			return wap_url;
		}

		public void setWap_url(String wap_url) {
			this.wap_url = wap_url;
		}

		public String getWap_name() {
			return wap_name;
		}

		public void setWap_name(String wap_name) {
			this.wap_name = wap_name;
		}
	}

	public static class StoreInfo {

		private String id;

		private String name;

		private String area_code;

		private String address;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getArea_code() {
			return area_code;
		}

		public void setArea_code(String area_code) {
			this.area_code = area_code;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}

	static class JsonXmlAdapter extends XmlAdapter<String, SceneInfo> {

		@Override
		public String marshal(SceneInfo arg0) throws Exception {
			return "<![CDATA[" + JsonUtil.toJSONString(arg0) + "]]>";
		}

		@Override
		public SceneInfo unmarshal(String arg0) throws Exception {
			return JsonUtil.parseObject(arg0, SceneInfo.class);
		}
	}

}
