package com.example.demo.mapper;

import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@Mapper
public interface UserMapper {
    //@Insert("insert into user_name (username,password) values(#{username},#{password})")
    int addUser(String username,String password);
   // @Select("select username,password from user_name where username=#{username} and password=#{password}")
    String findUserByNameAndPwd(String username,String password);
    String findUserTest(User user);
    List<User> findUser();
    @Select("select count(*) from user_name where username=#{username}")
    int findUserByName(User user);
    String findPrince();

}
