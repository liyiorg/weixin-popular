package weixin.popular.bean.comment;

public class Comment {

	private Long user_comment_id;

	private String openid;

	private String create_time;

	private String content;

	private Integer comment_type;

	private Reply reply;

	public Long getUser_comment_id() {
		return user_comment_id;
	}

	public void setUser_comment_id(Long user_comment_id) {
		this.user_comment_id = user_comment_id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getComment_type() {
		return comment_type;
	}

	public void setComment_type(Integer comment_type) {
		this.comment_type = comment_type;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

}
