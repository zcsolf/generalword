package com.zcsolf.entity_and_adapter;

/**
 * '更多'界面里面的ListView实体类
 * 
 * @author zcsolf
 * 
 */
public class More {
	private boolean LinerLayoutFlag;		//控制listView的item分组的标识.
	private int MoreImage;
	private String MoreTitle;
	private String MoreRightText; // 需要改进
	private int MoreBack;

	public More(int moreImage, String moreTitle, String moreRightText,
			int moreBack , boolean linerLayoutFlag) {
		super();
		MoreImage = moreImage;
		MoreTitle = moreTitle;
		MoreRightText = moreRightText;
		MoreBack = moreBack;
		LinerLayoutFlag = linerLayoutFlag;
	}

	public boolean getLinerLayoutFlag() {
		return LinerLayoutFlag;
	}

	public void setLinerLayoutFlag(boolean linerLayoutFlag) {
		LinerLayoutFlag = linerLayoutFlag;
	}

	public int getMoreImage() {
		return MoreImage;
	}

	public void setMoreImage(int moreImage) {
		MoreImage = moreImage;
	}

	public String getMoreTitle() {
		return MoreTitle;
	}

	public void setMoreTitle(String moreTitle) {
		MoreTitle = moreTitle;
	}

	public String getMoreRightText() {
		return MoreRightText;
	}

	public void setMoreRightText(String moreRightText) {
		MoreRightText = moreRightText;
	}

	public int getMoreBack() {
		return MoreBack;
	}

	public void setMoreBack(int moreBack) {
		MoreBack = moreBack;
	}

}
