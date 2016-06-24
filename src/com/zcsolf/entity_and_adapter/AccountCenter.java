package com.zcsolf.entity_and_adapter;

/**
 * 
 * @author zcsolf 账号中心的ListView的entity
 */
public class AccountCenter {
	private int ItemImage;
	private int ItemGoImage;
	private String ItemTitle;
	private String ItemContent;
	private String ItemExraContent;

	
	public AccountCenter(int itemImage, int itemGoImage, String itemTitle,
			String itemContent, String itemExraContent) {
		super();
		ItemImage = itemImage;
		ItemGoImage = itemGoImage;
		ItemTitle = itemTitle;
		ItemContent = itemContent;
		ItemExraContent = itemExraContent;
	}

	public int getItemImage() {
		return ItemImage;
	}

	public void setItemImage(int itemImage) {
		ItemImage = itemImage;
	}

	public int getItemGoImage() {
		return ItemGoImage;
	}

	public void setItemGoImage(int itemGoImage) {
		ItemGoImage = itemGoImage;
	}

	public String getItemTitle() {
		return ItemTitle;
	}

	public void setItemTitle(String itemTitle) {
		ItemTitle = itemTitle;
	}

	public String getItemContent() {
		return ItemContent;
	}

	public void setItemContent(String itemContent) {
		ItemContent = itemContent;
	}

	public String getItemExraContent() {
		return ItemExraContent;
	}

	public void setItemExraContent(String itemExraContent) {
		ItemExraContent = itemExraContent;
	}
}
