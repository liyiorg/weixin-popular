package weixin.popular.bean.message.message;


public class TextMessage extends Message {

	public TextMessage(String touser) {
		super(touser,"text");
	}

	public TextMessage(String touser,String content){
		this(touser);
		this.text = new Text();
		this.text.setContent(content);
	}
	
	private Text text;

	public Text getText() {
		return text;
	}
	
	public void setText(Text text) {
		this.text = text;
	}

	public static class Text {
		
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
