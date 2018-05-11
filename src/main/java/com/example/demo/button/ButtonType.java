package com.example.demo.button;

/**
 * 1、click：点击推事件用户点击click类型按钮后<br/>
 * 2、view：跳转URL用户点击view类型按钮后，微<br/>
 * 3、scancode_push：扫码推事件用户点击按钮<br/>
 * 4、scancode_waitmsg：扫码推事件且弹出<br/>
 * 5、pic_sysphoto：弹出系统拍照发图用户点击<br/>
 * 6、pic_photo_or_album：弹出拍照或者<br/>
 * 7、pic_weixin：弹出微信相册发图器用户点击按<br/>
 * 8、location_select：弹出地理位置选择器<br/>
 * 9、media_id：下发消息（除文本消息）用户点击m<br/>
 * 10、view_limited：跳转图文消息URL用户<br/>
 */
public class ButtonType {

	public static final String container = "container";
	public static final String view = "view";
	public static final String click = "click";
	public static final String location_select = "location_select";
	public static final String media_id = "media_id";

}
