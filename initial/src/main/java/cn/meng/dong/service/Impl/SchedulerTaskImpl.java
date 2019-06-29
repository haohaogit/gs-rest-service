package cn.meng.dong.service.Impl;

import cn.meng.dong.ThreadHelper.SchedulerSendTask;
import cn.meng.dong.service.SchedulerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-04-04 11:07
 * @ClassName SchedulerTaskImpl
 * @Description to descript  scheduler task how to work
 **/
@Service
public class SchedulerTaskImpl implements SchedulerTask {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Override
    public String startTask(String cron) {

        SchedulerSendTask schedulerSendTask = new SchedulerSendTask();
        ScheduledFuture future = threadPoolTaskScheduler.schedule(schedulerSendTask, new CronTrigger(cron));
        return new Date().toString();
    }

    @Override
    public void dingTask(String cron) {

    }
}
