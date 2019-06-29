package cn.meng.dong.controller;

import cn.meng.dong.annotations.AnalysisCount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-28 21:18
 * @ClassName AnalysisCountController
 * @Description TODO
 **/
@RestController
public class AnalysisCountController {

    @AnalysisCount(note = "获取聊天方法")
    @RequestMapping("/analysis")
    public String getUser(){
        return "haohao user aspect test";
    }
}
