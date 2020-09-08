package com.example.demo.controller;

import com.example.demo.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrasController {
    @Autowired
    IProviderService service;
    @RequestMapping("/find")
    @ResponseBody
    public String findPrince(){
        String prince = service.findPrince();
        return prince;
    }
}
