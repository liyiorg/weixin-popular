package weixin.popular.bean.comment;

public class ReplyAdd extends Params {

	private String content;

	public ReplyAdd() {
	}

	public ReplyAdd(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
