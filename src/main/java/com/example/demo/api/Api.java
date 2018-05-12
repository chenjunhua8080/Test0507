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
	
}
