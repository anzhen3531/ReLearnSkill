package ThreadLocalLearn;

/**
 * Thread Local Test
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        // 在异步或者是别的情况下  ThreadLocal 不会传递到别的线程中去 应为这个是线程私有的
        setUserInfo();
        System.out.println(Thread.currentThread().getName() + " print " + getUserInfo());
        // 从创建一条新线程中获取这个 上下文是没有设置进去的
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " print " + getUserInfo());
        }).start();
        // 创建线程池
    }

    /**
     * 设置上下文中数据
     */
    private static void setUserInfo() {
        UserContextHolder userContextHolder = new UserContextHolder();
        userContextHolder.setContext("test");
    }

    private static String getUserInfo() {
        UserContextHolder userContextHolder = new UserContextHolder();
        return userContextHolder.getContext();
    }
}
