package com.kou.controller;

import com.kou.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JIAJUN KOU
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "hello swagger";
    }


    //只要我们的接口中，返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping("/user")
    public User user(){
        User user=new User();
        user.setName("kou");
        user.setAge(18);
        return user;
    }

    @PostMapping
    @ApiOperation("hello2控制类")//在swagger中给controller添加注释
    public User hello2(@ApiParam("用户名") User user){
        return user;
    }

}
