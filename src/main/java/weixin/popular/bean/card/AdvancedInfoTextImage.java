package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图文列表
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfoTextImage {

	/**
	 * 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错 <br>
	 * 添加必填，长度：128
	 */
	@JSONField(name = "image_url")
	private String imageUrl;

	/**
	 * 图文描述 <br>
	 * 添加必填，长度：512
	 */
	private String text;

	/**
	 * 图片链接 
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错 <br>
	 * 添加必填，长度：128
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * 图文描述 
	 */
	public String getText() {
		return text;
	}

	/**
	 * 图文描述 <br>
	 * 添加必填，长度：512
	 */
	public void setText(String text) {
		this.text = text;
	}
}
