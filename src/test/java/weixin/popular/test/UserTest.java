package weixin.popular.test;

import org.junit.Test;

import weixin.popular.api.UserAPI;
import weixin.popular.bean.user.FollowResult;

public class UserTest extends TokenTest {

	/**
	 * 获取用户列表
	 */
	@Test
	public void userGet() {
		FollowResult result = UserAPI.userGet(accessToken, null);
		System.out.println(result.getErrmsg());
	}
}
