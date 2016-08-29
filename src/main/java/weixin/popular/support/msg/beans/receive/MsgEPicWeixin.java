package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * pic_weixin：弹出微信相册发图器的事件推送
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEPicWeixin extends MsgEPicPhotoOrAlbum {

}
