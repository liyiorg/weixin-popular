package weixin.popular.support;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import weixin.popular.api.API;
import weixin.popular.api.ComponentAPI;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.component.ApiQueryAuthResult;
import weixin.popular.bean.message.message.TextMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;

/**
 * 全网发布接入检测
 * @author LiYi
 * 2016-03-15
 * https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318611&token=&lang=zh_CN
 */
public class ComponentCase {

	private static final String TEST_APPID = "wx570bc396a51b8ff8";
	
	private static final String TEST_USERNAME = "gh_3c884a361561";
	
	/**
	 * 全网发布接入检测
	 * @param component_access_token
	 * @param component_appid
	 * @param postData
	 * @param outputStream
	 * @param wxBizMsgCrypt
	 * @return 0 非检测   1-5 检测
	 */
	public static int doCase(String component_access_token,String component_appid,Map<String,String> postData,OutputStream outputStream,WXBizMsgCrypt wxBizMsgCrypt){
		
		String username = postData.get("ToUserName");
		if(username != null && TEST_USERNAME.equals(username)){
			/*
			1、模拟粉丝触发专用测试公众号的事件，并推送事件消息到专用测试公众号，第三方平台方开发者需要提取推送XML信息中的event值，并在5秒内立即返回按照下述要求组装的文本消息给粉丝。
			1）微信推送给第三方平台方： 事件XML内容（与普通公众号接收到的信息是一样的）
			2）服务方开发者在5秒内回应文本消息并最终触达到粉丝：文本消息的XML中Content字段的内容必须组装为：event + “from_callback”（假定event为LOCATION，则Content为: LOCATIONfrom_callback）*/
			if("event".equalsIgnoreCase(postData.get("MsgType"))){
				XMLTextMessage textMessage = new XMLTextMessage(postData.get("FromUserName"), TEST_USERNAME, postData.get("Event")+"from_callback");
				textMessage.outputStreamWrite(outputStream, wxBizMsgCrypt);
				return 1;
			}
			/*
			2、模拟粉丝发送文本消息给专用测试公众号，第三方平台方需根据文本消息的内容进行相应的响应：
			1）微信模推送给第三方平台方：文本消息，其中Content字段的内容固定为：TESTCOMPONENT_MSG_TYPE_TEXT
			2）第三方平台方立马回应文本消息并最终触达粉丝：Content必须固定为：TESTCOMPONENT_MSG_TYPE_TEXT_callback*/
			if("text".equalsIgnoreCase(postData.get("MsgType")) && "TESTCOMPONENT_MSG_TYPE_TEXT".equals(postData.get("Content"))){
				XMLTextMessage textMessage = new XMLTextMessage(postData.get("FromUserName"), TEST_USERNAME, "TESTCOMPONENT_MSG_TYPE_TEXT_callback");
				textMessage.outputStreamWrite(outputStream, wxBizMsgCrypt);
				return 2;
			}
			
			/*
			3、模拟粉丝发送文本消息给专用测试公众号，第三方平台方需在5秒内返回空串表明暂时不回复，然后再立即使用客服消息接口发送消息回复粉丝
			1）微信模推送给第三方平台方：文本消息，其中Content字段的内容固定为： QUERY_AUTH_CODE:$query_auth_code$（query_auth_code会在专用测试公众号自动授权给第三方平台方时，由微信后台推送给开发者）
			2）第三方平台方拿到$query_auth_code$的值后，通过接口文档页中的“使用授权码换取公众号的授权信息”API，将$query_auth_code$的值赋值给API所需的参数authorization_code。然后，调用发送客服消息api回复文本消息给粉丝，其中文本消息的content字段设为：$query_auth_code$_from_api（其中$query_auth_code$需要替换成推送过来的query_auth_code）*/
			if("text".equalsIgnoreCase(postData.get("MsgType"))&&postData.get("Content")!=null&&postData.get("Content").startsWith("QUERY_AUTH_CODE:")){
				final String query_auth_code = postData.get("Content").replace("QUERY_AUTH_CODE:","");
				final String component_access_token_ = component_access_token;
				final String component_appid_ = component_appid;
				final String toUserName = postData.get("FromUserName");
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						try {
							ApiQueryAuthResult apiQueryAuthResult = ComponentAPI.api_query_auth(component_access_token_, component_appid_, query_auth_code);
							String authorizer_access_token = apiQueryAuthResult.getAuthorization_info().getAuthorizer_access_token();
							API.mode(API.MODE_COMPONENT);
							MessageAPI.messageCustomSend(authorizer_access_token, new TextMessage(toUserName, query_auth_code + "_from_api"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				},2000);
				try {
					outputStream.write("".getBytes("utf-8"));
					return 3;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//4、模拟推送component_verify_ticket给开发者，开发者需按要求回复（接收到后必须直接返回字符串success）。
		/*if("component_verify_ticket".equals(postData.get("InfoType"))){
			try {
				outputStream.write("success".getBytes("utf-8"));
				return 4;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		if(postData.get("InfoType")!=null && TEST_APPID.equals(postData.get("AuthorizerAppid"))){
			try {
				outputStream.write("success".getBytes("utf-8"));
				return 5;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
}
