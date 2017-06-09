package weixin.popular.bean.comment;

public class CommentList {

	private Long msg_data_id; // 群发返回的msg_data_id

	private Integer index; // 多图文时，用来指定第几篇图文，从0开始，不带默认返回该msg_data_id的第一篇图文

	private Integer begin; // 起始位置

	private Integer count; // 获取数目（>=50会被拒绝）

	private Integer type; // type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论

	public Long getMsg_data_id() {
		return msg_data_id;
	}

	public void setMsg_data_id(Long msg_data_id) {
		this.msg_data_id = msg_data_id;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
