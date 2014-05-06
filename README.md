weixin-popular
==============

微信公众平台Java SDK


简介:
==============
weixin-poplar 包括微信公众平台基础API与支付API,提供便捷的API调用接口.

API 列表:
==============
MediaAPI	多媒体上传下载  
MenuAPI		菜单   
MessageAPI      信息发送   
PayAPI		支付订单相关接口   
QrcodeAPI       二维码   
SnsAPI          网签授权   
TokenAPI        token 获取   
UserAPI         用户管理  


工具类
==============
PayUtil         支付工具类，生成JS支付，原生支付   
SignatureUtil   签权生成、验证   
XMLConverUtil   XML 对象转换（JAXB）   

参考资料:
==============
微信公众平台开发者文档 http://mp.weixin.qq.com/wiki/index.php    
微信支付文档 http://mp.weixin.qq.com/cgi-bin/readtemplate?t=business/faq_tmpl&lang=zh_CN


消息接收示例代码:
==============
import java.io.IOException;   
import java.io.OutputStream;   
import java.io.UnsupportedEncodingException;   
import java.nio.charset.Charset;   

import javax.servlet.ServletException;   
import javax.servlet.ServletInputStream;   
import javax.servlet.ServletOutputStream;   
import javax.servlet.http.HttpServlet;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   

import org.springframework.util.StreamUtils;   

import weixin.popular.bean.EventMessage;   
import weixin.popular.bean.xmlmessage.XMLTextMessage;   
import weixin.popular.util.SignatureUtil;   
import weixin.popular.util.XMLConverUtil;   

public class ReceiveServlet extends HttpServlet{
	
	private String token = "test";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream();
		ServletOutputStream outputStream = response.getOutputStream();
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		//首次请求申请验证,返回echostr
		if(echostr!=null){
			outputStreamWrite(outputStream,echostr);
			return;
		}
		
		//验证请求签名
		if(!signature.equals(SignatureUtil.generateEventMessageSignature(token,timestamp,nonce))){
			System.out.println("The request signature is invalid");
			return;
		}
		
		if(inputStream!=null){
			String xml = StreamUtils.copyToString(inputStream,Charset.forName("utf-8"));
			System.out.println("xml: "+xml);
			//转换XML
			EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class,xml);
			//创建回复
			XMLTextMessage xmlTextMessage = new XMLTextMessage(
					eventMessage.getFromUserName(), 
					eventMessage.getToUserName(),
					"你好");
			//回复
			xmlTextMessage.outputStreamWrite(outputStream);
			return;
		}
		outputStreamWrite(outputStream,"");
	}

	/**
	 * 数据流输出
	 * @param outputStream
	 * @param text
	 * @return
	 */
	private boolean outputStreamWrite(OutputStream outputStream,String text){
		try {
			outputStream.write(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
