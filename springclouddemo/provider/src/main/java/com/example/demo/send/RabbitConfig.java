package com.example.demo.send;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
 public class RabbitConfig {
      public final static String QUEUE_NAME = "phone";

            @Bean//声明一个队列
            public Queue helloQueue(){
               return new Queue(QUEUE_NAME);

             }
             @Bean
             public DirectExchange ex01(){
                return new DirectExchange("phoneEX");
             }
    @Bean
    public Binding bind01(){
        return BindingBuilder.bind(helloQueue()).to(ex01()).with(QUEUE_NAME);
    }

         }