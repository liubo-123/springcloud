package com.example.demo.service;

import com.example.demo.dto.User;
import com.example.demo.service.impl.ConsumerServiceImpl;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "client-serverA",fallback= ConsumerServiceImpl.class)
public interface IConsumerService {
    @RequestMapping("/test")
    String test();

    @RequestMapping(value = "/login" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String  findUserByNameAndPwd(@RequestParam String username,@RequestParam String password);
    @RequestMapping(value = "/findUserTest" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String  findUserTest(@RequestBody User user);
    @RequestMapping(value = "/findUser" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<User> findUser();

}
