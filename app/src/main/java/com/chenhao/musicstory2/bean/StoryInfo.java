package com.chenhao.musicstory2.bean;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StoryInfo {
    private String name;
    private String img;
    private String id;
    private String desc;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "StoryInfo [name=" + name + ", img=" + img + ", id=" + id + ", desc=" + desc + "]";
    }
}
