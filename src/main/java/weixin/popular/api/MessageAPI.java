package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.media.Media;
import weixin.popular.bean.message.Article;
import weixin.popular.bean.message.MessageSendResult;
import weixin.popular.bean.message.Uploadvideo;
import weixin.popular.bean.message.massmessage.MassMessage;
import weixin.popular.bean.message.message.Message;
import weixin.popular.bean.message.templatemessage.TemplateMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessageResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 当用户主动发消息给公众号的时候
 * （包括发送信息、点击自定义菜单click事件、订阅事件、扫描二维码事件、支付成功事件、用户维权），
 * 微信将会把消息数据推送给开发者，
 * 开发者在一段时间内（目前修改为48小时）可以调用客服消息接口，
 * 通过POST一个JSON数据包来发送消息给普通用户，
 * 在48小时内不限制发送次数。
 * 此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
 * @author LiYi
 *
 */
public class MessageAPI extends BaseAPI{


	/**
	 * 消息发送
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public static BaseResult messageCustomSend(String access_token,String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/message/custom/send")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 消息发送
	 * @param access_token
	 * @param message
	 * @return
	 */
	public static BaseResult messageCustomSend(String access_token,Message message){
		String str = JsonUtil.toJSONString(message);
		return messageCustomSend(access_token,str);
	}

	/**
	 * 高级群发 构成 MassMPnewsMessage 对象的前置请求接口
	 * @param access_token
	 * @param articles 图文信息 1-10 个
	 * @return
	 */
	public static Media mediaUploadnews(String access_token,List<Article> articles){
		String str = JsonUtil.toJSONString(articles);
		String messageJson = "{\"articles\":"+str+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/media/uploadnews")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Media.class);
	}

	/**
	 * 高级群发 构成 MassMPvideoMessage 对象的前置请求接口
	 * @param access_token
	 * @param uploadvideo
	 * @return
	 */
	public static Media mediaUploadvideo(String access_token,Uploadvideo uploadvideo){
		String messageJson = JsonUtil.toJSONString(uploadvideo);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(MEDIA_URI+"/cgi-bin/media/uploadvideo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Media.class);
	}


	/**
	 * 高级群发接口 根据分组进行群发
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public static MessageSendResult messageMassSendall(String access_token,String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/message/mass/sendall")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MessageSendResult.class);
	}

	/**
	 * 高级群发接口 根据分组进行群发
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public  static MessageSendResult messageMassSendall(String access_token,MassMessage massMessage){
		String str = JsonUtil.toJSONString(massMessage);
		return messageMassSendall(access_token,str);
	}


	/**
	 * 高级群发接口 根据OpenID列表群发
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public static MessageSendResult messageMassSend(String access_token,String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/message/mass/send")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MessageSendResult.class);
	}

	/**
	 * 高级群发接口 根据OpenID列表群发
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public static MessageSendResult messageMassSend(String access_token,MassMessage massMessage){
		String str = JsonUtil.toJSONString(massMessage);
		return messageMassSend(access_token,str);
	}


	/**
	 * 高级群发接口	删除群发
	 * 请注意，只有已经发送成功的消息才能删除删除消息只是将消息的图文详情页失效，
	 * 已经收到的用户，还是能在其本地看到消息卡片。
	 * 另外，删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
	 * @param access_token
	 * @param msgid
	 * @return
	 */
	public static BaseResult messageMassDelete(String access_token,String msgid){
		String messageJson = "{\"msgid\":" + msgid + "}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/message/mass/delete")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}




	/**
	 * 模板消息发送
	 * @param access_token
	 * @param templateMessage
	 * @return
	 */
	public static TemplateMessageResult messageTemplateSend(String access_token,TemplateMessage templateMessage){
		String messageJson = JsonUtil.toJSONString(templateMessage);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/message/template/send")
				.addParameter(getATPN(), access_token)
				.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TemplateMessageResult.class);
	}

}
