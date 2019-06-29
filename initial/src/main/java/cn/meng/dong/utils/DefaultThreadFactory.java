package cn.meng.dong.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName DefaultThreadFactory
 * @Description to explore ThreadFactory inner construction
 * @Author DongQing
 * @Date 2018-12-23 11:18
 **/
public class DefaultThreadFactory implements ThreadFactory {
    // 原子类 线程池编号
    private final static AtomicInteger poolNumber = new AtomicInteger(1);
    // 原子类 线程数目
    private final static AtomicInteger threadNumber = new AtomicInteger(1);
    // 线程组
    private final ThreadGroup group;
    // 线程名前缀
    private final String namePrefix;
    public DefaultThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        // 取得线程组
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        // 设置线程名前缀
        namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        // 真正创建线程的地方，设置线程的线程组和线程名称
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        // 设置为非守护线程，即用户线程
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        // 默认是正常优先级
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;

    }
}
