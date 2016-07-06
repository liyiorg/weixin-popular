package weixin.popular.bean.card.datacube;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 获取免费券数据接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class FreeCardResult extends BaseResult {

	/**
	 * 记录列表
	 */
	List<FreeCardInfo> list;

	public List<FreeCardInfo> getList() {
		return list;
	}

	public void setList(List<FreeCardInfo> list) {
		this.list = list;
	}
}
