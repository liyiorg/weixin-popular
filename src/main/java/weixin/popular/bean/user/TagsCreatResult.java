package weixin.popular.bean.user;

import weixin.popular.bean.BaseResult;

/**
 * 标签
 * 
 * @author SLYH
 * 
 */
public class TagsCreatResult extends BaseResult {

	private Tag tag;

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
