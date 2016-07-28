package weixin.popular.bean.datacube.getcardbizuininfo;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 拉取卡券概况数据接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class BizuinInfoResult extends BaseResult {

	/**
	 * 记录列表
	 */
	List<BizuinInfoResultInfo> list;

	public List<BizuinInfoResultInfo> getList() {
		return list;
	}

	public void setList(List<BizuinInfoResultInfo> list) {
		this.list = list;
	}
}
