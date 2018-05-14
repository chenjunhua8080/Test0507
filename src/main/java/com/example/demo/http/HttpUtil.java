package com.example.demo.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

public class HttpUtil {

	public static String request(String urlStr, String method, String param) throws Exception {
		System.out.println(urlStr);
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setConnectTimeout(5000);
		// conn.setRequestProperty("accept", "*/*");
		// conn.setRequestProperty("connection", "Keep-Alive");

		BufferedWriter writer = null;
		if (method.equals(HttpMethod.POST)) {
			conn.setRequestMethod(HttpMethod.POST);
			if (param != null) {
				conn.setDoOutput(true);
				writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				writer.write(param);
				writer.flush();
				writer.close();
				writer = null;
			}
		}

		Map<String, List<String>> headers = conn.getHeaderFields();
		System.out.println(headers); // 输出头字段

		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((tempLine = reader.readLine()) != null) {
			resultBuffer.append(tempLine);
		}
		reader.close();
		reader = null;

		String result = resultBuffer.toString();
		return result;
	}

	public static String uploadRequest(String urlStr, String filePath) throws Exception {
		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists() || file.length() < 6) {
			throw new Exception("找不到文件: " + filePath);
		}
		HttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(urlStr);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("media", file, ContentType.MULTIPART_FORM_DATA, filePath);
		HttpEntity reqEntity = builder.build();
		httpPost.setEntity(reqEntity);
		HttpResponse response = client.execute(httpPost);
		HttpEntity respEntity = response.getEntity();
		String result = "";
		if (respEntity != null) {
			result = EntityUtils.toString(respEntity, Charset.forName("UTF-8"));
		}
		return result;
	}
	/**
	 * Connection reset
	 */
	public static String uploadRequest(String urlStr, MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("找不到文件:");
		}
		String filename = file.getOriginalFilename();
		System.out.println(filename);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(urlStr);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("media", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, filename);
		HttpEntity reqEntity = builder.build();
		httpPost.setEntity(reqEntity);
		HttpResponse response = client.execute(httpPost);
		String result = "";
		int respStatus = response.getStatusLine().getStatusCode();
		if (respStatus == HttpStatus.SC_OK) {
			HttpEntity respEntity = response.getEntity();
			result = EntityUtils.toString(respEntity, Charset.forName("UTF-8"));
			EntityUtils.consume(respEntity);
			System.out.println("resp ok");
		}
		client.close();
		return result;
	}

	public static Map<String, Object> request() throws Exception {

		Map<String, Object> map = new HashMap<>();

		URL url = new URL("https://www.hao123.com");
		URLConnection conn = url.openConnection();

		// 2.处理设置参数和一般请求属性
		// 2.1设置参数
		// 可以根据请求的需要设置参数
		conn.setUseCaches(false);
		conn.setConnectTimeout(5000); // 请求超时时间

		// 2.2请求属性
		// 设置通用的请求属性 更多的头字段信息可以查阅HTTP协议
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");

		// 3.使用 connect 方法建立到远程对象的实际连接。
		conn.connect();

		// 4.远程对象变为可用。远程对象的头字段和内容变为可访问。
		// 4.1获取响应的头字段
		Map<String, List<String>> headers = conn.getHeaderFields();
		System.out.println(headers); // 输出头字段

		// 4.2获取响应正文
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((tempLine = reader.readLine()) != null) {
			resultBuffer.append(tempLine);
		}
		reader.close();
		String result = resultBuffer.toString();
		// System.out.println(result);

		// 创建 Pattern 对象
		Pattern r = Pattern.compile("</a>");
		// 现在创建 matcher 对象
		Matcher m = r.matcher(result);
		result = m.replaceAll("</a>\r\n");

		r = Pattern.compile(".*?(<a[^</a>].*?</a>).*?");
		m = r.matcher(result);
		if (m.find()) {
			result = m.replaceAll("$1");
			// System.out.println(result);
			r = Pattern.compile("<a.*?href=\"(.*?)\".*?>(.*)</a>");
			m = r.matcher(result);
			while (m.find()) {
				String href = m.group(1);
				String text = m.group(2);
				// System.out.println("href:"+href);
				// System.out.println("text:"+text);
				map.put(text, href);
			}
		}
		return map;
	}

}
