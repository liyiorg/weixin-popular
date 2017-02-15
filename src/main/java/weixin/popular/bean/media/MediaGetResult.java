package weixin.popular.bean.media;

import weixin.popular.bean.BaseResult;

public class MediaGetResult extends BaseResult{

	private String filename;
	
	private String contentType;
	
	private byte[] bytes;
	
	private String video_url;	//如果返回的是视频消息素材

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	
}
