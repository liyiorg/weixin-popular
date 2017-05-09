package weixin.popular.bean.wxa;

import weixin.popular.bean.BaseResult;

public class ModifyDomainResult extends BaseResult{

	//以下字段仅在get时返回
	private String[] requestdomain; // request合法域名
	private String[] wsrequestdomain; // socket合法域名
	private String[] uploaddomain; // uploadFile合法域名
	private String[] downloaddomain; // downloadFile合法域名

	public String[] getRequestdomain() {
		return requestdomain;
	}

	public void setRequestdomain(String[] requestdomain) {
		this.requestdomain = requestdomain;
	}

	public String[] getWsrequestdomain() {
		return wsrequestdomain;
	}

	public void setWsrequestdomain(String[] wsrequestdomain) {
		this.wsrequestdomain = wsrequestdomain;
	}

	public String[] getUploaddomain() {
		return uploaddomain;
	}

	public void setUploaddomain(String[] uploaddomain) {
		this.uploaddomain = uploaddomain;
	}

	public String[] getDownloaddomain() {
		return downloaddomain;
	}

	public void setDownloaddomain(String[] downloaddomain) {
		this.downloaddomain = downloaddomain;
	}

}
