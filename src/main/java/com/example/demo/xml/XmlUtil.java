package com.example.demo.xml;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.demo.message.resp.ImageMessage;
import com.example.demo.message.resp.Message;
import com.example.demo.message.resp.Music;
import com.example.demo.message.resp.MusicMessage;
import com.example.demo.message.resp.NewsItem;
import com.example.demo.message.resp.NewsMessage;
import com.example.demo.message.resp.TextMessage;
import com.example.demo.message.resp.Video;
import com.example.demo.message.resp.VideoMessage;
import com.example.demo.message.resp.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class XmlUtil {

	public static Map<String, String> parseXml(HttpServletRequest request,int f) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	public static JSONObject parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		JSONObject jsonObject = new JSONObject();
		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList) {
			jsonObject.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		inputStream = null;
		return jsonObject;
	}

	/**
	 * xmlSerializer好像默认支持CDATA,测试的时候转成lt gt<br/>
	 * 
	 * @param json
	 * @return
	 * 
	 * 		因为json转化bean 首字母自动小写。。。此方法行不通
	 */
	public static String toXml(JSONObject json) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setRootName("xml");
		xmlSerializer.setTypeHintsEnabled(false);
		String xml = xmlSerializer.write(json);
		System.err.println("xmlSerializer解析出来的数据：" + xml);
		return xml;
	}

	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	
	
	/**
     * 文本消息对象转换成xml
     * 
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String messageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图片消息对象转换成xml
     * 
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String messageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 语音消息对象转换成xml
     * 
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频消息对象转换成xml
     * 
     * @param videoMessage 视频消息对象
     * @return xml
     */
    public static String messageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        xstream.omitField(videoMessage.getClass(), "id");
        xstream.omitField(Video.class, "id");
        xstream.omitField(Message.class, "id");
        return xstream.toXML(videoMessage);
    }

    /**
     * 音乐消息对象转换成xml
     * 
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String messageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        xstream.omitField(musicMessage.getClass(), "id");
        xstream.omitField(Music.class, "id");
        xstream.omitField(Message.class, "id");
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息对象转换成xml
     * 
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String messageToXml(NewsMessage newsMessage) {
        xstream.omitField(newsMessage.getClass(), "id");
        xstream.omitField(NewsItem.class, "id");
        xstream.omitField(Message.class, "id");
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new NewsItem().getClass());
        xstream.aliasAttribute(null, "class");
        return xstream.toXML(newsMessage);
    }

}
