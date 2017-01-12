package weixin.popular.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

/**
 * 支付回调通知
 * @author LiYi
 *
 */
public class PayNotifyServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String pay_sign_key;	//微信支付申请人邮箱获取

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求数据
		PayNotify payNotify = XMLConverUtil.convertToObject(PayNotify.class, request.getInputStream());
		//签名验证
		if(!SignatureUtil.validateAppSignature(payNotify, pay_sign_key)){
			response.getOutputStream().write("error".getBytes());
		}else{
			String sign_type = request.getParameter("sign_type");
			String input_charset = request.getParameter("input_charset");
			String sign = request.getParameter("sign");
			String trade_mode = request.getParameter("trade_mode");
			String trade_state = request.getParameter("trade_state");//支付结果 0 成功
			String partner = request.getParameter("partner");
			String bank_type = request.getParameter("bank_type");
			String bank_billno = request.getParameter("bank_billno");
			String total_fee = request.getParameter("total_fee");
			String fee_type = request.getParameter("fee_type");
			String notify_id = request.getParameter("notify_id");
			String transaction_id = request.getParameter("transaction_id");//交易号
			String out_trade_no = request.getParameter("out_trade_no");
			String attach = request.getParameter("attach");
			String time_end = request.getParameter("time_end");
			String transport_fee = request.getParameter("transport_fee");
			String product_fee = request.getParameter("product_fee");
			String discount = request.getParameter("discount");
			response.getOutputStream().write("success".getBytes());
		}
	}


}
