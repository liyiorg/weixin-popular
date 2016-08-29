package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * pic_sysphoto：弹出系统拍照发图的事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEPicSysphoto extends MsgEPicPhotoOrAlbum {

}
