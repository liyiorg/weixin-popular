package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 封面摘要结构体名称
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfoAbstract {

	/**
	 * 封面摘要简介。<br>
	 * 添加必填，长度：24
	 */
	@JSONField(name = "abstract")
	private String abstractText;

	/**
	 * 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，<br>
	 * 填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350 <br>
	 * 添加必填，长度：128
	 */
	@JSONField(name = "icon_url_list")
	private String[] iconUrlList;

	/**
	 * 封面摘要简介。
	 */
	public String getAbstractText() {
		return abstractText;
	}

	/**
	 * 封面摘要简介。<br>
	 * 添加必填，长度：24
	 */
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	/**
	 * 封面图片列表。
	 */
	public String[] getIconUrlList() {
		return iconUrlList;
	}

	/**
	 * 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，<br>
	 * 填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350 <br>
	 * 添加必填，长度：128
	 */
	public void setIconUrlList(String[] iconUrlList) {
		this.iconUrlList = iconUrlList;
	}
}
