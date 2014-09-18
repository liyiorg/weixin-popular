package weixin.popular.api;

import weixin.popular.client.LocalHttpClient;

public abstract class BaseAPI {
	protected static final String BASE_URI = "https://api.weixin.qq.com";
	protected static final String MEDIA_URI = "http://file.api.weixin.qq.com";
	protected static final String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";


	protected LocalHttpClient localHttpClient = LocalHttpClient.getInstance();

}
