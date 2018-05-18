package com.example.demo.control;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.Api;
import com.example.demo.dao.MediaDao;
import com.example.demo.dao.NewsMediaDao;
import com.example.demo.dao.TokenDao;
import com.example.demo.entity.Media;
import com.example.demo.entity.NewsMedia;
import com.example.demo.http.HttpMethod;
import com.example.demo.http.HttpUtil;
import com.example.demo.media.Articles;

import net.sf.json.JSONObject;

@RestController
public class MediaControl {

	@Autowired
	private TokenDao tokenDao;

	@Autowired
	private MediaDao mediaDao;
	
	@Autowired
	private NewsMediaDao newsDao;

	@GetMapping("/count/media")
	public String mediaCount() throws Exception {
		String url = Api.media_count.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.GET, null);
		return result;
	}

	@GetMapping("/list/media/{type}")
	public String mediaList(@PathVariable String type) throws Exception {
		String url = Api.media_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"type\":\"" + type + "\",\"offset\":\"0\",\"count\":\"10\"}");
		return result;
	}
	
	@GetMapping("/get/media/{media_id}")
	public String getMedia(@PathVariable String media_id) throws Exception {
		String url = Api.get_material.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"media_id\":\"" + media_id + "\"}");
		return result;
	}
	
	@GetMapping("/upload/media")
	public String uploadMedia(@RequestParam("path") String path, @RequestParam("type") String type) throws Exception {
		// public String uploadMedia(String path, String type) throws Exception {
		path = path == null ? "C:\\you.jpg" : path;
		type = type == null ? "image" : type;
		String url = Api.media_upload.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("TYPE", type);
		String result = HttpUtil.uploadRequest(url, path);
		if (result.contains("media_id")) {
			JSONObject json = JSONObject.fromObject(result);
			json.put("path", path);
			Media media = (Media) JSONObject.toBean(json, Media.class);
			media = mediaDao.save(media);
			return media.toString();
		}
		return result;
	}

	@PostMapping("/upload/media")
	public String uploadMedia(HttpServletRequest request, @RequestParam("file") MultipartFile file,@RequestParam("type") String type,@RequestParam("isForever") int isForever) throws Exception {
		String contentType = type.equals("")?file.getContentType():type;
		String fileName = file.getOriginalFilename();
		String url ="";
		if (type.equals("newsImg")) {
			 url=Api.news_image_upload.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("TYPE",
						contentType);
		} else {
			if (isForever==0) {
				 url=Api.media_upload.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("TYPE",
							contentType);
			}else {
				 url=Api.forever_media_upload.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue()).replace("TYPE",
							contentType);
			}
		}
		String path = multipartFile2File(request, file);
		String result = HttpUtil.uploadRequest(url,path+fileName );
		if (result.contains("media_id")) {
			JSONObject json = JSONObject.fromObject(result);
			System.err.println(json.toString());
			Media media = (Media) JSONObject.toBean(json, Media.class);
			media.setPath(fileName);
			media.setIsForever(isForever);
			media = mediaDao.save(media);
			return media.toString();
		}
		return result;
	}
	
	@PostMapping("/upload/news")
	public String uploadNews(NewsMedia news) throws Exception {
		String url = Api.news_upload.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		Articles arr=new Articles();
		NewsMedia[] newsList=new NewsMedia[]{news};
		arr.setArticles(newsList);
		JSONObject json = JSONObject.fromObject(arr);
		String param = json.toString();
		System.out.println(param);
		String result = HttpUtil.request(url, HttpMethod.POST, param);
		if (result.contains("media_id")) {
			JSONObject respJson = JSONObject.fromObject(result);
			news.setMedia_id(respJson.getString("media_id"));
			NewsMedia respNews = newsDao.save(news);
			return respNews.toString();
		}
		return result;
	}
	
	@GetMapping("/comment/open/{media_id}")
	public String openComment(@PathVariable String media_id) throws Exception {
		String url = Api.comment_open.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"msg_data_id\":\"" + media_id + "\"}");
		return result;
	}
	
	@GetMapping("/list/comment")
	public String listComment(@PathVariable String media_id) throws Exception {
		String url = Api.comment_list.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"msg_data_id\":\""+media_id+"\",\"begin\":0,\"count\":10,\"type\":0}");
		return result;
	}
	
	
	@GetMapping("/reply/comment")
	public String replyComment(@PathVariable("media_id") String media_id,@PathVariable("user_comment_id") String user_comment_id,@PathVariable("content") String content) throws Exception {
		String url = Api.comment_reply.replace("ACCESS_TOKEN", tokenDao.findByIdMax().getValue());
		String result = HttpUtil.request(url, HttpMethod.POST,
				"{\"msg_data_id\":\""+media_id+"\",\"user_comment_id\":\""+user_comment_id+"\",\"content\":\""+content+"\"}");
		return result;
	}
	
	
	

	private static String multipartFile2File(HttpServletRequest request, MultipartFile file) throws Exception {
		String filePath="";
		if (!file.isEmpty()) {
			filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String path = filePath + file.getOriginalFilename();
			File tempFile = null;
			 tempFile =  new File(path);
             file.transferTo(tempFile);
		}
		return filePath;
	}

}
