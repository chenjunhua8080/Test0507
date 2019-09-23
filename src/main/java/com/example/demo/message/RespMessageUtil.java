package com.example.demo.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.RespMessageDao;
import com.example.demo.message.resp.Image;
import com.example.demo.message.resp.ImageMessage;
import com.example.demo.message.resp.Message;
import com.example.demo.message.resp.Music;
import com.example.demo.message.resp.MusicMessage;
import com.example.demo.message.resp.NewsItem;
import com.example.demo.message.resp.NewsMessage;
import com.example.demo.message.resp.TextMessage;
import com.example.demo.message.resp.Video;
import com.example.demo.message.resp.VideoMessage;
import com.example.demo.message.resp.Voice;
import com.example.demo.message.resp.VoiceMessage;
import com.example.demo.xml.XmlUtil;

import net.sf.json.JSONObject;

@Component
public class RespMessageUtil {

	private static RespMessageDao dao;

	@Autowired
	public void setDao(RespMessageDao dao) {
		this.dao = dao;
	}

	/**
	 * 根据消息类型构造返回消息
	 * 
	 * @param jsonObject
	 *            封装了解析结果的Map
	 * @return responseMessage(响应消息)
	 */
	public static String build(JSONObject jsonObject) {

		System.err.println(jsonObject);
		// 响应消息
		String responseMessage = "";

		// 消息类型
		switch (jsonObject.getString("MsgType").toUpperCase()) {
		case MessageType.text:
			// 处理文本消息
			String content = jsonObject.getString("Content");
			if (content.equals("音乐")) {
				jsonObject.put("MediaId", "XpQb51VpjzgrOnE-J0VimZDUVDcJ_G6PWTnG_XgBbm8YCmywNBCVqqAVISQww7oL");
				jsonObject.put("MsgType", "music");
				responseMessage = buildMusicMessage(jsonObject);
			} else if (content.equals("视频")) {
				jsonObject.put("ThumbMediaId", "XpQb51VpjzgrOnE-J0VimZDUVDcJ_G6PWTnG_XgBbm8YCmywNBCVqqAVISQww7oL");
				jsonObject.put("MediaId", "gAKP3zB8o7Fn9o_i5x311KVLWquDFWFLlRieNrIwgadkScN765VrqEXGXQV72TGz");
				jsonObject.put("MsgType", "video");
				responseMessage = buildVideoMessage(jsonObject);
			} else if (content.equals("语音")) {
				jsonObject.put("MediaId", "L1KyolEv_z8HXG5IUIeJWvDbrGAKitI26U8oYPc1U2c");
				jsonObject.put("MsgType", "voice");
				responseMessage = buildVoiceMessage(jsonObject);
			} else if (content.equals("易烊千玺")) {
				jsonObject.put("Url", "https://www.weibo.com/tfyiyangqianxi");
				jsonObject.put("PicUrl", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526570205756&di=b3966dd68d7a2da2ccef1de4d03860c1&imgtype=0&src=http%3A%2F%2Fuserpic.api.max.mgtv.com%2Fperson59783d7a40583.jpg%3F");
				jsonObject.put("t","进入易烊千玺的空间");
				jsonObject.put("d","看看小哥哥的日常...");
				jsonObject.put("MsgType", "news");
				responseMessage = buildNewsMessage(jsonObject);
			} else if (content.equals("满分作文")) {
				jsonObject.put("Url", "http://mp.weixin.qq.com/s?__biz=MzUxOTQ5MzgxNw==&mid=100000014&idx=1&sn=e1777ffc4b99cfe1f9aee81e109d5624&chksm=79f980d84e8e09cefdc97cc7e6df4792ae29c58a623d79ee3d1b8a50044053e284dee2d939c6#rd");
				jsonObject.put("PicUrl", "http://mmbiz.qpic.cn/mmbiz_gif/7jFEdSoRKZjrTMbGpjusZxbAovdqpK7YxO1Qiaoe40bCZia3DXuxREObRw3icpARF6RdZuav4LsGiajoEicAHv8FLHg/0?wx_fmt=gif");
				jsonObject.put("t","心里有光");
				jsonObject.put("d","2017全国卷Ⅱ高考满分作文");
				jsonObject.put("MsgType", "news");
				responseMessage = buildNewsMessage(jsonObject);
			} else {
				responseMessage = buildTextMessage(jsonObject);
			}
			break;
		case MessageType.image:
			// 处理图片消息
			responseMessage = buildImageMessage(jsonObject);
			break;
		case MessageType.voice:
			// 处理语音消息
			responseMessage = buildVoiceMessage(jsonObject);
			break;
		case MessageType.video:
			// 处理视频消息
			jsonObject.put("MediaId", "GqmIGpLu41rtwaY7WCVtJAL3ZbslzKiuLEXfWIKYDnHXGObH1CBH71xtgrGwyCa3");
			responseMessage = buildVideoMessage(jsonObject);
			break;
		case MessageType.short_video:
			// 处理小视频消息
			jsonObject.put("Content", "我知道，这是一个小视频");
			jsonObject.put("MsgType", "text");
			responseMessage = buildTextMessage(jsonObject);
			break;
		case MessageType.location:
			// 处理位置消息
			jsonObject.put("Content", "我知道，这是位置");
			jsonObject.put("MsgType", "text");
			responseMessage = buildTextMessage(jsonObject);
			break;
		case MessageType.link:
			// 处理链接消息
			jsonObject.put("Content", "我知道，这是链接");
			jsonObject.put("MsgType", "text");
			responseMessage = buildTextMessage(jsonObject);
			break;
		case MessageType.event:
			// 处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消息
			jsonObject.put("Content", "我知道，你操作了什么哦~");
			jsonObject.put("MsgType", "text");
			responseMessage = buildTextMessage(jsonObject);
		default:
			break;
		}

		System.out.println(responseMessage);
		// 返回响应消息
		return responseMessage;
	}

	/**
	 * 构造文本消息
	 * 
	 * @param map
	 *            封装了解析结果的Map
	 * @param content
	 *            文本消息内容
	 * @return 文本消息XML字符串
	 */
	private static String buildTextMessage(Map<String, String> map, boolean no) {
		// 发送方帐号
		String fromUserName = map.get("FromUserName").toString();
		// 开发者微信号
		String toUserName = map.get("ToUserName").toString();
		/**
		 * 文本消息XML数据格式 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
		 * <FromUserName><![CDATA[fromUser]]></FromUserName>
		 * <CreateTime>1348831860</CreateTime> <MsgType><![CDATA[text]]></MsgType>
		 * <Content><![CDATA[this is a test]]></Content> <MsgId>1234567890123456</MsgId>
		 * </xml>
		 */
		String resp = String.format(
				"<xml>" + "<ToUserName><![CDATA[%s]]></ToUserName>" + "<FromUserName><![CDATA[%s]]></FromUserName>"
						+ "<CreateTime>%s</CreateTime>" + "<MsgType><![CDATA[image]]></MsgType>"
						+ "<Image><MediaId><![CDATA[%s]]></MediaId></Image>" + "</xml>",
				fromUserName, toUserName, map.get("CreateTime"), map.get("MediaId"));
		System.out.println(resp);
		return resp;
	}

	private static String buildTextMessage(JSONObject json) {
		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName(json.getString("ToUserName"));
		textMessage.setToUserName(json.getString("FromUserName"));
		textMessage.setMsgType(json.getString("MsgType"));
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setContent(json.getString("Content"));
		textMessage.setMsgId(json.getString("MsgId"));
		dao.save(textMessage);
		return XmlUtil.messageToXml(textMessage);
	}

	private static String buildImageMessage(JSONObject json) {
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(json.getString("ToUserName"));
		imageMessage.setToUserName(json.getString("FromUserName"));
		imageMessage.setMsgType(json.getString("MsgType"));
		imageMessage.setCreateTime(new Date().getTime());
		Image image = new Image(json.getString("MediaId"));
		imageMessage.setImage(image);
		dao.save(imageMessage);
		return XmlUtil.messageToXml(imageMessage);
	}

	private static String buildVoiceMessage(JSONObject json) {
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage.setFromUserName(json.getString("ToUserName"));
		voiceMessage.setToUserName(json.getString("FromUserName"));
		voiceMessage.setMsgType(json.getString("MsgType"));
		voiceMessage.setCreateTime(new Date().getTime());
		Voice voice = new Voice(json.getString("MediaId"));
		voiceMessage.setVoice(voice);
		dao.save(voiceMessage);
		return XmlUtil.messageToXml(voiceMessage);
	}

	private static String buildVideoMessage(JSONObject json) {
		VideoMessage videoMessage = new VideoMessage();
		videoMessage.setFromUserName(json.getString("ToUserName"));
		videoMessage.setToUserName(json.getString("FromUserName"));
		videoMessage.setMsgType(json.getString("MsgType"));
		videoMessage.setCreateTime(new Date().getTime());
		Video video = new Video(json.getString("ThumbMediaId"),json.getString("MediaId"), "南校图书馆", "一片书声琅琅，同学们在认真读书...");
		videoMessage.setVideo(video);
		dao.save(videoMessage);
		return XmlUtil.messageToXml(videoMessage);
	}

	private static String buildMusicMessage(JSONObject json) {
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(json.getString("ToUserName"));
		musicMessage.setToUserName(json.getString("FromUserName"));
		musicMessage.setMsgType(json.getString("MsgType"));
		musicMessage.setCreateTime(new Date().getTime());
		Music music = new Music(json.getString("MediaId"), "最美的情侣", "来听一听抖音洗脑神曲",
				"http://mp3.qqmusic.cc/yq/212877015.mp3", "http://mp3.qqmusic.cc/yq/212877015.mp3");
		musicMessage.setMusic(music);
		dao.save(musicMessage);
		return XmlUtil.messageToXml(musicMessage);
	}

	private static String buildNewsMessage(JSONObject json) {
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setFromUserName(json.getString("ToUserName"));
		newsMessage.setToUserName(json.getString("FromUserName"));
		newsMessage.setMsgType(json.getString("MsgType"));
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setArticleCount(1);
		NewsItem item = new NewsItem(json.getString("Url"), json.getString("PicUrl"), json.getString("t"),json.getString("d"));
		List<NewsItem> items = new ArrayList<>();
		items.add(item);
		newsMessage.setArticles(items);
		//暂时撤销注解newsMessage，得不到正确的xml
		Message message=new Message();
		message.setFromUserName(json.getString("ToUserName"));
		message.setToUserName(json.getString("FromUserName"));
		message.setMsgType(json.getString("MsgType"));
		message.setCreateTime(new Date().getTime());
		dao.save(message);
		return XmlUtil.messageToXml(newsMessage);
	}

}
