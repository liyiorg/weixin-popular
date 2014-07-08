package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import weixin.popular.bean.Article;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Media;
import weixin.popular.bean.MessageSendResult;
import weixin.popular.bean.Uploadvideo;
import weixin.popular.bean.massmessage.MassMessage;
import weixin.popular.bean.message.Message;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	private ObjectMapper objectMapper  = new ObjectMapper();

	{
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,false);
	}

	/**
	 * 消息发送
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token,String messageJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/custom/send?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}

	/**
	 * 消息发送
	 * @param access_token
	 * @param message
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token,Message message){
		try {
			String str = objectMapper.writeValueAsString(message);
			return messageCustomSend(access_token,str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 高级群发 构成 MassMPnewsMessage 对象的前置请求接口
	 * @param access_token
	 * @param articles 图文信息 1-10 个
	 * @return
	 */
	public Media mediaUploadnews(String access_token,List<Article> articles){
		try {
			MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(mediaType);
			String str = objectMapper.writeValueAsString(articles);
			String messageJson = "{\"articles\":"+str+"}";
			HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
			ResponseEntity<Media> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/media/uploadnews?access_token={access_token}", HttpMethod.POST,httpEntity,Media.class, access_token);
			return responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 高级群发 构成 MassMPvideoMessage 对象的前置请求接口
	 * @param access_token
	 * @param uploadvideo
	 * @return
	 */
	public Media mediaUploadvideo(String access_token,Uploadvideo uploadvideo){
		try {
			MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(mediaType);
			String messageJson = objectMapper.writeValueAsString(uploadvideo);
			HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
			ResponseEntity<Media> responseEntity = super.restTemplate.exchange(MEDIA_URI+"/cgi-bin/media/uploadvideo?access_token={access_token}", HttpMethod.POST,httpEntity,Media.class, access_token);
			return responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 高级群发接口 根据分组进行群发
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public MessageSendResult messageMassSendall(String access_token,String messageJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
		ResponseEntity<MessageSendResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/mass/sendall?access_token={access_token}", HttpMethod.POST,httpEntity,MessageSendResult.class, access_token);
		return responseEntity.getBody();
	}

	/**
	 * 高级群发接口 根据分组进行群发
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public MessageSendResult messageMassSendall(String access_token,MassMessage massMessage){
		try {
			String str = objectMapper.writeValueAsString(massMessage);
			return messageMassSendall(access_token,str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 高级群发接口 根据OpenID列表群发
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public MessageSendResult messageMassSend(String access_token,String messageJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
		ResponseEntity<MessageSendResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/mass/send?access_token={access_token}", HttpMethod.POST,httpEntity,MessageSendResult.class, access_token);
		return responseEntity.getBody();
	}

	/**
	 * 高级群发接口 根据OpenID列表群发
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public MessageSendResult messageMassSend(String access_token,MassMessage massMessage){
		try {
			String str = objectMapper.writeValueAsString(massMessage);
			return messageMassSend(access_token,str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
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
	public BaseResult messageMassDelete(String access_token,String msgid){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		String messageJson = "{\"msgid\":" + msgid + "}";
		HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/mass/delete?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
}
