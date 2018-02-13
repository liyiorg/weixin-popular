package weixin.popular.bean.message;

/**
 * 高级群发接口  图文消息素材
 * @author LiYi
 *
 */
public class Article {

	private String title;

	private String thumb_media_id;//图文消息的封面图片素材id

	private String show_cover_pic;//是否显示封面，0为false，即不显示，1为true，即显示
	
	private String thumb_url;	//封面图片地址

	private String author;

	private String digest;//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空

	private String content;//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	
	private String url;	//图文页的URL(高级群发不可用外链)
	
	private String content_source_url; 	//图文消息的原文地址，即点击“阅读原文”后的URL
	
	private Integer need_open_comment;	//是否打开评论，0不打开，1打开
	
	private Integer only_fans_can_comment;	//是否粉丝才可评论，0所有人可评论，1粉丝才可评论

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent_source_url() {
		return content_source_url;
	}

	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	public Integer getNeed_open_comment() {
		return need_open_comment;
	}

	public void setNeed_open_comment(Integer need_open_comment) {
		this.need_open_comment = need_open_comment;
	}

	public Integer getOnly_fans_can_comment() {
		return only_fans_can_comment;
	}

	public void setOnly_fans_can_comment(Integer only_fans_can_comment) {
		this.only_fans_can_comment = only_fans_can_comment;
	}

	public String getThumb_url() {
		return thumb_url;
	}

	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}
	
}
