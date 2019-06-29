package cn.meng.dong.controller;

import cn.meng.dong.service.SchedulerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-04-04 10:08
 * @ClassName SchedulerController
 * @Description TODO
 **/
@RestController
public class SchedulerController {
    @Autowired
    private SchedulerTask schedulerTask;

    private String cron = " */5 * * * * ?";

    @RequestMapping("/start")
    public String startScheduler(String start) {
        return schedulerTask.startTask(cron);
    }
}

