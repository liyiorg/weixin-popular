/**
 * 
 */
package weixin.popular.bean.shakearound.material.add;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－素材管理－​上传图片素材－响应参数－图片信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class MaterialAddResultData {

	/**
	 * 图片url地址，<br>
	 * 若type=icon，可用在“新增页面”和“编辑页面”的“icon_url”字段；<br>
	 * 若type= license，可用在“申请入驻”的“qualification_cert_urls”字段
	 */
	@JSONField(name = "pic_url")
	private String picUrl;

	/**
	 * 图片url地址，<br>
	 * 若type=icon，可用在“新增页面”和“编辑页面”的“icon_url”字段；<br>
	 * 若type= license，可用在“申请入驻”的“qualification_cert_urls”字段
	 * @return 图片url地址
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * 图片url地址，<br>
	 * 若type=icon，可用在“新增页面”和“编辑页面”的“icon_url”字段；<br>
	 * 若type= license，可用在“申请入驻”的“qualification_cert_urls”字段
	 * @param picUrl 图片url地址
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
