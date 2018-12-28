package dong.controller;

import dong.aop.LoginValidate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName LoginCOntroller
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-26 17:55
 **/
@RestController
public class LoginController {

    /**
     *
     * 功能描述: 验证注解是否生效 （@LoginValidate）
     *
     * @param:
     * @return:
     * @auther: dongQing
     * @date: 2018-12-26 19:19
     */
    @LoginValidate
    @RequestMapping("/login")
    public String loginValidate1() {
        return "login validate test";
    }
}
