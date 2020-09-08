package com.example.demo.service;

import com.example.demo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "client-serverA")
public interface IConsumerService {
    @RequestMapping(value = "/findUser" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<User> findUser();

}
