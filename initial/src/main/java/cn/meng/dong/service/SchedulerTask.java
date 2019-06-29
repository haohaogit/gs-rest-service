package cn.meng.dong.service;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @CopyRightBy zcy.qyg.cn
 * @InterfaceName SchedulerTask
 * @Description TODO
 * @Author DongQing
 * @Date 2019-04-04 10:26
 **/

public interface SchedulerTask {
    String startTask(String cron);

    void dingTask (String cron);

}
