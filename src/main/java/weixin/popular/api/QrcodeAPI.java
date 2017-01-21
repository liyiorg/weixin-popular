package weixin.popular.api;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.qrcode.QrcodeTicket;
import weixin.popular.bean.qrcode.Wxaqrcode;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 二维码API
 * @author LiYi
 *
 */
public class QrcodeAPI extends BaseAPI{


	/**
	 * 创建二维码
	 * @param access_token access_token
	 * @param qrcodeJson json 数据
	 * @return QrcodeTicket
	 */
	private static QrcodeTicket qrcodeCreate(String access_token,String qrcodeJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/qrcode/create")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(qrcodeJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,QrcodeTicket.class);
	}

	/**
	 * 创建临时二维码
	 * @param access_token access_token
	 * @param expire_seconds 最大不超过604800秒（即30天）
	 * @param scene_id		  场景值ID，32位非0整型  最多10万个
	 * @return QrcodeTicket
	 */
	public static QrcodeTicket qrcodeCreateTemp(String access_token,int expire_seconds,long scene_id){
		String json = String.format("{\"expire_seconds\": %d, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}",expire_seconds,scene_id);
		return qrcodeCreate(access_token,json);
	}

	/**
	 * 创建持久二维码
	 * @param access_token access_token
	 * @param scene_id	场景值ID 1-100000
	 * @return QrcodeTicket
	 */
	public static QrcodeTicket qrcodeCreateFinal(String access_token,int scene_id){
		String json = String.format("{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":%d}}}", scene_id);
		return qrcodeCreate(access_token,json);
	}
	
	/**
	 * 创建持久二维码
	 * @param access_token access_token
	 * @param scene_str	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
	 * @return QrcodeTicket
	 */
	public static QrcodeTicket qrcodeCreateFinal(String access_token,String scene_str){
		String json = String.format("{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}", scene_str);
		return qrcodeCreate(access_token,json);
	}

	/**
	 * 下载二维码
	 * @param ticket  内部自动 UrlEncode
	 * @return BufferedImage
	 */
	public static BufferedImage showqrcode(String ticket){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(MP_URI + "/cgi-bin/showqrcode")
				.addParameter("ticket", ticket)
				.build();
		CloseableHttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
		try {
			int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
				byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
				return ImageIO.read(new ByteArrayInputStream(bytes));
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 获取小程序页面二维码 (beta)
	 * @since 2.8.5
	 * @param access_token access_token
	 * @param wxaqrcode wxaqrcode
	 * @return result
	 */
	public static QrcodeTicket wxaappCreatewxaqrcode(String access_token,Wxaqrcode wxaqrcode){
		String json = JsonUtil.toJSONString(wxaqrcode);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
								.setHeader(jsonHeader)
								.setUri(BASE_URI + "/cgi-bin/wxaapp/createwxaqrcode")
								.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
								.setEntity(new StringEntity(json,Charset.forName("utf-8")))
								.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,QrcodeTicket.class);
	}

}
