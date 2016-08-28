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

import weixin.popular.bean.qrcode.create.Create;
import weixin.popular.bean.qrcode.create.CreateResult;
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
	 */
	public static CreateResult create(String accessToken,String postJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/qrcode/create")
										.addParameter(getATPN(), accessToken)
										.setEntity(new StringEntity(postJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CreateResult.class);
	}
	
	/**
	 * 创建二维码
	 */
	public static CreateResult create(String accessToken, Create create){
		return create(accessToken, JsonUtil.toJson(create));
	}

	/**
	 * 创建临时二维码
	 * @param accessToken access_token
	 * @param expireSeconds 最大不超过604800秒（即30天）
	 * @param sceneId		  场景值ID，32位非0整型  最多10万个
	 * @return QrcodeTicket
	 */
	public static CreateResult createBySceneId(String accessToken,int expireSeconds,long sceneId){
		String json = String.format("{\"expire_seconds\": %d, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}",expireSeconds,sceneId);
		return create(accessToken,json);
	}

	/**
	 * 创建持久二维码
	 * @param accessToken access_token
	 * @param sceneId	场景值ID 1-100000
	 * @return QrcodeTicket
	 */
	public static CreateResult createBySceneId(String accessToken,int sceneId){
		String json = String.format("{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\":%d}}}", sceneId);
		return create(accessToken,json);
	}
	
	/**
	 * 创建持久二维码
	 * @param accessToken access_token
	 * @param sceneStr	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
	 * @return QrcodeTicket
	 */
	public static CreateResult createBySceneStr(String accessToken,String sceneStr){
		String json = String.format("{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}", sceneStr);
		return create(accessToken,json);
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

}
