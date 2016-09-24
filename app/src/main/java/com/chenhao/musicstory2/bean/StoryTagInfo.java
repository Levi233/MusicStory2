package com.chenhao.musicstory2.bean;

public class StoryTagInfo extends StoryInfo{
	private String storyCount;
	private String browse;
	
	public String getStoryCount() {
		return storyCount;
	}
	public void setStoryCount(String storyCount) {
		this.storyCount = storyCount;
	}
	public String getBrowse() {
		return browse;
	}
	public void setBrowse(String browse) {
		this.browse = browse;
	}
	@Override
	public String toString() {
		return "StoryTagInfo [storyCount=" + storyCount + ", browse=" + browse + ", toString()=" + super.toString()
				+ "]";
	}
}
