package weixin.popular.bean.message.message;

public class ImageMessage extends Message {

	public ImageMessage(String touser,String mediaId) {
		super(touser,"image");
		this.image = new Image();
		this.image.setMedia_id(mediaId);
	}

	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public static class Image {
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String mediaId) {
			media_id = mediaId;
		}

	}
}
