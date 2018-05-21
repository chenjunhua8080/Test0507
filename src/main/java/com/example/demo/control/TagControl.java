package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.Api;
import com.example.demo.dao.TagDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.tag.Tag;

import net.sf.json.JSONObject;

@RestController
public class TagControl {
	
	@Autowired
	private TokenDao tokenDao;
	@Autowired
	private TagDao tagDao;
	
	@GetMapping("/create/tag/{name}")
	public String createTag(@PathVariable String name) throws Exception {
		String url = Api.tag_create.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"tag\" : { \"name\" : \""+name+"\"} }");
		if (!result.contains("errcode")) {
			JSONObject json = JSONObject.fromObject(result);
			JSONObject jsonTag = json.getJSONObject("tag");
			jsonTag.put("tagid", jsonTag.getInt("id"));
			Tag	tag = (Tag) JSONObject.toBean(jsonTag, Tag.class);
			Tag respTag = tagDao.save(tag);
			return respTag.toString();
		}
		return result;
	}
	@GetMapping("/list/tag")
	public String listTag() throws Exception {
		String url = Api.tag_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET,null);
		return result;
	}
	@GetMapping("/update/tag/{tagid}/{name}")
	public String updateTag( Tag tag) throws Exception {
		String url = Api.tag_update.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"tag\" : { \"id\":"+tag.getTagid()+" ,\"name\" : \""+tag.getName()+"\"}}");
		if (result.contains("ok")) {
			tagDao.save(tag);
		}
		return result;
	}
	@GetMapping("/delete/tag/{tagid}")
	public String deteleTag(@PathVariable int tagid) throws Exception {
		String url = Api.tag_detele.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"tag\" : { \"id\":"+tagid+"\"}}");
		if (result.contains("ok")) {
			tagDao.delete(new Tag(tagid));
		}
		return result;
	}
	@GetMapping("/tag/{tagid}/userList")
	public String tagUser(@PathVariable int tagid) throws Exception {
		String url = Api.tag_user_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"tagid\" : "+tagid+",\"next_openid\":\"\" }");
		return result;
	}
	@GetMapping("/tagAddUser/{openid}/{tagid}")
	public String tagAddUser(@PathVariable String openid,@PathVariable int tagid) throws Exception {
		String url = Api.tag_add_user.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"openid_list\" :[\""+openid+"\"],\"tagid\":"+tagid+" }");
		return result;
	}
	@GetMapping("/tagRemoveUser/{openid}/{tagid}")
	public String tagRemoveUser(@PathVariable String openid,@PathVariable int tagid) throws Exception {
		String url = Api.tag_remove_user.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"openid_list\" :[\""+openid+"\"],\"tagid\":"+tagid+" }");
		return result;
	}
	@GetMapping("/getUserTag/{openid}")
	public String tagRemoveUser(@PathVariable String openid) throws Exception {
		String url = Api.get_user_tag.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{ \"openid\" :\""+openid+"\" }");
		return result;
	}
	
}
