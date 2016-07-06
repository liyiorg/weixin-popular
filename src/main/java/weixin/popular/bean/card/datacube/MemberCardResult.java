package weixin.popular.bean.card.datacube;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 拉取会员卡数据接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class MemberCardResult extends BaseResult {

	List<MemberCardInfo> list;

	public List<MemberCardInfo> getList() {
		return list;
	}

	public void setList(List<MemberCardInfo> list) {
		this.list = list;
	}
}
