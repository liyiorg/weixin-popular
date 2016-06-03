package weixin.popular.test;

import org.junit.Test;

import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

public class TokenTest {

	protected static String accessToken = "Tb_ZeBHgEHtTW1nkolJ6uhECu_gNipC9eZ-NUw-fN9Tq5cCvOCy4zQz9cRUQrE_FAEps59fbKjVJr7S5NHa1a8fk78jHjjKFSuwJEanR3y6N7fABleM0NWicDQQP9yNkJZSgAAARHA";
	
	@Test
	public void token() {
		Token token = TokenAPI.token("XXXXX", "XXXXX");
		accessToken = token.getAccess_token();
		System.out.println(token.getAccess_token());
		// 请复制粘贴access_token 替换accessToken变量的值，方便其它接口测试类使用
	}
}
