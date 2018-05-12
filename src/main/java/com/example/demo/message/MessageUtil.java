package com.example.demo.message;

import java.util.Date;
import java.util.Map;

import com.example.demo.message.resp.Image;
import com.example.demo.message.resp.ImageMessage;
import com.example.demo.message.resp.Message;
import com.example.demo.message.resp.Music;
import com.example.demo.message.resp.MusicMessage;
import com.example.demo.message.resp.TextMessage;
import com.example.demo.message.resp.Video;
import com.example.demo.message.resp.VideoMessage;
import com.example.demo.message.resp.Voice;
import com.example.demo.message.resp.VoiceMessage;
import com.example.demo.xml.XmlUtil;

import net.sf.json.JSONObject;


public class MessageUtil {
	
	/**
     * 根据消息类型构造返回消息
     * @param map 封装了解析结果的Map
     * @return responseMessage(响应消息)
     */
    public static String build(Map<String, String> map) {
    	
    	System.err.println(map);
        //响应消息
        String responseMessage = "";
        
        Message message = new Message(map.get("FromUserName"),map.get("ToUserName"),new Date().getTime(),map.get("MsgType"));
        //消息类型
        switch (message.getMsgType().toUpperCase()) {
            case MessageType.text:
                //处理文本消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.image:
                //处理图片消息
                responseMessage = buildImageMessage(map);
                break;
            case MessageType.voice:
                //处理语音消息
                responseMessage = buildVoiceMessage(map);
                break;
            case MessageType.video:
                //处理视频消息
                responseMessage = buildVideoMessage(map);
                break;
            case MessageType.short_video:
                //处理小视频消息
            	map.put("Content", "我知道，这是一个小视频");
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.location:
                //处理位置消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.link:
                //处理链接消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.event:
                //处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消息
                responseMessage = buildTextMessage(map);
            default:
                break;
        }
        
        System.out.println(responseMessage);
        //返回响应消息
        return responseMessage;
    }

	/**
     * 构造文本消息
     * @param map 封装了解析结果的Map
     * @param content 文本消息内容
     * @return 文本消息XML字符串
     */
    private static String buildTextMessage(Map<String, String> map,boolean no) {
        //发送方帐号
        String fromUserName =map.get("FromUserName").toString();
        // 开发者微信号
        String toUserName =  map.get("ToUserName").toString();
        /**
         * 文本消息XML数据格式
         * <xml>
         <ToUserName><![CDATA[toUser]]></ToUserName>
         <FromUserName><![CDATA[fromUser]]></FromUserName>
         <CreateTime>1348831860</CreateTime>
         <MsgType><![CDATA[text]]></MsgType>
         <Content><![CDATA[this is a test]]></Content>
         <MsgId>1234567890123456</MsgId>
         </xml>
         */
        String resp=String.format(
                "<xml>" +
                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
                        "<CreateTime>%s</CreateTime>" +
                        "<MsgType><![CDATA[image]]></MsgType>" +
                        "<Image><MediaId><![CDATA[%s]]></MediaId></Image>" +
                        "</xml>",
                fromUserName, toUserName, map.get("CreateTime"), map.get("MediaId"));
        System.out.println(resp);
        return resp;
    }
    
    private static String buildTextMessage(Map<String, String> map) {
    	TextMessage textMessage = new TextMessage();
    	textMessage.setFromUserName(map.get("ToUserName"));
    	textMessage.setToUserName(map.get("FromUserName"));
    	textMessage.setMsgType(map.get("MsgType"));
    	textMessage.setCreateTime(new Date().getTime());
    	textMessage.setContent(map.get("Content"));
    	
    	return XmlUtil.messageToXml(textMessage);
	}
    
    private static String buildImageMessage(Map<String, String> map) {
    	ImageMessage imageMessage = new ImageMessage();
    	imageMessage.setFromUserName(map.get("ToUserName"));
    	imageMessage.setToUserName(map.get("FromUserName"));
    	imageMessage.setMsgType(map.get("MsgType"));
    	imageMessage.setCreateTime(new Date().getTime());
    	Image image=new Image(map.get("MediaId"));
    	imageMessage.setImage(image);
    	
    	return XmlUtil.messageToXml(imageMessage);
	}
    
    private static String buildVoiceMessage(Map<String, String> map) {
    	VoiceMessage voiceMessage = new VoiceMessage();
    	voiceMessage.setFromUserName(map.get("ToUserName"));
    	voiceMessage.setToUserName(map.get("FromUserName"));
    	voiceMessage.setMsgType(map.get("MsgType"));
    	voiceMessage.setCreateTime(new Date().getTime());
    	Voice voice=new Voice(map.get("MediaId"));
		voiceMessage.setVoice(voice); 
    	
		return XmlUtil.messageToXml(voiceMessage);
	}
    
    private static String buildVideoMessage(Map<String, String> map) {
    	VideoMessage videoMessage = new VideoMessage();
    	videoMessage.setFromUserName(map.get("ToUserName"));
    	videoMessage.setToUserName(map.get("FromUserName"));
    	videoMessage.setMsgType(map.get("MsgType"));
    	videoMessage.setCreateTime(new Date().getTime());
    	Video video=new Video(map.get("MediaId"),"你的视频","这是一个被动回复的视频消息");
    	videoMessage.setVideo(video); 
    	
		return XmlUtil.messageToXml(videoMessage);
	}
    
    private static String buildMusicMessage(Map<String, String> map) {
    	MusicMessage musicMessage = new MusicMessage();
    	musicMessage.setFromUserName(map.get("ToUserName"));
    	musicMessage.setToUserName(map.get("FromUserName"));
    	musicMessage.setMsgType(map.get("MsgType"));
    	musicMessage.setCreateTime(new Date().getTime());
    	Music music=new Music(map.get("MediaId"),"你的视频","这是一个被动回复的视频消息","url","Qurl");
    	musicMessage.setMusic(music);
    	
		return XmlUtil.messageToXml(musicMessage);
	}

    

}
