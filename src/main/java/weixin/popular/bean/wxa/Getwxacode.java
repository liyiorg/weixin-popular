package weixin.popular.bean.wxa;

public class Getwxacode {

	private String path;
	
	private Integer width;
	
	private Boolean auto_color;
	
	private LineColor line_color;

	public Getwxacode() {
	}

	public Getwxacode(String path, Integer width, Boolean auto_color, LineColor line_color) {
		this.path = path;
		this.width = width;
		this.auto_color = auto_color;
		this.line_color = line_color;
	}

	public String getPath() {
		return path;
	}

	public void setScene(String path) {
		this.path = path;
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
	
	
}
