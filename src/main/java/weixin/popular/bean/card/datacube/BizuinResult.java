package weixin.popular.bean.card.datacube;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 拉取卡券概况数据接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class BizuinResult extends BaseResult {

	/**
	 * 记录列表
	 */
	List<BizuinInfo> list;

	public List<BizuinInfo> getList() {
		return list;
	}

	public void setList(List<BizuinInfo> list) {
		this.list = list;
	}
}
