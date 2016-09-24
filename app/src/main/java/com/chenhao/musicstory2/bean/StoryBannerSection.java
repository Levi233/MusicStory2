package com.chenhao.musicstory2.bean;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StoryBannerSection extends StorySection{
    @Override
    public int getItemViewType() {
        return ItemViewType.TYPE_STORY_BANNER.ordinal();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
