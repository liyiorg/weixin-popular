package weixin.popular.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.popular.bean.pay.PayPackage;
import weixin.popular.util.PayUtil;

/**
 * 生成WEB JS 支付请求json
 * @author LiYi
 *
 */
public class PayJsServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String appid;			//微信后台获取
	private String partner_id;      //微信支付申请人邮箱获取
	private String partner_key;		//微信支付申请人邮箱获取
	private String pay_sign_key;	//微信支付申请人邮箱获取

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//payPackage 的商品信息，总价可以通过前端传入

		PayPackage payPackage = new PayPackage();
		payPackage.setBank_type("WX");
		payPackage.setBody("商品信息");
		payPackage.setPartner(partner_id);
		payPackage.setOut_trade_no("123456");//订单号
		payPackage.setTotal_fee("1");//单位分
		payPackage.setFee_type("1");
		payPackage.setNotify_url("http://mydomain.com/weixin/notify");//通知回调地址
		payPackage.setSpbill_create_ip(request.getRemoteHost());
		payPackage.setInput_charset("UTF-8");
		String json = PayUtil.generatePayJsRequestJson(payPackage,appid,partner_key,pay_sign_key);

		//将json 传到jsp 页面
		request.setAttribute("json", json);
		//示例jsp
		request.getRequestDispatcher("pay_example.jsp").forward(request,response);
	}


}
