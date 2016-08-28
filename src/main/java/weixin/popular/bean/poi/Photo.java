package weixin.popular.bean.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 门店图片信息
 * 
 * @author Moyq5
 *
 */
public class Photo {

	@JsonProperty("photo_url")
	private String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
