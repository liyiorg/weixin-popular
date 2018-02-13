package weixin.popular.bean.wxa;

public class Getwxacodeunlimit {

	private String scene;
	
	private Integer width;
	
	private Boolean auto_color;
	
	private LineColor line_color;
	
	private String page;

	public Getwxacodeunlimit() {
	}

	public Getwxacodeunlimit(String scene, Integer width, Boolean auto_color, LineColor line_color) {
		this.scene = scene;
		this.width = width;
		this.auto_color = auto_color;
		this.line_color = line_color;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Boolean getAuto_color() {
		return auto_color;
	}

	public void setAuto_color(Boolean auto_color) {
		this.auto_color = auto_color;
	}

	public LineColor getLine_color() {
		return line_color;
	}

	public void setLine_color(LineColor line_color) {
		this.line_color = line_color;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
