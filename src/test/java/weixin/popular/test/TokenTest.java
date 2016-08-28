package weixin.popular.test;

import org.junit.Test;

import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

public class TokenTest {

	protected static String accessToken = "wIflrWSFVxtQcQMIIfvLi8t-9kd8xNPFPQwYk3tTpQ02Mk7LXZOukzv9fi10HvioXrWCScTnx3MZLEmoiH2YrBS3v94SfwHkTH6ZuRpj5hFdjCTf_Z3SsjY1jld7aMqPOLHhAGDGDZ";
	
	@Test
	public void token() {
		Token token = TokenAPI.token("XXXXX", "XXXXX");
		accessToken = token.getAccess_token();
		System.out.println(token.getAccess_token());
		// 请复制粘贴access_token 替换accessToken变量的值，方便其它接口测试类使用
	}
}
