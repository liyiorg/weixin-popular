package weixin.popular.bean.user;

import weixin.popular.bean.BaseResult;

public class TagsGetidlistResult extends BaseResult{

	private Integer[] tagid_list;

	public Integer[] getTagid_list() {
		return tagid_list;
	}

	public void setTagid_list(Integer[] tagid_list) {
		this.tagid_list = tagid_list;
	}
	
}
