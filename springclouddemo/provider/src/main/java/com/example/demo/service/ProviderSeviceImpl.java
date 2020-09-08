package com.example.demo.service;

import com.example.demo.dto.User;
import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProviderSeviceImpl implements IProviderService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserMapper mapper;

    @Override
    public String test() {
        String a ="abc";
        return a;
    }

    @Override
    public int test01() {
        return 0;
    }
    @Override
    public int addUser(User user) {
        return mapper.addUser(user.getUsername(),user.getPassword());
    }



    @Override
    public String findUserByNameAndPwd(String username,String password) {
       // System.out.println(mapper.findUserByNameAndPwd(user));
        //logger.info("user;====="+user.toString());
        //logger.info("serviceimo;====="+mapper.findUserByNameAndPwd(username,password));
        return mapper.findUserByNameAndPwd(username,password);
        //return 1;
    }

    @Override
    public String findUserTest(User user) {
        return mapper.findUserTest(user);
    }

    @Override
    public List<User> findUser() {
        List<User> user = mapper.findUser();
        return user;
    }

    @Override
    public int findUserByName(User user) {
        return 0;
    }
    @Transactional
    @Override
    public String findPrince() {
        mapper.findPrince();
        int i=0;
        int j=5;
        int k=j/i;
        return mapper.findPrince();
    }
}
