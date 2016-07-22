package weixin.popular.bean.card.putin;

import weixin.popular.bean.BaseResult;

/**
 * 投放卡券－图文消息群发卡券－响应对象
 * 
 * @author Moyq5
 *
 */
public class MpnewsResult extends BaseResult {

	/**
	 * 返回一段html代码，可以直接嵌入到图文消息的正文里。<br>
	 * 即可以把这段代码嵌入到上传图文消息素材接口中的content字段里。
	 */
	private String content;

	/**
	 * 返回一段html代码，可以直接嵌入到图文消息的正文里。<br>
	 * 即可以把这段代码嵌入到上传图文消息素材接口中的content字段里。
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 返回一段html代码，可以直接嵌入到图文消息的正文里。<br>
	 * 即可以把这段代码嵌入到上传图文消息素材接口中的content字段里。
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
