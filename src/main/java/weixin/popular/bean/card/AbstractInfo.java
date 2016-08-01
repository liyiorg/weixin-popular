package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券信息抽象类，具体卡券的公共信息对象
 * 
 * @author Moyq5
 *
 */
public abstract class AbstractInfo {

	/**
	 * 基本信息
	 */
	@JSONField(name = "base_info")
	private BaseInfo baseInfo;

	/**
	 * 高级信息<br>
	 * 不支持修改 
	 */
	@JSONField(name = "advanced_info")
	private AdvancedInfo advancedInfo;

	/**
	 * 基本信息
	 */
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	/**
	 * 基本信息
	 */
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	/**
	 * 高级信息
	 */
	public AdvancedInfo getAdvancedInfo() {
		return advancedInfo;
	}

	/**
	 * 高级信息
	 * 不支持修改
	 */
	public void setAdvancedInfo(AdvancedInfo advancedInfo) {
		this.advancedInfo = advancedInfo;
	}
}
