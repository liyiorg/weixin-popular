package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * 卡券－从卡券进入公众号会话事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEUserEnterSessionFromCard extends MsgECardCode {
}
