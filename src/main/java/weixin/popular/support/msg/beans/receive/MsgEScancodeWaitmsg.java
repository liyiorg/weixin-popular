package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEScancodeWaitmsg extends MsgEScancodePush {

}
