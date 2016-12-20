package weixin.popular.bean.message.message;

/**
 * 发送卡券
 * @author SLYH
 *
 */
public class WxcardMessage extends Message {

	public WxcardMessage(String touser) {
		super(touser, "wxcard");
	}

	public WxcardMessage(String touser, String card_id) {
		this(touser);
		this.wxcard = new Wxcard();
		this.wxcard.setCard_id(card_id);
	}

	private Wxcard wxcard;

	public Wxcard getWxcard() {
		return wxcard;
	}

	public void setWxcard(Wxcard wxcard) {
		this.wxcard = wxcard;
	}

	public static class Wxcard {

		private String card_id;

		public String getCard_id() {
			return card_id;
		}

		public void setCard_id(String card_id) {
			this.card_id = card_id;
		}

	}
}
