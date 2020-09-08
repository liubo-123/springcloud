package com.example.demo.send;


import com.example.demo.dto.User;
import com.example.demo.service.IProviderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
      * @author liubo
      * @Title:消息接受者
      * @Description:
      * @date 2018/6/27 14:54
      */
@Component
  //监听hello队
@RabbitListener(queues = "phone")
class Receive {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    IProviderService service;

             //处理接受到的消息
             @RabbitHandler
             public void process(String str){
                 String name= str;
                 String count = redisTemplate.opsForValue().get("phone");
                 int cu=Integer.parseInt(count);
                 if(cu>0) {
                     redisTemplate.opsForValue().decrement("phone");
                     User user = new User();
                     user.setUsername(name);
                     user.setPassword("123");
                     System.out.println(user.toString());
                     int i = service.addUser(user);
                     System.out.println("Receiver:" + str);
                 }else{
                     System.out.println("Receiver:" + "此商品已售完");

                 }
             }
         }
