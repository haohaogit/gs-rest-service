package dong;

import org.junit.Test;
import cn.meng.dong.utils.DefaultThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName dong.ThreadPoolTest
 * @Description to have a deep understand for threadpool constructor function.
 *              （以下所有线程池测试的最大闲置时间均为 5 秒）
 * @Author DongQing
 * @Date 2018-12-23 09:05
 **/
public class ThreadPoolTest {

    /**
     *
     * 功能描述: 以下所有的测试任务都是 先睡眠2秒钟，然后打印该线程名称
     *
     */
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     *
     * 功能描述: 作为验证的模版， 先开三个线程，查看当前线程池中 核心线程数、线程池大小、以及队列中缓存的任务数量；
     *          然后 再开三个线程，查看当前线程池中 核心线程数、线程池大小、以及队列中缓存的任务数量；
     *          然后，延迟8秒钟，（因为线程池设定的最长闲置时间为5秒，延迟8秒后，非核心线程会释放掉），再次查看线程池的各状态信息；
     *
     * @param: ThreadPoolExecutor executor
     */
    public void validateTemplate(ThreadPoolExecutor executor) {
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("先开三个线程------------");
        System.out.println("核心线程数 = "+executor.getCorePoolSize());
        System.out.println("线程池中线程数 = "+executor.getPoolSize());
        System.out.println("队列中的任务数量 = "+executor.getQueue().size());

        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("再开三个线程------------");
        System.out.println("核心线程数 = "+executor.getCorePoolSize());
        System.out.println("线程池中线程数 = "+executor.getPoolSize());
        System.out.println("队列中的任务数量 = "+executor.getQueue().size());

        // 睡眠/延迟 8 秒
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("核心线程数 = "+executor.getCorePoolSize());
        System.out.println("线程池大小 = "+executor.getPoolSize());
        System.out.println("队列中的任务数量 = "+executor.getQueue().size());
    }

    /**
     *
     * 功能描述: 核心线程为6，最大线程为10，超时时间为5，缓存队列为 SynchronousQueue()
     * 期望:  1、核心线程刚好被使用完；2、核心线程不会被释放；3、没有达到/使用到最大线程数；4、队列为空；5、缓存队列用不到
     *
     */
    @Test
    public void threadpoolTest1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述:  核心线程为6，最大线程为10，超时时间为5，缓存队列为 LinkedBlockingQueue()
     * 期望:  1、核心线程刚好被使用完；2、核心线程不会被释放；3、没有达到/使用到最大线程数；4、队列为空；5、缓存队列用不到
     *
     */
    @Test
    public void threadpoolTest2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 核心线程为3，最大线程为6，超时时间为5，缓存队列为 LinkedBlockingQueue()
     * 期望:  1、核心线程使用完；2、核心线程不会被释放；3、用到缓存队列；
     *       4、核心线程使用完后，新来的任务先放到队列中，核心线程处理完当前任务后到队列中取新任务；
     *       5、不会启用非核心线程；
     *
     */
    @Test
    public void threadpoolTest3() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 核心线程为3，最大线程为6，超时时间为5，缓存队列为 SynchronousQueue()
     * 期望:  1、核心线程使用完；2、核心线程不会被释放；3、用不到缓存队列；
     *       4、核心线程使用完后，新来的任务会开启新的线程（非核心线程），直到达到最大线程数；
     *       5、刚好用完非核心线程；
     *
     */
    @Test
    public void threadpoolTest4() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 核心线程为3，最大线程为4，超时时间为5，缓存队列为 SynchronousQueue()
     * 期望:  1、核心线程刚好被使用完；2、核心线程不会被释放；3、用不到缓存队列；
     *       4、核心线程使用完后，新来的任务会开启新的线程（非核心线程），直到达到最大线程数,超出后会报异常；
     *
     * 原因分析: 创建第五个线程时出错，因为SynchronousQueue() 根本不保存线程
     */
    @Test
    public void threadpoolTest5() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 核心线程为3，最大线程为4，超时时间为5，缓存队列为 LinkedBlockingQueue()
     * 期望:  1、核心线程刚好被使用完；2、核心线程不会被释放；3、用到缓存队列；
     *       4、核心线程使用完后，新来的任务会存放放到 LinkedBlockingQueue() 队列中，
     *          若LinkedBlockingQueue() 没有大小限制，程序不会受到最大线程的影响，即新来的任务都会先存到队列中，不会启用非核心线程；
     *          若LinkedBlockingQueue() 有大小限制，则新任务会先存放到队列中，超出队列容量后，会启用非核心线程，直到超出最大线程数后出现异常；
     *
     */
    @Test
    public void threadpoolTest6() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 创建一个线程工厂 生产 特定格式的线程；
     *
     * @param:
     * @return: new Thread（）实例
     */
    private static ThreadFactory factory = new ThreadFactory() {
        private final AtomicLong along = new AtomicLong();
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"my ThreadPool thread: "+along.incrementAndGet());
        }
    };

    /**
     *
     * 功能描述: test ThreadFactory
     *
     */
    @Test
    public void threadFactoryTest() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(), factory);
        validateTemplate(executor);

//        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,
//                new LinkedBlockingDeque<Runnable>(), new DefaultThreadFactory());
//        validateTemplate(executor1);

    }

    /**
     *
     * 功能描述: 自定义一个线程池拒绝策略；
     *
     */
    class myRejectExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if(r instanceof Runnable) {
//                System.out.println(r.getClass());
                System.out.println(" ************   Do nothing! That's my rejected strategy.    *****************");
            }
        }
    }

    /**
     *
     * 功能描述: 测试自定义拒绝策略
     *
     */
    @Test
    public void rejectExecutionHandlerTest() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1),
                new myRejectExecutionHandler());
        validateTemplate(executor);
    }

    /**
     *
     * 功能描述: 测试RejectedExecutorHandler 自有的拒绝策略
     *
     */
    @Test
    public void rejectedExecutorhandlerByItselfTest() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1),
                new ThreadPoolExecutor.CallerRunsPolicy());
        validateTemplate(executor);
    }



}
