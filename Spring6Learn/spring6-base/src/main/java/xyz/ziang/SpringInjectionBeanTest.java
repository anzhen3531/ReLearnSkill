package xyz.ziang;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInjectionBeanTest {

    @Test
    public void testInjection() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        Spring6Test spring6Test = (Spring6Test)context.getBean("spring6Test");
        // 使用对象调用方法
        spring6Test.testPrint();
    }

    @Test
    public void reflectCreateObject() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
        InstantiationException, IllegalAccessException {
        Class aClass = Class.forName("xyz.ziang.Spring6Test");
        Spring6Test spring6Test = (Spring6Test)aClass.getDeclaredConstructor().newInstance();
        System.out.println("spring6Test = " + spring6Test);
    }
}
