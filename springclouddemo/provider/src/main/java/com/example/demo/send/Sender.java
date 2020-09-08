package com.example.demo.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送者
 */
@Component
public class Sender {
    //通过注入的这个类来传递消息
     @Autowired
     private AmqpTemplate rabbitTemplate;

            public void send(){
                String context="";
                 //String context = "hello"+ new Date();
                 //System.out.println("Sender :"+ context);
                for (int i = 0; i <100; i++) {
                    context= "1823211120"+i+ new Date();
                }
                 //hello为创建的队列名,context为发送的消息
                 this.rabbitTemplate.convertAndSend("phone",context);
             }
}
