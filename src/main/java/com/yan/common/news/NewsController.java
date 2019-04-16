/**
 * Copyright (C), 2018-2019, 中信网络科技股份有限公司
 * <p>
 * FileName: NewsController
 * <p>
 * Author:   cjs
 * <p>
 * Date:     2019/2/15 10:51
 * <p>
 * Description: news info
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


package com.yan.common.news;


import com.alibaba.druid.support.json.JSONUtils;
import com.yan.common.news.mapper.NewsMapper;
import com.yan.common.evaluate.model.Evaluate;
import com.yan.common.news.model.News;
import com.yan.core.annotation.MapperInject;
import com.yan.core.controller.BaseController;
import com.yan.core.model.PageModel;


import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈news info〉
 *
 * @author cjs

 * @create 2019/2/15

 * @since 1.0.0

 */

@Controller
@RequestMapping("/common/news")
public class NewsController extends BaseController {

    @MapperInject(NewsMapper.class)
    private NewsMapper mapper;

    @RequestMapping("/manage")
    public String manage() {
        return "common/news/manage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<News> list(int offset, int limit, String search, String sort, String order) {
        this.offsetPage(offset, limit);
        List<News> list = mapper.selectByExample(null);
        return this.resultPage(list);
    }
    @ResponseBody
    @RequestMapping(value = "/getEvaluateBynews_id",produces ="text/html; charset=utf-8")
    public String getEvaluateBynews_id(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        JSONArray jsonArray = new JSONArray();
//        List<Map<String, Object>> newslist = delegateMapper.selectList("com.yan.common.login.mapper.LoginCustomMapper.getnewslist");
//        for(Map<String,Object> m :newslist){
//            JSONObject jsonobj = new JSONObject();
//            jsonobj.putAll(m);
//            jsonArray.add(jsonobj);
//        }
        // jsonobj.put("username",1);
        // JSONObject jsonobj1 = new JSONObject();
        //jsonobj1.put("chen",1);
        return JSONUtils.toJSONString(jsonArray);
    }
    @RequestMapping(value = "/deleteNews", method = RequestMethod.POST )
    @ResponseBody
    public String deleteNews(@RequestBody String[] ids) {

        int flag = mapper.deleteByPrimaryKey(Arrays.asList(ids));
        if(flag>0){
            return JSONUtils.toJSONString(flag);
        }

        return JSONUtils.toJSONString("出错了");
    }
}