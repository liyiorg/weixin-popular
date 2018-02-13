package weixin.popular.bean.wxa;

public class LineColor {

	private String r;
	private String g;
	private String b;

	public LineColor() {
	}

	public LineColor(String r, String g, String b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public static LineColor newLineColor(String r,String g,String b){
		return new LineColor(r,g,b);
	}
}
