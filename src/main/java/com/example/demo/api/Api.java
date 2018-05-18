package com.example.demo.api;

public class Api {
	/**
	 * https请求方式: GET<br/>
	 * 参数 是否必须 说明<br/>
	 * grant_type 是 获取access_token填写client_credential<br/>
	 * appid 是 第三方用户唯一凭证<br/>
	 * secret 是 第三方用户唯一凭证密钥，即appsecret<br/>
	 * 
	 */
	public static final String access_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * button 是 一级菜单数组，个数应为1~3个<br/>
	 * sub_button 否 二级菜单数组，个数应为1~5个<br/>
	 * type 是 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型<br/>
	 * name 是 菜单标题，不超过16个字节，子菜单不超过60个字节<br/>
	 * key click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节<br/>
	 * url view、miniprogram类型必须 网页 链接，用户点击菜单可打开链接，不超过1024字节。
	 * type为miniprogram时，不支持小程序的老版本客户端将打开本url。<br/>
	 * media_id media_id类型和view_limited类型必须 调用新增永久素材接口返回的合法media_id<br/>
	 * appid miniprogram类型必须 小程序的appid（仅认证公众号可配置）<br/>
	 * pagepath miniprogram类型必须 小程序的页面路径<br/>
	 */
	public static final String menu_create = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：GET<br/>
	 */
	public static final String menu_get = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：GET<br/>
	 */
	public static final String menu_delete = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * json:{"begin_openid":"OPENID1"}<br/>
	 * 当 begin_openid 为空时，默认从开头拉取。<br/>
	 */
	public static final String black_list = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token 是 调用接口凭证<br/>
	 * openid_list 是 需要拉入黑名单的用户的openid，一次拉黑最多允许20个<br/>
	 * json:{"openid_list":["OPENID1”,” OPENID2”]}<br/>
	 */
	public static final String set_black = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token 是 调用接口凭证<br/>
	 * openid_list 是 需要取消拉入黑名单的用户的openid，一次取消拉黑最多允许20个<br/>
	 * json:{"openid_list":["OPENID1”,” OPENID2”]}<br/>
	 */
	public static final String set_black_rollback = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";
	
	/**
	 * http请求方式: POST（请使用https协议）<br/>
	 * 参数	说明<br/>
	 * access_token	调用接口凭证<br/>
	 * openid	用户标识<br/>
	 * remark	新的备注名，长度必须小于30字符<br/>
	 * POST数据例子：<br/>
	 * {<br/>
	 *     "openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",<br/>
	 *     "remark":"pangzi"<br/>
	 * }<br/>
	 */
	public static final String set_remark = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式: GET<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * openid	是	普通用户的标识，对当前公众号唯一0字符<br/>
	 * lang	否	返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语<br/>
	 */
	public static final String user_info = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	
	/**
	 * http请求方式: POST<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * openid	是	普通用户的标识，对当前公众号唯一0字符<br/>
	 * lang	否	返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语<br/>
	 * POST数据示例<br/>
	 * {<br/>
	 *     "user_list": [<br/>
	 *         {
	 *             "openid": "otvxTs4dckWG7imySrJd6jSi0CWE", <br/>
	 *             "lang": "zh_CN"<br/>
	 *         }, <br/>
	 *         {<br/>
	 *             "openid": "otvxTs_JZ6SEiP0imdhpi50fuSZg", <br/>
	 *             "lang": "zh_CN"<br/>
	 *         }<br/>
	 *     ]<br/>
	 * }<br/>
	 */
	public static final String users_info = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式: GET<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * next_openid	是	第一个拉取的OPENID，不填默认从头开始拉取<br/>
	 */
	public static final String user_list = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

	/**
	 * http请求方式: GET<br/>
	 */
	public static final String media_count = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	/**
	 * http请求方式: POST<br/>
	 * 参数说明<br/>
	 * 参数	是否必须	说明<br/>
	 * type	是	素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）<br/>
	 * offset	是	从全部素材的该偏移位置开始返回，0表示从第一个素材 返回<br/>
	 * count	是	返回素材的数量，取值在1到20之间<br/>
	 * 调用示例<br/>
	 * {<br/>
	 *     "type":TYPE,<br/>
	 *     "offset":OFFSET,<br/>
	 *     "count":COUNT<br/>
	 * }<br/>
	 */
	public static final String media_list = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式：POST/FORM，使用https<br/>
	 * 参数说明<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * type	是	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）<br/>
	 * media	是	form-data中媒体文件标识，有filename、filelength、content-type等信息<br/>
	 */
	public static final String media_upload ="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * http请求方式: POST，需使用https<br/>
	 * 参数说明<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * type	是	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）<br/>
	 * media	是	form-data中媒体文件标识，有filename、filelength、content-type等信息<br/>
	 * 在上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息，内容格式为JSON，格式如下：<br/>
	 * {<br/>
	 *   "title":VIDEO_TITLE,<br/>
	 *   "introduction":INTRODUCTION<br/>
	 * }<br/>
	 */
	public static final String forever_media_upload ="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

	
	/**
	 * http请求方式：POST/FORM，使用https<br/>
	 * 参数说明<br/>
	 * 参数	是否必须	说明<br/>
	 * title	是	标题<br/>
	 * thumb_media_id	是	图文消息的封面图片素材id（必须是永久mediaID）<br/>
	 * author	否	作者<br/>
	 * digest	否	图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。<br/>
	 * show_cover_pic	是	是否显示封面，0为false，即不显示，1为true，即显示<br/>
	 * content	是	图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 "上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。<br/>
	 * content_source_url	是	图文消息的原文地址，即点击“阅读原文”后的URL<br/>
	 * 调用示例<br/>
	 * {<br/>
	 * "articles": [{<br/>
	 * "title": TITLE,<br/>
	 * "thumb_media_id": THUMB_MEDIA_ID,<br/>
	 * "author": AUTHOR,<br/>
	 * "digest": DIGEST,<br/>
	 * "show_cover_pic": SHOW_COVER_PIC(0 / 1),<br/>
	 * "content": CONTENT,<br/>
	 * "content_source_url": CONTENT_SOURCE_URL<br/>
	 * },<br/>
	 * //若新增的是多图文素材，则此处应还有几段articles结构<br/>
	 * ]<br/>
	 * }<br/>
	 */
	public static final String news_upload ="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式：POST/FORM，使用https<br/>
	 * 参数说明<br/>
	 * 参数	是否必须	说明<br/>
	 * access_token	是	调用接口凭证<br/>
	 * media	是	form-data中媒体文件标识，有filename、filelength、content-type等信息<br/>
	 */
	public static final String news_image_upload ="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式: POST,https协议<br/>
	 * 调用示例<br/>
	 * {<br/>
	 * "media_id":MEDIA_ID<br/>
	 * }<br/>
	 */
	public static final String get_material="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式: POST<br/>
	 * 参数	是否必须	说明<br/>
	 * msg_data_id	是	Uint32	群发返回的msg_data_id<br/>
	 * index	否	Uint32	多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文<br/>
	 */
	public static final String comment_open= "https://api.weixin.qq.com/cgi-bin/comment/open?access_token=ACCESS_TOKEN";
	
	/**
	 * http请求方式: POST<br/>
	 * 参数	是否必须	说明<br/>
	 * msg_data_id	是	Uint32	群发返回的msg_data_id<br/>
	 * index	否	Uint32	多图文时，用来指定第几篇图文，从0开始，不带默认返回该msg_data_id的第一篇图文<br/>
	 * begin	是	Uint32	起始位置<br/>
	 * count	是	Uint32	获取数目（>=50会被拒绝）<br/>
	 * type	是	Uint32	type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论<br/>
	 */
	public static final String comment_list = "https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式: POST<br/>
	 * 参数	是否必须	说明<br/>
	 * msg_data_id	是	Uint32	群发返回的msg_data_id<br/>
	 * index	否	Uint32	多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文文<br/>
	 * user_comment_id	是	Uint32	评论id<br/>
	 * content	是	string	回复内容<br/>
	 */
	public static final String comment_reply = "https://api.weixin.qq.com/cgi-bin/comment/reply/add?access_token=ACCESS_TOKEN";

	
	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "tag" : {     "name" : "广东"//标签名   } }<br/>
	 */
	public static final String tag_create = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：get（请使用https协议）<br/>
	 */
	public static final String tag_list = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "tag" : {   "id":1  ,"name" : "广东"   } }<br/>
	 */
	public static final String tag_update = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "tag" : {     "id" : 1  } }<br/>
	 */
	public static final String tag_detele = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * http请求方式：GET? POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{  "tagid" : 1,"next_openid":""    } <br/>
	 */
	public static final String tag_user_list= "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";

	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "openid_list" :["openid1","openid2"],"tagid":1 }<br/>
	 */
	public static final String tag_add_user= "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
	
	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "openid_list" :["openid1","openid2"],"tagid":1 }<br/>
	 */
	public static final String tag_remove_user= "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
	
	
	/**
	 * http请求方式：POST（请使用https协议）<br/>
	 * 参数 是否必须 说明<br/>
	 * access_token	调用接口凭据<br/>
	 * name	标签名（30个字符以内）<br/>
	 * json:{   "openid" :"openid1" }<br/>
	 */
	public static final String get_user_tag= "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";


	/**
	 * http请求方式: POST<br/>
	 * 图文类型<br/>
	 * {<br/>
	 *    "filter":{<br/>
	 *       "is_to_all":false,<br/>
	 *       "tag_id":2<br/>
	 *    },<br/>
	 *    "mpnews":{<br/>
	 *       "media_id":"123dsdajkasd231jhksad"<br/>
	 *    },<br/>
	 *     "msgtype":"mpnews",<br/>
	 *     "send_ignore_reprint":0<br/>
	 * }<br/>
	 * 其他类型实例<br/>
	 * "text":{<br/>
	 *    "content":"CONTENT"<br/>
	 * },<br/>
	 *  "msgtype":"text"<br/>
	 */
	public static final String send_message="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
}
