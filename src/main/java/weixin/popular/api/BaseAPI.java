package weixin.popular.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public abstract class BaseAPI {
	protected static final String BASE_URI = "https://api.weixin.qq.com";
	protected static final String MEDIA_URI = "http://file.api.weixin.qq.com";
	protected static final String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";
	protected static final String MCH_URI = "https://api.mch.weixin.qq.com";
	protected static final String OPEN_URI = "https://open.weixin.qq.com";

	protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
	protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());
	
	protected static final String PARAM_ACCESS_TOKEN = "access_token";
	protected static final String PARAM_AUTHORIZER_ACCESS_TOKEN = "authorizer_access_token";
	
	/**
	 * 获取 access token param name 名称
	 * 
	 * 2.6.0
	 * @return access_token or authorizer_access_token
	 */
	protected static String getATPN(){
		if(API.currentMode() == API.MODE_COMPONENT){ 
			return PARAM_AUTHORIZER_ACCESS_TOKEN;
		}else{
			return PARAM_ACCESS_TOKEN;
		}
	}
}
