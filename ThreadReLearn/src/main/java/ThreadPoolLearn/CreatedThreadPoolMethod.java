package ThreadPoolLearn;

import java.security.AccessController;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程池方式
 */
public class CreatedThreadPoolMethod {
    public static void main(String[] args) {
        // 先创建固定线程数的线程池  阿里并不推荐使用这个固定线程池
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        // 创建缓存线程池 线程数量取决于任务数量
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        // 单例线程
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        // 异步线程
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    }

}
