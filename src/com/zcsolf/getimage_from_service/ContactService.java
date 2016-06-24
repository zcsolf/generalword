package com.zcsolf.getimage_from_service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.net.Uri;
import android.util.Xml;

import com.zcsolf.entity_from_service.Contact;

/**
 * 需要访问服务端并且解析xml文件，在此定义一个服务类
 * 
 * @author zcsolf
 * 
 */
public class ContactService {

	/**
	 * 获取服务端，联网
	 * 
	 * @return
	 */
	public static List<Contact> getContacts() {
		String path = "http://192.168.1.57:8080/AndroidService/listView.xml";
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(path)
					.openConnection();
			conn.setConnectTimeout(5000); // 设置超时时间
			conn.setRequestMethod("GET"); // 设置请求方式
			if (conn.getResponseCode() == 200) { // 连接成功返回码200
				return parseXML(conn.getInputStream());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 利用pull解析器对xml文件进行解析
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	private static List<Contact> parseXML(InputStream xml) throws Exception {
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact = null;
		XmlPullParser pullParser = Xml.newPullParser();
		pullParser.setInput(xml, "UTF-8");
		int event = pullParser.getEventType(); // 取得开始文档语法
		while (event != XmlPullParser.END_DOCUMENT) {
			switch (event) {
			case XmlPullParser.START_TAG: // 开始标签
				if ("contact".equals(pullParser.getName())) {
					contact = new Contact();
					contact.id = new Integer(pullParser.getAttributeValue(0));
				} else if ("title".equals(pullParser.getName())) {
					contact.title = pullParser.nextText(); // 取得后面节点的文本值
				} else if ("image".equals(pullParser.getName())) {
					contact.image = pullParser.getAttributeValue(0); // 取得第一个属性的值
				}else if("content".equals(pullParser.getName())){
					contact.content = pullParser.nextText();
				}else if("date".equals(pullParser.getName())){
					contact.date = pullParser.nextText();
				}
				break;
			case XmlPullParser.END_TAG: // 结束标签
				if ("contact".equals(pullParser.getName())) {
					contacts.add(contact); // 将contact对象添加到集合中
					contact = null;
				}
				break;
			default:
				break;
			}
			event = pullParser.next(); // 去下一个标签
		}

		return contacts;
	}

	/**
	 * 获取网络图片，如果图片存在于缓存中，就返回该图片，否则从网络中加载该图片并缓存起来
	 * 
	 * @param path
	 * @param cacheDir
	 * @return
	 * @throws Exception 
	 */
	public static Uri getImage(String path, File cacheDir) throws Exception {
		// path-->MD5-->32字符串.xxx
		File localFile = new File(cacheDir, MD5.getMD5(path)
				+ path.substring(path.lastIndexOf(".")));
		if (localFile.exists()) {
			return Uri.fromFile(localFile);
		} else {
			HttpURLConnection conn = (HttpURLConnection) new URL(path)
					.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {// 如果连接成功
				FileOutputStream outStream = new FileOutputStream(localFile);
				InputStream inputStream = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				inputStream.close();
				outStream.close();
				return Uri.fromFile(localFile); //
			}
		}
		return null;
	}
}
