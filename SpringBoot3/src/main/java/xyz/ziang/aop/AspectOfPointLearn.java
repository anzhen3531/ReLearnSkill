package xyz.ziang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 定义一个切面
@Aspect
@Component
public class AspectOfPointLearn {

    /*
    定义一个切入点 在Controller执行
     */
    @Pointcut("execution (* xyz.ziang.controller.*.*(..))")
    // 运行时执行 任意返回值 包路径 任意类 任意方法 任意参数
    public void test() {}

    /**
     * 方法调用之前执行通知
     */
    // 在TEST方法之前执行
    @Before("test()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice...");
    }

    /**
     * 方法调用之后执行通知
     */
    @After("test()")
    public void afterAdvice() {
        System.out.println("afterAdvice...");
    }

    /**
     * 环绕通知 调用前和调用后都执行通知
     * 
     * @param proceedingJoinPoint
     */
    @Around("test()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("before");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("after");
    }
}
