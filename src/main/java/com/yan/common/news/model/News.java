package com.yan.common.news.model;

import com.yan.common.user.model.SysUserKey;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

    private String news_id;
    private String admin_id;
    private String class_id;
    private String news_title;
    private String news_img;
    private String news_content;

    @Override
    public String toString() {
        return "News{" +
                "news_id='" + news_id + '\'' +
                ", admin_id='" + admin_id + '\'' +
                ", class_id='" + class_id + '\'' +
                ", news_title='" + news_title + '\'' +
                ", news_img='" + news_img + '\'' +
                ", news_content='" + news_content + '\'' +
                ", news_firsttime=" + news_firsttime +
                ", news_updatetime=" + news_updatetime +
                ", news_click=" + news_click +
                '}';
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_img() {
        return news_img;
    }

    public void setNews_img(String news_img) {
        this.news_img = news_img;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public Date getNews_firsttime() {
        return news_firsttime;
    }

    public void setNews_firsttime(Date news_firsttime) {
        this.news_firsttime = news_firsttime;
    }

    public Date getNews_updatetime() {
        return news_updatetime;
    }

    public void setNews_updatetime(Date news_updatetime) {
        this.news_updatetime = news_updatetime;
    }

    public int getNews_click() {
        return news_click;
    }

    public void setNews_click(int news_click) {
        this.news_click = news_click;
    }

    private Date news_firsttime;
    private Date news_updatetime;
    private int news_click;
}