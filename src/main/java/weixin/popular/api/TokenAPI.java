package weixin.popular.api;

import weixin.popular.bean.Token;

public class TokenAPI extends BaseAPI{
	
	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public Token token(String appid,String secret){
		return super.restTemplate.postForObject(
				BASE_URI + "/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",
				null,
				Token.class,
				appid,secret);
	}
	
}
