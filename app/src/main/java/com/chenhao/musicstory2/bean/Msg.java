package com.chenhao.musicstory2.bean;

import java.util.ArrayList;

/**
 * Created by chenhao on 2016/8/24.
 */
public class Msg {
    private ArrayList<StorySection> sections = new ArrayList<StorySection>();

    public ArrayList<StorySection> getSections() {
        return sections;
    }

    public void setSections(ArrayList<StorySection> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Msg [sections=" + sections + "]";
    }
}
