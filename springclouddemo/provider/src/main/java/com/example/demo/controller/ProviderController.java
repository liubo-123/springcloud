package com.example.demo.controller;




import com.example.demo.dto.Result;
import com.example.demo.dto.User;
import com.example.demo.service.IProviderService;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProviderController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IProviderService service;
      @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String finnUser(HttpServletRequest res, HttpSession session) {
        String username =res.getParameter("username");
        String password =res.getParameter("password");
        Result result = new Result();
        User user = new User();
        if("".equals(username)){
            result.setMsg("用户名为空");
            result.setStatus(1);
        }
        if("".equals(password)){
            result.setMsg("密码为空");
            result.setStatus(2);
        }
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("user===="+JsonUtil.toJson(user));
        //
        String res1=service.findUserByNameAndPwd(username,password);
        logger.info("res1==========="+res1);
        if(!"".equals(res1) && res1!=null){
            result.setMsg("登录成功");
            result.setStatus(0);
        }else{
            result.setMsg("登录失败，用户名或密码不正确");
            result.setStatus(3);
        }
        logger.info("result==========="+JsonUtil.toJson(result));
        return JsonUtil.toJson(result);
    }
    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    @ResponseBody
    public String finnUser1(HttpServletRequest res,HttpSession session) {
        List<User> list = new ArrayList<User>();
        Result result = new Result();

            list = service.findUser();
            logger.info("user1===========" + JsonUtil.toJson(list));

        return JsonUtil.toJson(list);
    }
    @RequestMapping(value = "/findUserTest",method = RequestMethod.POST)
    @ResponseBody
    public String findUserTest(HttpServletRequest res,User user) {
        String username =res.getParameter("username");
        String password =res.getParameter("password");
        Result result = new Result();
        if("".equals(username)){
            result.setMsg("用户名为空");
            result.setStatus(1);
        }
        if("".equals(password)){
            result.setMsg("密码为空");
            result.setStatus(2);
        }
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("user===="+JsonUtil.toJson(user));
        //
        String res1=service.findUserTest(user);
        logger.info("res1==========="+res1);
        if(!"".equals(res1) && res1!=null){
            result.setMsg("登录成功");
            result.setStatus(0);
        }else{
            result.setMsg("登录失败，用户名或密码不正确");
            result.setStatus(3);
        }
        logger.info("result==========="+JsonUtil.toJson(result));
        return JsonUtil.toJson(result);
    }
    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    @ResponseBody
    public String addUser(HttpServletRequest res) {
        String username = res.getParameter("username");
        String pwd = res.getParameter("pwd");
        User user = new User();
        user.setPassword(pwd);
        user.setUsername(username);
        Result result = new Result();
        int i = service.addUser(user);
        if(i>0){
            result.setStatus(0);
            result.setMsg("插入成功");
        }else{
            result.setMsg("插入失败");
            result.setStatus(-1);
        }
        logger.info("user1==========="+JsonUtil.toJson(result));
        return JsonUtil.toJson(result);
    }
    @RequestMapping(value="/loginout")
    @ResponseBody
    public String loginout(HttpSession session) {
        session.invalidate();
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("注销成功");
        return JsonUtil.toJson(result);
    }

}
