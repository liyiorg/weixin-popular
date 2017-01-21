package weixin.popular.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.UnsupportedCharsetException;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.media.Media;
import weixin.popular.bean.media.MediaGetResult;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.media.UploadimgResult;
import weixin.popular.client.BytesOrJsonResponseHandler;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.StreamUtils;

/**
 * 临时素材API
 * @author LiYi
 *
 */
public class MediaAPI extends BaseAPI{

	/**
	 * 新增临时素材
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token access_token
	 * @param mediaType mediaType
	 * @param media  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @return Media
	 */
	public static Media mediaUpload(String access_token,MediaType mediaType,File media){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/upload");
		FileBody bin = new FileBody(media);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		 .addPart("media", bin)
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .addTextBody("type",mediaType.uploadType())
                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,Media.class);
	}

	/**
	 * 新增临时素材
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token access_token
	 * @param mediaType mediaType
	 * @param inputStream  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @return Media
	 */
	public static Media mediaUpload(String access_token,MediaType mediaType,InputStream inputStream){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/upload");
		byte[] data = null;
		try {
			data = StreamUtils.copyToByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				 .addBinaryBody("media",data,ContentType.DEFAULT_BINARY,"temp."+mediaType.fileSuffix())
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .addTextBody("type",mediaType.uploadType())
                 .build();
		httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,Media.class);
	}


	/**
	 * 新增临时素材
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token access_token
	 * @param mediaType access_token
	 * @param uri  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @return Media
	 */
	public static Media mediaUpload(String access_token,MediaType mediaType,URI uri){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/upload");
		CloseableHttpClient tempHttpClient = HttpClients.createDefault();
		try {
			HttpEntity entity = tempHttpClient.execute(RequestBuilder.get().setUri(uri).build()).getEntity();
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					 .addBinaryBody("media",EntityUtils.toByteArray(entity),ContentType.get(entity),"temp."+mediaType.fileSuffix())
			         .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
			         .addTextBody("type",mediaType.uploadType())
			         .build();
			httpPost.setEntity(reqEntity);
			return LocalHttpClient.executeJsonResult(httpPost,Media.class);
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				tempHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 获取临时素材
	 * @since 2.8.0
	 * @param access_token access_token
	 * @param media_id media_id
	 * @param use_http 视频素材使用[http] true,其它使用[https] false.
	 * @return MediaGetResult
	 */
	public static MediaGetResult mediaGet(String access_token,String media_id,boolean use_http){
		String http_s = use_http?BASE_URI.replace("https", "http"):BASE_URI;
		HttpUriRequest httpUriRequest = RequestBuilder.get()
					.setUri(http_s + "/cgi-bin/media/get")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.addParameter("media_id", media_id)
					.build();
		return LocalHttpClient.execute(httpUriRequest,BytesOrJsonResponseHandler.createResponseHandler(MediaGetResult.class));
	}
	
	/**
	 * 获取临时素材
	 * @since 2.8.0
	 * @param access_token access_token
	 * @param media_id media_id
	 * @return MediaGetResult
	 */
	public static MediaGetResult mediaGet(String access_token,String media_id){
		return mediaGet(access_token, media_id, false);
	}

	/**
	 * 上传图文消息内的图片获取URL
	 * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param access_token access_token
	 * @param media media
	 * @return UploadimgResult
	 */
	public static UploadimgResult mediaUploadimg(String access_token,File media){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/uploadimg");
		FileBody bin = new FileBody(media);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		 .addPart("media", bin)
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,UploadimgResult.class);
	}

	/**
	 * 上传图文消息内的图片获取URL
	 * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param access_token access_token
	 * @param inputStream inputStream
	 * @return UploadimgResult
	 */
	public static UploadimgResult mediaUploadimg(String access_token,InputStream inputStream){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/uploadimg");
		//InputStreamBody inputStreamBody =  new InputStreamBody(inputStream, ContentType.DEFAULT_BINARY, UUID.randomUUID().toString()+".jpg");
		byte[] data = null;
		try {
			data = StreamUtils.copyToByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				 .addBinaryBody("media",data,ContentType.DEFAULT_BINARY,"temp.jpg")
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,UploadimgResult.class);
	}


	/**
	 * 上传图文消息内的图片获取URL
	 * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param access_token access_token
	 * @param uri uri
	 * @return UploadimgResult
	 */
	public static UploadimgResult mediaUploadimg(String access_token,URI uri){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/media/uploadimg");
		CloseableHttpClient tempHttpClient = HttpClients.createDefault();
		try {
			HttpEntity entity = tempHttpClient.execute(RequestBuilder.get().setUri(uri).build()).getEntity();
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					 .addBinaryBody("media",EntityUtils.toByteArray(entity),ContentType.get(entity),UUID.randomUUID().toString()+".jpg")
			         .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
			         .build();
			httpPost.setEntity(reqEntity);
			return LocalHttpClient.executeJsonResult(httpPost,UploadimgResult.class);
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				tempHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
