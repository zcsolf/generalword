package com.zcsolf.entity_from_service;

/**
 * 此包为从服务端获取数据所创建的实体
 * 
 * @author zcsolf 从服务端取图片的实体
 */
public class Contact {
	public int id;
	public String title;
	public String image; // 存放图片信息的xml文件中的image标签所指示的地址
	public String content;
	public String date;

	public Contact() {

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
