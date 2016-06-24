package com.zcsolf.entity_and_adapter;

/**
 * 
 * @author zcsolf Tabadapter的item中的内容
 */
public class User1 {
	private int TabImage;
	private String TabName;

	public User1(int tabImage, String tabName) {
		super();
		TabImage = tabImage;
		TabName = tabName;
	}

	public int getTabImage() {
		return TabImage;
	}

	public void setTabImage(int tabImage) {
		TabImage = tabImage;
	}

	public String getTabName() {
		return TabName;
	}

	public void setTabName(String tabName) {
		TabName = tabName;
	}

}
