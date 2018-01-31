package weixin.popular.bean.qrcode;

public class Wxaqrcode {

	private String path;

	private Integer width;

	public Wxaqrcode() {
	}

	public Wxaqrcode(String path, Integer width) {
		this.path = path;
		this.width = width;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

}
