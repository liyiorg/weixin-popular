package weixin.popular.bean.message.message;

import java.util.List;

/**
 * 菜单消息
 * 
 * @since 2.8.26
 * @author LiYi
 */
public class MsgmenuMessage extends Message {

	public MsgmenuMessage() {
	}

	public MsgmenuMessage(String touser, Msgmenu msgmenu) {
		super(touser, "msgmenu");
		this.msgmenu = msgmenu;
	}

	private Msgmenu msgmenu;

	public Msgmenu getMsgmenu() {
		return msgmenu;
	}

	public void setMsgmenu(Msgmenu msgmenu) {
		this.msgmenu = msgmenu;
	}

	public static class Msgmenu {

		private String head_content;

		private String tail_content;

		private List<MenuOption> list;

		public String getHead_content() {
			return head_content;
		}

		public void setHead_content(String head_content) {
			this.head_content = head_content;
		}

		public String getTail_content() {
			return tail_content;
		}

		public void setTail_content(String tail_content) {
			this.tail_content = tail_content;
		}

		public List<MenuOption> getList() {
			return list;
		}

		public void setList(List<MenuOption> list) {
			this.list = list;
		}

	}

	public static class MenuOption {
		private String id;
		private String content;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}
}
