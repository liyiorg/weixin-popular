package weixin.popular.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.material.Description;
import weixin.popular.bean.material.MaterialBatchgetResult;
import weixin.popular.bean.material.MaterialGetResult;
import weixin.popular.bean.material.MaterialcountResult;
import weixin.popular.bean.media.Media;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.message.Article;
import weixin.popular.client.BytesOrJsonResponseHandler;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.StreamUtils;

/**
 * 永久素材
 * @author LiYi
 *
 */
public class MaterialAPI extends BaseAPI{

	/**
	 * 新增永久图文素材
	 * @param access_token access_token
	 * @param articles articles
	 * @return Media
	 */
	public static Media add_news(String access_token,List<Article> articles){
		String str = JsonUtil.toJSONString(articles);
		String messageJson = "{\"articles\":"+str+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/material/add_news")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Media.class);
	}


	/**
	 * 新增其他类型永久素材
	 * @param access_token access_token
	 * @param mediaType mediaType
	 * @param media  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：5M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @param description 视频文件类型额外字段，其它类型不用添加
	 * @return Media
	 */
	public static Media add_material(String access_token,MediaType mediaType,File media,Description description){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/material/add_material");
		FileBody bin = new FileBody(media);
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
        		 			.addPart("media", bin);
        if(description != null){
        	multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description),ContentType.create("text/plain",Charset.forName("utf-8")));
        }
        HttpEntity reqEntity = multipartEntityBuilder.addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
			                 .addTextBody("type",mediaType.uploadType())
			                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,Media.class);
	}

	/**
	 * 新增其他类型永久素材
	 * @param access_token access_token
	 * @param mediaType mediaType
	 * @param inputStream  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：5M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @param description 视频文件类型额外字段，其它类型不用添加
	 * @return Media
	 */
	public static Media add_material(String access_token,MediaType mediaType,InputStream inputStream,Description description){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/material/add_material");
		byte[] data = null;
		try {
			data = StreamUtils.copyToByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
        		.addBinaryBody("media",data,ContentType.DEFAULT_BINARY,"temp."+mediaType.fileSuffix());
		if(description != null){
			multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description),ContentType.create("text/plain",Charset.forName("utf-8")));
		}
		HttpEntity reqEntity = multipartEntityBuilder.addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
		                 .addTextBody("type",mediaType.uploadType())
		                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,Media.class);
	}


	/**
	 * 新增其他类型永久素材
	 * @param access_token access_token
	 * @param mediaType mediaType
	 * @param uri  	多媒体文件有格式和大小限制，如下：
						图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
						语音（voice）：5M，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：10MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @param description 视频文件类型额外字段，其它类型不用添加
	 * @return Media
	 */
	public static Media add_material(String access_token,MediaType mediaType,URI uri,Description description){
		HttpPost httpPost = new HttpPost(BASE_URI+"/cgi-bin/material/add_material");
		CloseableHttpClient tempHttpClient = HttpClients.createDefault();
		try {
			HttpEntity entity = tempHttpClient.execute(RequestBuilder.get().setUri(uri).build()).getEntity();
			 MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
					 .addBinaryBody("media",EntityUtils.toByteArray(entity),ContentType.get(entity),"temp."+mediaType.fileSuffix());
			 if(description != null){
				multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description),ContentType.create("text/plain",Charset.forName("utf-8")));
			 }
			 HttpEntity reqEntity = multipartEntityBuilder.addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
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
	 * 获取永久素材
	 * @param access_token access_token
	 * @param media_id media_id
	 * @return MaterialGetResult
	 */
	public static MaterialGetResult get_material(String access_token,String media_id){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setHeader(jsonHeader)
					.setUri(BASE_URI+"/cgi-bin/material/get_material")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.setEntity(new StringEntity("{\"media_id\":\""+media_id+"\"}",Charset.forName("utf-8")))
					.build();
		return LocalHttpClient.execute(httpUriRequest,BytesOrJsonResponseHandler.createResponseHandler(MaterialGetResult.class));
	}


	/**
	 * 删除永久素材
	 * @param access_token access_token
	 * @param media_id media_id
	 * @return BaseResult
	 */
	public static BaseResult del_material(String access_token,String media_id){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setHeader(jsonHeader)
					.setUri(BASE_URI+"/cgi-bin/material/del_material")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.setEntity(new StringEntity("{\"media_id\":\""+media_id+"\"}",Charset.forName("utf-8")))
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 修改永久图文素材
	 * @param access_token access_token
	 * @param media_id 	要修改的图文消息的id
	 * @param index 	要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	 * @param articles articles
	 * @return BaseResult
	 */
	public static BaseResult update_news(String access_token,String media_id,int index,List<Article> articles){
		String str = JsonUtil.toJSONString(articles);
		String messageJson = "{\"media_id\":\""+media_id+"\",\"index\":"+index+",\"articles\":"+str+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/material/update_news")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(messageJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}


	/**
	 * 获取素材总数
	 * @param access_token access_token
	 * @return MaterialcountResult
	 */
	public static MaterialcountResult get_materialcount(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setUri(BASE_URI+"/cgi-bin/material/get_materialcount")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MaterialcountResult.class);
	}


	/**
	 * 获取素材列表
	 * @param access_token access_token
	 * @param type		素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset	从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count		返回素材的数量，取值在1到20之间
	 * @return MaterialBatchgetResult
	 */
	public static MaterialBatchgetResult batchget_material(String access_token,String type,int offset,int count){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setHeader(jsonHeader)
					.setUri(BASE_URI+"/cgi-bin/material/batchget_material")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.setEntity(new StringEntity("{\"type\":\""+type+"\",\"offset\":"+offset+",\"count\":"+count+"}",Charset.forName("utf-8")))
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MaterialBatchgetResult.class);
	}

}
