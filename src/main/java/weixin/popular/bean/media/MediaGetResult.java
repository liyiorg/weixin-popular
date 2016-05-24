package weixin.popular.bean.media;

import weixin.popular.bean.BaseResult;

public class MediaGetResult extends BaseResult{

	private String filename;
	
	private String contentType;
	
	private byte[] bytes;

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
	
}
