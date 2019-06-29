package cn.meng.dong.ThreadHelper;

import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-04-04 10:05
 * @ClassName SchedulerSendTask
 * @Description TODO
 **/
public class SchedulerSendTask implements Runnable {

    @Override
    public void run() {
        System.out.println("定时任务要执行的方法 ：" + new Date());
    }
}
