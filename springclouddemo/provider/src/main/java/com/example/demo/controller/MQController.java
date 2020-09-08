package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.service.IProviderService;
import com.example.demo.util.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MQController {
    @Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private StringRedisTemplate redisTemplate;
    @Autowired
    IProviderService service;
    @RequestMapping("/test01")
    @ResponseBody
    public String test(String phone01){
        Map map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
            amqpTemplate.convertAndSend("phoneEX","phone",phone01);
            map.put("phone",phone01);

            //更新数据库操作


        return JsonUtil.toJson(map);
    }
    @RequestMapping("/redis")
    @ResponseBody
    public String redisdemo(){
        redisTemplate.opsForValue().set("phone","100");
        return  redisTemplate.opsForValue().get("phone");
    }
}
