package com.example.demo.button;

import net.sf.json.JSONObject;

public class ButtonUtil {

	public static String build() {
		
		 ClickButton btn11 = new ClickButton();  
         btn11.setName("微信相册发图");  
         btn11.setType("pic_weixin");  
         btn11.setKey("rselfmenu_1_1");

         ClickButton btn12 = new ClickButton();  
         btn12.setName("拍照或者相册发图");  
         btn12.setType("pic_photo_or_album");  
         btn12.setKey("rselfmenu_1_2");;  

         ClickButton btn13 = new ClickButton();  
         btn13.setName("系统拍照发图");  
         btn13.setType("pic_sysphoto");  
         btn13.setKey("rselfmenu_1_3");

         ClickButton btn21 = new ClickButton();  
         btn21.setName("扫码带提示");  
         btn21.setType("scancode_waitmsg");  
         btn21.setKey("rselfmenu_2_1");;  

         ClickButton btn22 = new ClickButton();  
         btn22.setName("扫码推事件");  
         btn22.setType("scancode_push");  
         btn22.setKey("rselfmenu_2_2");;  

         ViewButton btn23 = new ViewButton();  
         btn23.setName("我的设备");  
         btn23.setType(ButtonType.view);  
         btn23.setUrl("https://hw.weixin.qq.com/devicectrl/panel/device-list.html?appid=wx614c453e0d1dcd12"); 

         ViewButton btn31 = new ViewButton();  
         btn31.setName("授权页面");  
         btn31.setType(ButtonType.view);  
         btn31.setUrl("http://cjh.nat300.top/oauth2/index");  


         ClickButton btn32 = new ClickButton();  
         btn32.setName("发送位置");  
         btn32.setType(ButtonType.location_select);  
         btn32.setKey("rselfmenu_3_2"); 

         //http://tencent://message/?uin=572839485&Site=在线咨询&Menu=yes
         //http://wpa.qq.com/msgrd?v=3&uin=572839485&site=qq&menu=yes

         ViewButton btn33 = new ViewButton();  
         btn33.setName("在线咨询");  
         btn33.setType(ButtonType.view);  
         btn33.setUrl("http://wpa.qq.com/msgrd?v=3&uin=1109551489&site=qq&menu=yes");  

         ViewButton btn34 = new ViewButton();  
         btn34.setName("我的博客");  
         btn34.setType(ButtonType.view);  
         btn34.setUrl("https://blog.csdn.net/my13413527259"); 

         ClickButton btn35 = new ClickButton();  
         btn35.setName("点击事件");  
         btn35.setType(ButtonType.click);  
         btn35.setKey("rselfmenu_3_5"); 

         ContainerButton mainBtn1 = new ContainerButton();  
         mainBtn1.setName("发图");  
         mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13});  

         ContainerButton mainBtn2 = new ContainerButton();  
         mainBtn2.setName("扫码");  
         mainBtn2.setSub_button(new Button[] { btn21, btn22 ,btn23});  

         ContainerButton mainBtn3 = new ContainerButton();  
         mainBtn3.setName("个人中心");  
         mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34 ,btn35 });  

         /** 
          * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
          *  
          * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
          * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
          * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
          */  
         MenuButton menu = new MenuButton();  
         menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
         return JSONObject.fromObject(menu).toString();
	}

}
