package ThreadPoolLearn;

import java.util.concurrent.Callable;

/**
 * 创建线程方式
 */
public class CreateThreadMethod {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();
        // 开启一个线程
        new Thread(cat).start();
        new Thread(dog).start();
        System.out.println(Thread.currentThread().getName());
    }

    // 创建线程有几种方式 4种 线程池

}

// 继承 Thread类
class Cat extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "cat eat meat");
    }
}

// 实现 Runnable接口
class Dog implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "dog eat rice");
    }
}

/**
 * 实现Callable
 */
class Cow implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "Cow eat grass");
        return "grass";
    }
}
