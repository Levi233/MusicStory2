package com.chenhao.musicstory2.bean;

public class StoryProductionInfo extends StoryInfo{
	private String userId;
	private String userName;
	private String praise;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPraise() {
		return praise;
	}
	public void setPraise(String praise) {
		this.praise = praise;
	}
	@Override
	public String toString() {
		return "StoryProductionInfo [userId=" + userId + ", userName=" + userName + ", praise=" + praise
				+ ", toString()=" + super.toString() + "]";
	}
	
}
