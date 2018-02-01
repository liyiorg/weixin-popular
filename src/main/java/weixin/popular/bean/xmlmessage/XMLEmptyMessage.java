package weixin.popular.bean.xmlmessage;

import weixin.popular.bean.message.message.Message;
import weixin.popular.bean.message.message.TextMessage;

/**
 * Created by fang on 2017-11-01.
 */
public class XMLEmptyMessage extends XMLMessage {
    protected XMLEmptyMessage(String toUserName, String fromUserName, String msgType) {
        super(toUserName, fromUserName, msgType);
    }

    @Override
    public String subXML() {
        return "";
    }

    @Override
    public Message convert() {
        return new TextMessage(toUserName,"");
    }
}
