package com.example.demo.controller;

import com.example.demo.dto.Result;
import com.example.demo.dto.User;

import com.example.demo.service.IConsumerService;
import com.example.demo.util.JsonUtil;
;
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
public class ConsumerController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IConsumerService service;
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return service.test();
    }
    @RequestMapping("/index")
     public String test01() {
        return "index";
    }
    @RequestMapping("/index01")
    public String test02() {
        return "login";
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public String finnUser(HttpServletRequest res,HttpSession session) {
        String username =res.getParameter("username");
        String password =res.getParameter("password");
        Result result = new Result();
        //User user = new User();
        if("".equals(username)){
            result.setMsg("用户名为空");
            result.setStatus(1);
        }
        if("".equals(password)){
            result.setMsg("密码为空");
            result.setStatus(2);
        }
        session.setAttribute("username",username);
       // user.setUsername(username);
       // user.setPassword(MD5Utils.md5(password));
       // user.setPassword(password);
        //System.out.println("user===="+JsonUtil.toJson(username));
        return service.findUserByNameAndPwd(username,password);
    }
    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    @ResponseBody
    public String finnUser1(HttpServletRequest res,HttpSession session) {
        List<User> list  = new ArrayList<User>();
        Result result = new Result();
        if(session.getAttribute("username")!=null) {
            list = service.findUser();
            logger.info("user1===========" + JsonUtil.toJson(list));
        }
        logger.info("session===========" + session.getAttribute("username"));
        return JsonUtil.toJson(list);
    }
    @RequestMapping(value="/findUserTest",method = RequestMethod.POST)
    @ResponseBody
    public String findUserTest(HttpServletRequest res,User user) {
        String username =res.getParameter("username");
        String password =res.getParameter("password");
        Result result = new Result();
        //User user = new User();
        if("".equals(username)){
            result.setMsg("用户名为空");
            result.setStatus(1);
        }
        if("".equals(password)){
            result.setMsg("密码为空");
            result.setStatus(2);
        }
         user.setUsername(username);
        // user.setPassword(MD5Utils.md5(password));
         user.setPassword(password);
        System.out.println("user===="+JsonUtil.toJson(user));
        return service.findUserTest(user);
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
