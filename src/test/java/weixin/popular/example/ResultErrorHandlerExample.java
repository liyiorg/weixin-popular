package weixin.popular.example;

import com.alibaba.fastjson.JSON;

import weixin.popular.api.PayMchAPI;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.paymch.Refundquery;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.client.ResultErrorHandler;

public class ResultErrorHandlerExample extends ResultErrorHandler{

	@Override
	protected void handle(String uriId, String uri, String requestEntity, Object result) {
		System.out.println("uriId:" + uriId);
		System.out.println("uri:" + uri);
		System.out.println("requestEntity:" + requestEntity);
		System.out.println("result:" + result);
		System.out.println("resultJSON:" + JSON.toJSONString(result));
	}

	
	public static void main(String[] args) {
		//设置数据错误处理
		LocalHttpClient.setResultErrorHandler(new ResultErrorHandlerExample());
		
		UserAPI.tagsCreate("access_token","test");
		PayMchAPI.payRefundquery(new Refundquery(), "key");
	}
}
