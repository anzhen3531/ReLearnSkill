import com.alibaba.ttl.TransmittableThreadLocal;

public class UserContextHolder {

    // 这个无法进行跨线程传递
    // public static final ThreadLocal<String> local = new ThreadLocal<>();
    // 这个无法在线程池中进行传递
    // public static final InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
    // 使用阿里TTL
    public static final TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();

    public void setContext(String str) {
        local.set(str);
    }

    public String getContext() {
        return local.get();
    }
}
