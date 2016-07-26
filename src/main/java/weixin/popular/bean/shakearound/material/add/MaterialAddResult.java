/**
 * 
 */
package weixin.popular.bean.shakearound.material.add;

/**
 * 微信摇一摇周边－素材管理－​上传图片素材－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class MaterialAddResult {

	/**
	 * 图片信息
	 */
	private MaterialAddResultData data;

	/**
	 * @return 图片信息
	 */
	public MaterialAddResultData getData() {
		return data;
	}

	/**
	 * @param data 图片信息
	 */
	public void setData(MaterialAddResultData data) {
		this.data = data;
	}
}
