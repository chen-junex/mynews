/**
 * Copyright (C), 2018-2019, 中信网络科技股份有限公司
 * <p>
 * FileName: Subscription
 * <p>
 * Author:   cjs
 * <p>
 * Date:     2019/3/31 14:17
 * <p>
 * Description: 评论模型
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


package com.yan.common.subscription.model;


import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈评论模型〉
 *
 * @author cjs

 * @create 2019/3/31

 * @since 1.0.0

 */

public class Subscription implements Serializable {

    private int sub_id;
    private String sub_name;
    private String sub_remark;
    private String sub_type;
    private Date sub_datetime;
    private String sub_photo;

    @Override
    public String toString() {
        return "Subscription{" +
                "sub_id=" + sub_id +
                ", sub_name='" + sub_name + '\'' +
                ", sub_remark='" + sub_remark + '\'' +
                ", sub_type='" + sub_type + '\'' +
                ", sub_datetime=" + sub_datetime +
                ", sub_photo='" + sub_photo + '\'' +
                ", is_show=" + is_show +
                ", is_delete=" + is_delete +
                ", like_number=" + like_number +
                '}';
    }

    private int is_show;

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSub_remark() {
        return sub_remark;
    }

    public void setSub_remark(String sub_remark) {
        this.sub_remark = sub_remark;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public Date getSub_datetime() {
        return sub_datetime;
    }

    public void setSub_datetime(Date sub_datetime) {
        this.sub_datetime = sub_datetime;
    }

    public String getSub_photo() {
        return sub_photo;
    }

    public void setSub_photo(String sub_photo) {
        this.sub_photo = sub_photo;
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

    private int is_delete;
    private int like_number;


}