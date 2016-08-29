package weixin.popular.test;

import org.junit.Test;

import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

public class TokenTest {

	protected static String accessToken = "YhobE8Sr9ZBDL1wCp-QBBTjqtp4MfkJ2O06aHr0qtXxKIEecdlvBY1sCTmKe5mcg3Y9y3-iBlV144rxXuzR0FmX_nYCyJ-TuPB7ly197UUbVmDOoJ9FqUfDLPwZglrRGNFShAKDIAN";
	
	@Test
	public void token() {
		Token token = TokenAPI.token("XXXXX", "XXXXX");
		accessToken = token.getAccess_token();
		System.out.println(token.getAccess_token());
		// 请复制粘贴access_token 替换accessToken变量的值，方便其它接口测试类使用
	}
}
