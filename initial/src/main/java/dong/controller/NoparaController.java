package dong.controller;

import dong.aop.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName NoparaController
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-26 11:14
 **/
@RestController
public class NoparaController {
    /*@Autowired
    private NoParamTest noParamTest;*/
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/add1")
    public String addData1(String deviceId) {
        return "success"+counter.getAndIncrement();
    }

    @RequestMapping("/add2")
    public String addData2(String deviceId) {
        return "success1";
    }
    @RequestMapping("/add3")
    public String addData3(String deviceId) {
        return "success2";
    }

    @RequestMapping("/second")
    @UserAccess(desc = "second")
    public Object second() {
        return "second dong.controller";
    }

}
