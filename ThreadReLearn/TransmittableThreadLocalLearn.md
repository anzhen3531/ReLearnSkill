# Transmittable Thread Local Learn

## 1、描述

### 1.1、官网

> https://github.com/alibaba/transmittable-thread-local

全中文文档

## 2、解决什么问题

解决ThreadLocal在不同的线程传递问题

由于ThreadLocal是线程独有的，故在不同的线程中的ThreadLocal数据都是不同的，假设一个业务是需要传递这个ThreadLocal中的数据发往其他的服务

#### 解决方案1：`InheritableThreadLocal`

采用这个可以在线程中传递ThreadLocal

<img src="C:\Users\AnZhen\AppData\Roaming\Typora\typora-user-images\image-20230130201450180.png" alt="image-20230130201450180" style="zoom:33%;" /> 

查看这个类的源码得知：这个类在进行建立的时候便会复制别的线程中的ThreadMap到自己的Map中

#### 解决方案2：alibaba的TTL（`TransmittableThreadLocal`）

使用这个代替ThreadLocal即可，这个类本质上是继承自`InheritableThreadLocal`

所以可以直接代替

## 3、使用场景

需要在线程池中传递ThreadLocal即可使用 Alibaba的TTL工具





