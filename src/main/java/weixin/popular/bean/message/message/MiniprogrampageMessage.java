package weixin.popular.bean.message.message;

/**
 * 小程序卡片
 * 
 * @serial 2.8.26
 * @author LiYi
 *
 */
public class MiniprogrampageMessage extends Message {

	public MiniprogrampageMessage() {
	}

	public MiniprogrampageMessage(String touser) {
		super(touser, "miniprogrampage");
	}

	public MiniprogrampageMessage(String touser, Miniprogrampage miniprogrampage) {
		this(touser);
		this.miniprogrampage = miniprogrampage;
	}

	private Miniprogrampage miniprogrampage;

	public Miniprogrampage getMiniprogrampage() {
		return miniprogrampage;
	}

	public void setMiniprogrampage(Miniprogrampage miniprogrampage) {
		this.miniprogrampage = miniprogrampage;
	}

	public static class Miniprogrampage {

		private String title;
		private String pagepath;
		private String thumb_media_id;
		private String appid;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPagepath() {
			return pagepath;
		}

		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}

		public String getAppid() {
			return appid;
		}

		public void setAppid(String appid) {
			this.appid = appid;
		}

	}
}
