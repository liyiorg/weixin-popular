// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ReplyBuilder.java

package weixin.popular.bean.xmlmessage;

import weixin.popular.bean.message.EventMessage;

import java.util.List;

/**
 * Created by foquanlin@163.com on 2018-02-01.
 */
public class XMLMessageBuilder {

    public XMLImageMessage builderImageReply(String toUserName, String fromUserName, String mediaId){
        XMLImageMessage reply = new XMLImageMessage(toUserName,fromUserName,mediaId);
        return reply;
    }

    public XMLMusicMessage builderMusicReply(String toUserName, String fromUserName, String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId)
    {
        XMLMusicMessage reply = new XMLMusicMessage(toUserName,fromUserName,title,description,musicUrl,hQMusicUrl,thumbMediaId);
        return reply;
    }

    public XMLNewsMessage builderNewsReply(String toUserName, String fromUserName, List<XMLNewsMessage.Article> list){
        XMLNewsMessage reply = new XMLNewsMessage(toUserName,fromUserName,list);
        return reply;
    }

    public XMLTextMessage builderTextReply(String toUserName, String fromUserName, String content){
        XMLTextMessage reply = new XMLTextMessage(toUserName,fromUserName,content);
        return reply;
    }

    public XMLVideoMessage builderVideoReply(String toUserName, String fromUserName, String mediaId, String title, String description){
        XMLVideoMessage reply = new XMLVideoMessage(toUserName,fromUserName,mediaId,title,description);
        return reply;
    }

    public XMLVoiceMessage builderVoiceReply(String toUserName, String fromUserName, String mediaId){
        XMLVoiceMessage reply = new XMLVoiceMessage(toUserName,fromUserName,mediaId);
        return reply;
    }

    public XMLEmptyMessage newEmptyReply()
    {
        return new XMLEmptyMessage(null,null,null);
    }

    public XMLEmptyMessage builderEmptyReply(String toUserName, String fromUserName){
        XMLEmptyMessage reply = new XMLEmptyMessage(toUserName,fromUserName,null);
        return reply;
    }

    public XMLMessage newEmptyReply(EventMessage event){
        XMLEmptyMessage reply = new XMLEmptyMessage(event.getFromUserName(),event.getToUserName(),null);
        return reply;
    }
}
