package weixin.popular.bean.comment;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class CommentListResult extends BaseResult {

	private Long total;

	List<Comment> comment;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}
