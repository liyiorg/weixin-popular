package weixin.popular.bean.message;

/**
 * 视频
 * 
 * @author LiYi
 * 
 */
public class VideoMessage extends Message {

	public VideoMessage(String touser) {
		super(touser,"video");
	}

	public Video video;

	

	public Video getVideo() {
		return video;
	}



	public void setVideo(Video video) {
		this.video = video;
	}



	public static class Video {
		private String media_id;
		private String title;
		private String description;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String mediaId) {
			media_id = mediaId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
