package bean;

import java.util.HashMap;

public class AnnotationApplicationContext implements ApplicationContext {

    // 存储被@Bean标注的对象
    public static final HashMap<Class, Object> beanMap = new HashMap<>();

    @Override
    public Object getBean(Class clazz) {
        return beanMap.get(clazz);
    }

    // 设置包扫描规则
    /**
     * 扫描包路径
     * 
     * @param packagePath 路径
     */
    public AnnotationApplicationContext(String packagePath) {
        //
    }


}
