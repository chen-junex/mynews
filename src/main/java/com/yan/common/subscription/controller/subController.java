/**
 * Copyright (C), 2018-2019, 中信网络科技股份有限公司
 * <p>
 * FileName: subController
 * <p>
 * Author:   cjs
 * <p>
 * Date:     2019/3/31 14:16
 * <p>
 * Description: 评论管理
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


package com.yan.common.subscription.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.yan.common.news.mapper.NewsMapper;
import com.yan.common.news.model.News;
import com.yan.common.subscription.mapper.SubscriptionMapper;
import com.yan.common.subscription.model.Subscription;
import com.yan.core.annotation.MapperInject;
import com.yan.core.controller.BaseController;
import com.yan.core.model.PageModel;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈评论管理〉
 *
 * @author cjs

 * @create 2019/3/31

 * @since 1.0.0

 */
@Controller
@RequestMapping("/common/subscription")
public class subController extends BaseController {

    @MapperInject(SubscriptionMapper.class)
    private SubscriptionMapper mapper;

    @RequestMapping("/manage")
    public String manage() {
        return "common/subscription/manage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<Subscription> list(int offset, int limit, String search, String sort, String order) {
        this.offsetPage(offset, limit);
        List<Subscription> list = mapper.selectByExample(null);
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

}