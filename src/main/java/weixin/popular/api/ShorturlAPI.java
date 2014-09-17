package weixin.popular.api;

import weixin.popular.bean.Shorturl;

public class ShorturlAPI extends BaseAPI{

	/**
	 * 将一条长链接转成短链接
	 * @param access_token
	 * @param action 此处填long2short，代表长链接转短链接
	 * @param long_url 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
	 * @return
	 */
	public Shorturl shorturl(String access_token,String action,String long_url){
		return super.restTemplate.postForObject(
				BASE_URI + "/cgi-bin/shorturl?access_token={access_token}&action={action}&long_url={long_url}",
				null,
				Shorturl.class,
				access_token,action,long_url);
	}

	/**
	 * 将一条长链接转成短链接   action 默认值 long2short
	 * @param access_token
	 * @param long_url
	 * @return
	 */
	public Shorturl shorturl(String access_token,String long_url){
		return shorturl(access_token,"long2short", long_url);
	}

}
