package weixin.popular.api;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import weixin.popular.bean.Media;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MediaAPI extends BaseAPI{
	
	/**
	 * 上传媒体文件
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token
	 * @param mediaType
	 * @param resource
	 * @return
	 */
	private Media mediaUpload(String access_token,MediaType mediaType,Resource resource){
		MultiValueMap<String,Object> multiValueMap = new LinkedMultiValueMap<String, Object>();
		try {
			multiValueMap.add("media",resource);
			String type = mediaType.name();
			String  result = super.restTemplate.postForObject(MEDIA_URI + "/cgi-bin/media/upload?access_token={access_token}&type={type}",
											 multiValueMap,String.class,access_token,type);
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(result, Media.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 上传媒体文件
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token
	 * @param mediaType
	 * @param media  	多媒体文件有格式和大小限制，如下：
						图片（image）: 128K，支持JPG格式
						语音（voice）：256K，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：1MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @return
	 */
	public Media mediaUpload(String access_token,MediaType mediaType,File media){
		return mediaUpload(access_token,mediaType,new FileSystemResource(media));
	}
	
	/**
	 * 上传媒体文件
	 * 媒体文件在后台保存时间为3天，即3天后media_id失效。
	 * @param access_token
	 * @param mediaType
	 * @param uri  	多媒体文件有格式和大小限制，如下：
						图片（image）: 128K，支持JPG格式
						语音（voice）：256K，播放长度不超过60s，支持AMR\MP3格式
						视频（video）：1MB，支持MP4格式
						缩略图（thumb）：64KB，支持JPG格式
	 * @return
	 */
	public Media mediaUpload(String access_token,MediaType mediaType,URI uri){
		try {
			return mediaUpload(access_token,mediaType,new UrlResource(uri));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 下载多媒体
	 * 视频文件不支持下载
	 * @param access_token
	 * @param media_id
	 * @return
	 */
	public ResponseEntity<ByteArrayResource> mediaGet(String access_token,String media_id){
		return super.restTemplate.postForEntity(MEDIA_URI + "/cgi-bin/media/get?access_token={access_token}&media_id={media_id}",
															null,
															ByteArrayResource.class,
															access_token,media_id);
	}
	
	
	public enum MediaType{
		image,voice,video,thumb
	}
	
	
	
}
