/**
 * Copyright (C), 2018-2019, 中信网络科技股份有限公司
 * <p>
 * FileName: EvaluateController
 * <p>
 * Author:   cjs
 * <p>
 * Date:     2019/3/31 13:32
 * <p>
 * Description: 评论controller
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


package com.yan.common.evaluate.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yan.common.evaluate.mapper.EvaluateMapper;
import com.yan.common.evaluate.model.Evaluate;
import com.yan.common.news.mapper.NewsMapper;
import com.yan.common.news.model.News;
import com.yan.core.annotation.MapperInject;
import com.yan.core.controller.BaseController;
import com.yan.core.model.PageModel;

import com.yan.util.DateConverter;
import com.yan.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈评论controller〉
 *
 * @author cjs

 * @create 2019/3/31

 * @since 1.0.0

 */
@Controller
@RequestMapping("/common/evaluate")
public class EvaluateController extends BaseController {
    @MapperInject(EvaluateMapper.class)
    private EvaluateMapper mapper;

    @RequestMapping("/manage")
    public String manage() {
        return "common/evaluate/manage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<Evaluate> list(int offset, int limit, String search, String sort, String order) {
        this.offsetPage(offset, limit);
        List<Evaluate> list = mapper.selectByExample(null);
        return this.resultPage(list);
    }
    @RequestMapping(value = "/getEvaluateall", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<Evaluate> getEvaluateall(int offset, int limit, String search, String sort, String order) {
        this.offsetPage(offset, limit);
        List<Evaluate> list = mapper.selectByExample(null);
        return this.resultPage(list);
    }
    @ResponseBody
    @RequestMapping(value = "/insertEvaluate",produces ="text/html; charset=utf-8")
    public String getEvaluateById(@RequestBody Evaluate evaluate) {

        if(evaluate==null){
            return null;
        }
         evaluate.setEvaluate_datetime(new Date());
        int flag = mapper.insertSelective(evaluate);
        if(flag>0){
            return "1";
        }
        return null;
    }
//   陈

    @ResponseBody
    @RequestMapping(value = "/getEvaluateById",produces ="text/html; charset=utf-8")
    public String insertEvaluate(String news_id) {
        List<Evaluate> list = mapper.selectById(news_id);
        //        for(Evaluate e:list){
////            e.setEvaluate_datetime(DateUtil.formatDateToString(e.getEvaluate_datetime(),DateUtil.YYYY_MM_DD_HH_MM_SS));
//        }
//        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
//        Map<String,Evaluate> evaluateMap = new HashMap<>();
//        JSONObject jsonobj = new JSONObject();
//        for(Evaluate evaluate:list){
//            jsonobj.putAll(evaluate);
//        }
//       List<Map<String, Evaluate>> newslist = list;
//        for(Map<String,Object> m :newslist){
//            JSONObject jsonobj = new JSONObject();
//            jsonobj.putAll(m);
//            jsonArray.add(jsonobj);
//        }
//        //     jsonobj.put("username",1);
//        // JSONObject jsonobj1 = new JSONObject();
//        //jsonobj1.put("chen",1);
//        return JSONUtils.toJSONString(jsonArray);
        return JSON.toJSONString(list);
    }

}