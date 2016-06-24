package com.zcsolf.entity_and_adapter;

/**
 * 
 * @author zcsolf GameFriend中的gridview的抽象
 */
public class GameFriend {
	private int GameFriendImage;
	private String GameFriendText;

	public GameFriend(int gameFriendImage, String gameFriendText) {
		super();
		GameFriendImage = gameFriendImage;
		GameFriendText = gameFriendText;
	}

	public int getGameFriendImage() {
		return GameFriendImage;
	}

	public void setGameFriendImage(int gameFriendImage) {
		GameFriendImage = gameFriendImage;
	}

	public String getGameFriendText() {
		return GameFriendText;
	}

	public void setGameFriendText(String gameFriendText) {
		GameFriendText = gameFriendText;
	}
}
