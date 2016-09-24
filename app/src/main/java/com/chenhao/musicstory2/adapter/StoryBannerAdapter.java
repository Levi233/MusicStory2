package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.chenhao.musicstory2.R;
import com.chenhao.musicstory2.bean.StoryInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StoryBannerAdapter extends SingleViewAdapter<List<StoryInfo>>{

    public StoryBannerAdapter(Context context, List<StoryInfo> storyInfos, int type, Handler handler) {
        super(context, storyInfos, type, handler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view = convertView;
        if(view == null){
            holder = new Holder();
            view = getLayoutInflater().inflate(R.layout.banner_item, parent, false);
            holder.viewPager = (ViewPager) view.findViewById(R.id.view_pager);
            holder.viewpagerAdapter = new MyViewpager(getContext(), (ArrayList<StoryInfo>) getItem());
            holder.viewPager.setAdapter(holder.viewpagerAdapter);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
            holder.viewpagerAdapter.setData((ArrayList<StoryInfo>) getItem());
            holder.viewpagerAdapter.notifyDataSetChanged();
        }
        return view;
    }

    public static class Holder{
        ViewPager viewPager;
        MyViewpager viewpagerAdapter;
    }
}
