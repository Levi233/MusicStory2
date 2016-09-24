package com.chenhao.musicstory2.utils;

import com.chenhao.musicstory2.bean.Msg;
import com.chenhao.musicstory2.bean.StoryBannerSection;
import com.chenhao.musicstory2.bean.StoryChooseAccompanyInfo;
import com.chenhao.musicstory2.bean.StoryFriendInfo;
import com.chenhao.musicstory2.bean.StoryFriendListSection;
import com.chenhao.musicstory2.bean.StoryInfo;
import com.chenhao.musicstory2.bean.StoryProductionInfo;
import com.chenhao.musicstory2.bean.StoryProductionSquare2Section;
import com.chenhao.musicstory2.bean.StorySection;
import com.chenhao.musicstory2.bean.StoryTagInfo;
import com.chenhao.musicstory2.bean.StoryTagsSquare2Section;
import com.chenhao.musicstory2.bean.StoryWebInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParserJson {
	private String json;

	public ParserJson(String json) {
		this.json = json;
	}
	
	public Msg parserMusicStoryJson()throws JSONException{
		Msg msg = new Msg();
		ArrayList<StorySection> sections = msg.getSections();
		JSONObject jsonObject;
			jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("msg");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				String type = getDefaultString(obj, "type");
				String label = getDefaultString(obj, "label");
				StorySection section = null;
				ArrayList<StoryInfo> storyInfos = null;
				if("story_friend_list".equals(type)){
					section = new StoryFriendListSection();
					storyInfos = section.getStoryInfos();
					section.setLabel(label);
				}else if("story_banner".equals(type)){
					section = new StoryBannerSection();
					storyInfos = section.getStoryInfos();
					section.setLabel(label);
				}else if("story_production_square_2".equals(type)){
					section = new StoryProductionSquare2Section();
					storyInfos = section.getStoryInfos();
					section.setLabel(label);
				}else if("story_tags_square_2".equals(type)){
					section = new StoryTagsSquare2Section();
					storyInfos = section.getStoryInfos();
					section.setLabel(label);
				}
				JSONArray childs = obj.getJSONArray("childs");
				for(int j = 0; j < childs.length(); j++){
					JSONObject obj2 = childs.getJSONObject(j);
					String type2 = getDefaultString(obj2,"type");
					if("story_friend".equals(type2)){
						StoryFriendInfo friendInfo = new StoryFriendInfo();
						parserAndSetStoryInfo(friendInfo,obj2);
						storyInfos.add(friendInfo);
					}else if("story_web".equals(type2)){
						StoryWebInfo webInfo = new StoryWebInfo();
						parserAndSetStoryInfo(webInfo, obj2);
						String url = getDefaultString(obj2,"url");
						webInfo.setUrl(url);
						storyInfos.add(webInfo);
					}else if("story_tags".equals(type2)){
						StoryTagInfo tagInfo = new StoryTagInfo();
						parserAndSetStoryInfo(tagInfo, obj2);
						String storyCount = getDefaultString(obj2,"storyCount");
						String browse = getDefaultString(obj2,"browse");
						tagInfo.setStoryCount(storyCount);
						tagInfo.setBrowse(browse);
						storyInfos.add(tagInfo);
					}else if("story_choose_accompany".equals(type2)){
						StoryChooseAccompanyInfo accompanyInfo = new StoryChooseAccompanyInfo();
						parserAndSetStoryInfo(accompanyInfo, obj2);
						storyInfos.add(accompanyInfo);
					}else if("story_production".equals(type2)){
						StoryProductionInfo productionInfo = new StoryProductionInfo();
						parserAndSetStoryInfo(productionInfo, obj2);
						String userId = getDefaultString(obj2,"userId");
						String userName = getDefaultString(obj2,"userName");
						String praise = getDefaultString(obj2,"praise");
						productionInfo.setUserId(userId);
						productionInfo.setUserName(userName);
						productionInfo.setPraise(praise);
						storyInfos.add(productionInfo);
					}
				}
				sections.add(section);
			}
		return msg;
	}
	
	private String getDefaultString(JSONObject obj, String key, String defaultValue) {
		String name = "";
		try {
			name = obj.getString(key);
		} catch (JSONException e) {
			name = defaultValue;
		}
		return name;
	}
	private String getDefaultString(JSONObject obj, String key) {
		return getDefaultString(obj, key, "");
	}
	
	private void parserAndSetStoryInfo(StoryInfo info,JSONObject obj){
		String name = getDefaultString(obj, "name");
		String id = getDefaultString(obj, "id");
		String img = getDefaultString(obj, "img");
		String desc = getDefaultString(obj, "desc");
		info.setDesc(desc);
		info.setId(id);
		info.setImg(img);
		info.setName(name);
	}
	
}
