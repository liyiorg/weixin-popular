package weixin.popular.bean.wxa;

public class ModifyDomain {

	private String action; // add添加, delete删除, set覆盖, get获取。当参数是get时不需要填四个域名字段。

	private String[] requestdomain; // request合法域名，当action参数是get时不需要此字段。
	private String[] wsrequestdomain; // socket合法域名，当action参数是get时不需要此字段。
	private String[] uploaddomain; // uploadFile合法域名，当action参数是get时不需要此字段。
	private String[] downloaddomain; // downloadFile合法域名，当action参数是get时不需要此字段。

	public ModifyDomain() {
	}

	public ModifyDomain(String action, String[] requestdomain, String[] wsrequestdomain, String[] uploaddomain, String[] downloaddomain) {
		this.action = action;
		this.requestdomain = requestdomain;
		this.wsrequestdomain = wsrequestdomain;
		this.uploaddomain = uploaddomain;
		this.downloaddomain = downloaddomain;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

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
