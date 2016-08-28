package weixin.popular.bean.qrcode.create;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 生成带参数二维码－请求参数－二维码场景信息
 * @author Moyq5
 * @date 2016年8月26日
 */
public class Scene {

	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	@JsonProperty("scene_id")
	private Integer sceneId;
	
	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 */
	@JsonProperty("scene_str")
	private String sceneStr;

	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return 场景值ID
	 */
	public Integer getSceneId() {
		return sceneId;
	}

	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param sceneId 场景值ID
	 */
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 * @return 场景值ID
	 */
	public String getSceneStr() {
		return sceneStr;
	}

	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 * @param sceneStr 场景值ID
	 */
	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}
}
