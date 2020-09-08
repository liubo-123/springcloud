package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.service.IConsumerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConsumerServiceImpl implements IConsumerService {
    @Override
    public String test() {
        return "暂无数据";
    }

    @Override
    public String findUserByNameAndPwd(String username, String password) {
        return "暂无数据";
    }

    @Override
    public String findUserTest(User user) {
        return "暂无数据";
    }

    @Override
    public List<User> findUser() {
        User user = new User();
        user.setPassword("111");
        user.setUsername("aaaa");
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }
}
