package weixin.popular.bean;

import weixin.popular.bean.component.ApiGetAuthorizerInfoResult;
import weixin.popular.bean.component.ApiGetAuthorizerInfoResult.Authorizer_info;
import weixin.popular.bean.component.ApiGetAuthorizerInfoResult.Authorizer_info.Verify_type_info;
import weixin.popular.util.JsonUtil;

public class Test {
	
	public static void main(String[] args) {
		ApiGetAuthorizerInfoResult apiGetAuthorizerInfoResult = new ApiGetAuthorizerInfoResult();
		Authorizer_info auth = apiGetAuthorizerInfoResult.getAuthorizer_info();
		auth = new Authorizer_info();
		auth.setAlias("aa");
		apiGetAuthorizerInfoResult.setAuthorizer_info(auth);
		Verify_type_info a = new Verify_type_info();
		a.setId(1);
		auth.setVerify_type_info(a);
		
		String str = "{\"authorizer_info\":{\"alias\":\"aa\",\"verify_type_info\":{\"id\":1}},\"success\":true}";
		ApiGetAuthorizerInfoResult b = JsonUtil.parseObject(str, ApiGetAuthorizerInfoResult.class);
		ApiGetAuthorizerInfoResult apiGetAuthorizerInfoResult2 = new ApiGetAuthorizerInfoResult();
		Authorizer_info authb = apiGetAuthorizerInfoResult2.getAuthorizer_info();
		authb = new Authorizer_info();
		authb.setAlias("bb");
		System.out.println(b.getAuthorizer_info().getVerify_type_info().getId());
		System.out.println(JsonUtil.toJSONString(apiGetAuthorizerInfoResult));
		
	}
}
