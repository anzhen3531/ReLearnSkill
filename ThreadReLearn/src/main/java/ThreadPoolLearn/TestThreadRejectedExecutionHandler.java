package ThreadPoolLearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池的拒绝策略
 */
public class TestThreadRejectedExecutionHandler {
    public static void main(String[] args) {
        System.out.println("TestThreadRejectedExecutionHandler :" + Thread.currentThread().getName());
        // 创建一个核心线程数和最大线程数都为1的线程池
        ExecutorService poolExecutor = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());
        poolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "run ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "执行线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "执行线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutor.shutdown();
    }
}
