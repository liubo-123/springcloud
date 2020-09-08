package com.example.demo.controller;

import com.example.demo.dto.Result;
import com.example.demo.dto.User;
import com.example.demo.service.IConsumerService;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

@Controller
public class ConsumerController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IConsumerService service;

    @RequestMapping(value="/findUser1",method = RequestMethod.GET)
    @ResponseBody
    public String finnUser1(HttpServletRequest res) {
        Map map = new HashMap();
        List<User> list = new ArrayList<User>();
        try {
            Result result = new Result();
            list = service.findUser();
            logger.info("user1===========" + JsonUtil.toJson(list));
        }catch (Exception e){
           e.printStackTrace();
           map.put("msg",e.getMessage());
        }
        map.put("list",list);

        return JsonUtil.toJson(map);
    }



}
