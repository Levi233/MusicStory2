package com.chenhao.musicstory2.bean;

public class StoryWebInfo extends StoryInfo{
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "StoryWebInfo [url=" + url + ", toString()=" + super.toString() + "]";
	}
}
