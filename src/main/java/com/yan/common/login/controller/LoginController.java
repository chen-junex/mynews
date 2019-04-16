package com.yan.common.login.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;
import com.yan.common.user.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.common.login.model.LoginModel;
import com.yan.common.login.model.LoginUser;
import com.yan.core.annotation.MapperInject;
import com.yan.core.controller.BaseController;
import com.yan.core.persistence.DelegateMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 名称：LoginController<br>
 * <p>
 * 描述：登录模块<br>
 *
 * @author Yanzheng 严正<br>
 * 时间：<br>
 * 2017-08-22 12:52:52<br>
 * 版权：<br>
 * Copyright 2017 <a href="https://github.com/micyo202" target="_blank">https://github.com/micyo202</a>. All rights reserved.
 */
@Controller
@RequestMapping("/common/login")
public class LoginController extends BaseController {

    @MapperInject
    private DelegateMapper delegateMapper;

    /**
     * 登录方法<br>
     *
     * @param username 用户名
     * @param password 密码
     * @param remember 是否记住密码（写入cookie）
     * @return LoginModel 登录模型
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public LoginModel signin(String username, String password, boolean remember) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userCode", username);
        paramMap.put("userPassword", password);

        LoginUser loginUser = delegateMapper.selectOne("com.yan.common.login.mapper.LoginCustomMapper.getLoginUser", paramMap);

        if (this.isNull(loginUser))
            return new LoginModel(0, "用户名、密码不正确！");

        if (Boolean.FALSE.equals(loginUser.getUserValid()))
            return new LoginModel(0, "该用户已失效！");

        List<Map<String, Object>> userRoles = delegateMapper.selectList("com.yan.common.login.mapper.LoginCustomMapper.getUserRoles", loginUser.getUserId());
        if (!this.isNull(userRoles))
            loginUser.setUserRoles(userRoles);


        System.out.println("Yan -> Log 输出：" + loginUser);

        try {
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated()) { // 当前用户是否已通过身份验证
                UsernamePasswordToken token = new UsernamePasswordToken(username, password, remember);
                // 使用 shiro 来验证
                subject.login(token);//验证角色和权限
                this.getSession().setAttribute("user", loginUser);
            }
            return new LoginModel(1, "/", remember);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new LoginModel(0, "登录失败，未知异常！");
        }
    }

    /**
     * 退出登录（注销方法）<br>
     *
     * @return String 重定向登录页面
     */
    @RequestMapping("/signout")
    public String signout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //this.getSession().invalidate();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(value = "/userlogin",produces ="text/html; charset=utf-8")
    public String userlogin(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userCode", username);
        paramMap.put("userPassword", password);

        LoginUser loginUser = delegateMapper.selectOne("com.yan.common.login.mapper.LoginCustomMapper.getLoginUser", paramMap);
//        session.setAttribute("user","chen");
        JSONObject jsonobj = new JSONObject();
        if(loginUser==null){
//            jsonobj.put("user",null);
//            return JSONUtils.toJSONString(jsonobj);
            return null;

        }

        jsonobj.put("userName",loginUser.getUserName());
        jsonobj.put("userPassword",loginUser.getUserPassword());
        jsonobj.put("userAddress",loginUser.getUserAddress());
        jsonobj.put("userEmail",loginUser.getUserEmail());
        jsonobj.put("userPhone",loginUser.getUserPhone());
        jsonobj.put("userBirthday",loginUser.getUserBirthday());
        jsonobj.put("userJoindate",loginUser.getUserJoindate());
        jsonobj.put("userPhoto",loginUser.getUserPhoto());
        jsonobj.put("userValid",loginUser.getUserValid());
        jsonobj.put("userType",loginUser.getUserType());
        return JSONUtils.toJSONString(jsonobj);
    }

    @ResponseBody
    @RequestMapping(value = "/getnews",produces ="text/html; charset=utf-8")
    public String getnews(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        JSONArray jsonArray = new JSONArray();
        List<Map<String, Object>> newslist = delegateMapper.selectList("com.yan.common.login.mapper.LoginCustomMapper.getnewslist");
        for(Map<String,Object> m :newslist){
            JSONObject jsonobj = new JSONObject();
            jsonobj.putAll(m);
            jsonArray.add(jsonobj);
        }
       // jsonobj.put("username",1);
       // JSONObject jsonobj1 = new JSONObject();
        //jsonobj1.put("chen",1);
        return JSONUtils.toJSONString(jsonArray);
    }

    @ResponseBody
    @RequestMapping(value = "/register",produces ="text/html; charset=utf-8")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        JSONArray jsonArray = new JSONArray();
        List<Map<String, Object>> newslist = delegateMapper.selectList("com.yan.common.login.mapper.LoginCustomMapper.getnewslist");
        for(Map<String,Object> m :newslist){
            JSONObject jsonobj = new JSONObject();
            jsonobj.putAll(m);
            jsonArray.add(jsonobj);
        }
        // jsonobj.put("username",1);
        // JSONObject jsonobj1 = new JSONObject();
        //jsonobj1.put("chen",1);
        return JSONUtils.toJSONString(jsonArray);
    }

}
