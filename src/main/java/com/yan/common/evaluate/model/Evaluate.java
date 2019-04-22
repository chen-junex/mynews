/**
 * Copyright (C), 2018-2019, 中信网络科技股份有限公司
 * <p>
 * FileName: Evaluate
 * <p>
 * Author:   cjs
 * <p>
 * Date:     2019/3/31 13:24
 * <p>
 * Description: 评价对象
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


package com.yan.common.evaluate.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈评价对象〉
 *
 * @author cjs

 * @create 2019/3/31

 * @since 1.0.0

 */

public class Evaluate implements Serializable {

    private int evaluate_id;
    private String evaluate_context;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date evaluate_datetime;
    private String user_id;
    private String user_name;
    private String news_id;
    private String user_photo;
    private int is_show;
    private int is_delete;
    private int like_number;

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluate_id=" + evaluate_id +
                ", evaluate_context='" + evaluate_context + '\'' +
                ", evaluate_datetime=" + evaluate_datetime +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", news_id='" + news_id + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", is_show=" + is_show +
                ", is_delete=" + is_delete +
                ", like_number=" + like_number +
                '}';
    }

    public int getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(int evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public String getEvaluate_context() {
        return evaluate_context;
    }

    public void setEvaluate_context(String evaluate_context) {
        this.evaluate_context = evaluate_context;
    }

    public Date getEvaluate_datetime() {
        return evaluate_datetime;
    }

    public void setEvaluate_datetime(Date evaluate_datetime) {
        this.evaluate_datetime = evaluate_datetime;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public int getLike_number() {
        return like_number;
    }

    public void setLike_number(int like_number) {
        this.like_number = like_number;
    }
}