package weixin.popular.example;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.PayUtil;

/**
 * 生成WEB JS 支付请求json
 * @author LiYi
 *
 */
public class PayMchJsServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String appid;			//appid
	private String mch_id;      	//微信支付商户号
	private String key;				//API密钥

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//payPackage 的商品信息，总价可以通过前端传入

		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));

		unifiedorder.setBody("商品信息");
		unifiedorder.setOut_trade_no("123456");
		unifiedorder.setTotal_fee("1");//单位分
		unifiedorder.setSpbill_create_ip(request.getRemoteAddr());//IP
		unifiedorder.setNotify_url("http://mydomain.com/test/notify");
		unifiedorder.setTrade_type("JSAPI");//JSAPI，NATIVE，APP，MWEB

		UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder,key);
		
		//@since 2.8.5  API返回数据签名验证
		if(unifiedorderResult.getSign_status() !=null && unifiedorderResult.getSign_status()){
			String json = PayUtil.generateMchPayJsRequestJson(unifiedorderResult.getPrepay_id(), appid, key);
			
			//将json 传到jsp 页面
			request.setAttribute("json", json);
			//示例jsp
			request.getRequestDispatcher("pay_example.jsp").forward(request,response);
		}
	}


}
