package weixin.popular.bean.datacube.getcardcardinfo;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 获取免费券数据接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class CardInfoResult extends BaseResult {

	/**
	 * 数据列表
	 */
	List<CardInfoResultInfo> list;

	public List<CardInfoResultInfo> getList() {
		return list;
	}

	public void setList(List<CardInfoResultInfo> list) {
		this.list = list;
	}
}
