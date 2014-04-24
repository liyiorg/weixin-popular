package weixin.popular.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import weixin.popular.bean.QrcodeTicket;

/**
 * 二维码API
 * @author LiYi
 *
 */
public class QrcodeAPI extends BaseAPI{

	
	/**
	 * 创建二维码
	 * @param access_token
	 * @param qrcodeJson json 数据 例如{"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	 * @return
	 */
	private QrcodeTicket qrcodeCreate(String access_token,String qrcodeJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(qrcodeJson,headers);
		ResponseEntity<QrcodeTicket> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/qrcode/create?access_token={access_token}", HttpMethod.POST,httpEntity,QrcodeTicket.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 创建二维码
	 * @param access_token
	 * @param expire_seconds 	该二维码有效时间，以秒为单位。 最大不超过1800秒。
	 * @param action_name		二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
	 * @param scene_id			场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return
	 */
	private QrcodeTicket qrcodeCreate(String access_token,Integer expire_seconds,String action_name,long scene_id){
		return qrcodeCreate(access_token,String.format("{"+(expire_seconds==null?"%1$s":"\"expire_seconds\": %1$s, ")+"\"action_name\": \"%2$s\", \"action_info\": {\"scene\": {\"scene_id\": %3$d}}}",
													expire_seconds==null?"":expire_seconds,action_name,scene_id));
	}
	
	/**
	 * 创建临时二维码
	 * @param access_token
	 * @param expire_seconds 不超过1800秒
	 * @param scene_id		  场景值ID，32位非0整型
	 * @return
	 */
	public QrcodeTicket qrcodeCreateTemp(String access_token,int expire_seconds,long scene_id){
		return qrcodeCreate(access_token,expire_seconds,"QR_SCENE",scene_id);
	}
	
	/**
	 * 创建持久二维码
	 * @param access_token
	 * @param scene_id	场景值ID 1-100000
	 * @return
	 */
	public QrcodeTicket qrcodeCreateFinal(String access_token,int scene_id){
		return qrcodeCreate(access_token,null,"QR_LIMIT_SCENE",scene_id);
	}
	
	/**
	 * 下载二维码
	 * 视频文件不支持下载
	 * @param ticket  内部自动 UrlEncode
	 * @return
	 */
	public ResponseEntity<ByteArrayResource> showqrcode(String ticket){
		try {
			return super.restTemplate.postForEntity(QRCODE_DOWNLOAD_URI + "/cgi-bin/showqrcode?ticket={ticket}",
																null,
																ByteArrayResource.class,
																URLEncoder.encode(ticket,"utf-8"));
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
