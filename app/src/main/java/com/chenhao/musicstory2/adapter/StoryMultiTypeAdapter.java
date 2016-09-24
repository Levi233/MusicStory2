package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.chenhao.musicstory2.bean.Msg;
import com.chenhao.musicstory2.bean.StoryBannerSection;
import com.chenhao.musicstory2.bean.StoryFriendListSection;
import com.chenhao.musicstory2.bean.StoryInfo;
import com.chenhao.musicstory2.bean.StoryProductionSquare2Section;
import com.chenhao.musicstory2.bean.StorySection;
import com.chenhao.musicstory2.bean.StoryTagsSquare2Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StoryMultiTypeAdapter extends AdapterFactory<Msg> {

    public StoryMultiTypeAdapter(Context context, Msg msg, Handler handler) {
        super(context, msg, handler);
    }

    @Override
    protected void buildAdapters(Msg msg) {
        ArrayList<StorySection> sections = msg.getSections();
        for (StorySection section : sections) {
            if (section instanceof StoryFriendListSection) {
                addAdapter(new StoryFriendListAdapter(getContext(), section.getStoryInfos(), section.getItemViewType(), getHandler()));
            }else if (section instanceof StoryBannerSection) {
                addAdapter(new StoryBannerAdapter(getContext(), section.getStoryInfos(), section.getItemViewType(), getHandler()));
            }else if(section instanceof StoryProductionSquare2Section){
                ArrayList<StoryInfo> infos = section.getStoryInfos();
                for (int i = 0 ;i < infos.size() ;i += 2){
                    List<StoryInfo> infos2 = new ArrayList<StoryInfo>();
                    StoryInfo left = infos.get(i);
                    StoryInfo right = infos.get(i+1);
                    Log.e("chenhaolog",infos.get(i).getName());
                    infos2.add(left);
                    infos2.add(right);
                    addAdapter(new StroyProductionSquare2Adapter(getContext(),infos2,section.getItemViewType(),getHandler()));
                }
            }else if(section instanceof StoryTagsSquare2Section){
                    addAdapter(new StroyTagSquare2Adapter(getContext(),section.getStoryInfos(),section.getItemViewType(),getHandler()));
            }
        }
    }
}
