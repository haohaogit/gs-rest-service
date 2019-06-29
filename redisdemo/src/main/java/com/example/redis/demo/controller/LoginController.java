package com.example.redis.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName LoginController
 * @Description TODO
 * @Author DongQing
 * @Date 2019-01-05 20:10
 **/
@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login success";
    }

}
