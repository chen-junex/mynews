package com.yan.common.evaluate.mapper;

import com.yan.common.evaluate.model.Evaluate;
import com.yan.common.news.model.News;
import com.yan.common.user.model.SysUserExample;

import java.util.List;

public interface EvaluateMapper {


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    List<Evaluate> selectByExample(SysUserExample example);
    List<Evaluate> selectById(String news_id);


}