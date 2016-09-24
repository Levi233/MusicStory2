package com.chenhao.musicstory2.bean;

import java.util.ArrayList;

/**
 * Created by chenhao on 2016/8/24.
 */
public abstract class StorySection {

    private String label;

    private ArrayList<StoryInfo> storyInfos = new ArrayList<StoryInfo>();

    public ArrayList<StoryInfo> getStoryInfos() {
        return storyInfos;
    }

    public void setStoryInfos(ArrayList<StoryInfo> storyInfos) {
        this.storyInfos = storyInfos;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public abstract int getItemViewType();

    @Override
    public String toString() {
        return "StorySection{" +
                "label='" + label + '\'' +
                ", storyInfos=" + storyInfos +
                '}';
    }
}
