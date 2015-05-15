package weixin.popular.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixin.popular.bean.paymch.MchBaseResult;
import weixin.popular.bean.paymch.MchPayNotify;
import weixin.popular.util.ExpireSet;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.StreamUtils;
import weixin.popular.util.XMLConverUtil;

/**
 * 支付回调通知
 * @author LiYi
 *
 */
public class PayMchNotifyServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String key;	//mch key

	//重复通知过滤  时效60秒
    private static ExpireSet<String> expireSet = new ExpireSet<String>(60);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求数据
		String xml = StreamUtils.copyToString(request.getInputStream(), Charset.forName("utf-8"));
		Map<String, String> map = MapUtil.xmlToMap(xml);

		//已处理 去重
		if(expireSet.contains(map.get("transaction_id"))){
			return;
		}

		//签名验证
		String sign = SignatureUtil.generateSign(map,key);
		if(!sign.equals(map.get("sign"))){
			MchBaseResult baseResult = new MchBaseResult();
			baseResult.setReturn_code("FAIL");
			baseResult.setReturn_msg("ERROR");
			response.getOutputStream().write(XMLConverUtil.convertToXML(baseResult).getBytes());
		}else{
			//对象转换
			MchPayNotify payNotify = XMLConverUtil.convertToObject(MchPayNotify.class, xml);
			expireSet.add(payNotify.getTransaction_id());
			MchBaseResult baseResult = new MchBaseResult();
			baseResult.setReturn_code("SUCCESS");
			baseResult.setReturn_msg("OK");
			response.getOutputStream().write(XMLConverUtil.convertToXML(baseResult).getBytes());

		}
	}


}
