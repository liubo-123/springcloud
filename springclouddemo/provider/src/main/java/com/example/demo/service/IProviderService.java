package com.example.demo.service;

import com.example.demo.dto.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface IProviderService {
    //@RequestMapping("/test")
    String test();
    int test01();
    int addUser(User user);
    String findUserByNameAndPwd(String username,String password);
    String findUserTest(User user);
    List<User>  findUser();
    int findUserByName(User user);
    String findPrince();

}
