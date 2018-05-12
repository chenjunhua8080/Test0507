package com.example.demo.message;

import java.util.Map;


import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;


public class MessageUtil {
	
	/**
     * 根据消息类型构造返回消息
     * @param map 封装了解析结果的Map
     * @return responseMessage(响应消息)
     */
    public static String build(Map<String, Object> map) {
        //响应消息
        String responseMessage = "";
        //得到消息类型
        String msgType = map.get("MsgType").toString().toUpperCase();
        //消息类型
        switch (msgType) {
            case MessageType.text:
                //处理文本消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.image:
                //处理图片消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.voice:
                //处理语音消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.video:
                //处理视频消息
                responseMessage = buildTextMessage(map);
                break;
            case MessageType.short_video:
                //处理小视频消息
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
        //返回响应消息
        return responseMessage;
    }

	/**
     * 构造文本消息
     * @param map 封装了解析结果的Map
     * @param content 文本消息内容
     * @return 文本消息XML字符串
     */
    private static String buildTextMessage(Map<String, Object> map,boolean no) {
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
        return String.format(
                "<xml>" +
                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
                        "<CreateTime>%s</CreateTime>" +
                        "<MsgType><![CDATA[text]]></MsgType>" +
                        "<Content><![CDATA[%s]]></Content>" +
                        "</xml>",
                fromUserName, toUserName, map.get("CreateTime"), map.get("MsgType")+",有空常来啊!");
    }
    
    private static String buildTextMessage(Map<String, Object> map) {
		return pageData(map);
	}
    
    private static String pageData(Map<String, Object> map) {
    	JSONObject json=JSONObject.fromObject(map);
    	XMLSerializer xmlSerializer = new XMLSerializer();
    	String xml = xmlSerializer.write(json);
		return xml;
	}
    

}
