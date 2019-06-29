package cn.meng.dong.controller;

import cn.meng.dong.annotations.Mytest;
import cn.meng.dong.domain.User;
import cn.meng.dong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-28 20:37
 * @ClassName userController
 * @Description TODO
 **/
@RestController
public class userController {
    @Autowired
    private UserService userService;

    // @Mytest
    @RequestMapping("/getUser")
    public String getUser(){
        userService.save("xiaotao");
        return "haohao user aspect test";
    }

    @RequestMapping("/getDetalInfo")
    public List<User> getDetailInfo(Integer age){
        return userService.getDetailInfo(age);
    }
}
