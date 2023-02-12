# Spring 6

## 面试题

1. Spring中用到了那些设计模式 

   > 代理 ，单例 ，工厂

2. Spring的事务隔离级别有哪几种

   > 5种 

   1. ISOLATION_DEFAULT:
      1. 用底层数据库的设置隔离级别，数据库设置的是什么我就用什么
   2. ISOLATION_READ_UNCOMMITTED:
      1. 读未提交，最低事务隔离级别、事务未提交时，就可被其他事务读取（会出现幻读，脏读，不可以重复读）
   3. ISOLATION_READ_COMMITTED：
      1. 已提交读取, 事务提交时才会读取（会造成幻读，不可重复读），SQL SERVER 默认隔离级别
   4. ISOLATION_REPEATABLE_READ：
      1. 可重复读，一个事务提交后，并且另一个事务提交之后才可以读取上一个事务的值。会发生幻读   Mysql默认隔离级别
   5. ISOLATION_SERIALIZABLE ：
      1. 序列化，代价最高的事务隔离级别，该事务防止脏读、不可重复读、幻读

3. Spring的事务的传播方式有几种

   7种：

   1.Propagation.REQUIRED：

   ​			默认的事务传播级别，它表示如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
   2.Propagation.SUPPORTS：

   ​			如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。

   3.Propagation.MANDATORY：（mandatory：强制性）

   ​			如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
   4.Propagation.REQUIRES_NEW：

   ​				表示创建一个新的事务，如果当前存在事务，则把当前事务挂起。也就是说不管外部方法是否开启事务，Propagation.REQUIRES_NEW 修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰。
   5.Propagation.NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
   6.Propagation.NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
   7.Propagation.NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 PROPAGATION_REQUIRED。

   

4. Spring的核心组件有哪些？？

   > Ioc、 AOP 

5. Spring的Bean生命周期了解吗 ？？ 

   > 

6. Spring的如何解决的循环依赖的问题

   三级缓存+懒加载

7. Spring的IoC容器的实现叫什么？？ 

   DI 依赖注入

   





## 1、概述

### 1.1、什么是Spring ?

Spring是一个分层、面向切面的Java应用程序的一站式轻量级解决方案，他是Spring核心技术栈的基础和核心，是为解决企业开发的复杂性而创建的

Spring有两个核心模块  `IOC` 和 `AOP`

IOC: 是 inverse of  Control 翻译为： 控制反转，是把创建对象的过程交给Spring进行管理 

AOP （Aspect Oriented Programing）：面向切面编程

### 1.2、Spring 的特点

- 非侵入式
- 控制反转 IOC
- 面向切面编程 AOP
- 容器
- 组件化
- 一站式



## 2、IoC (Inverse of Control)

### 2.1、Ioc 概述

Spring通过IoC容器来管理所有项目的Java对象的实例化和初始化，控制对象与对象之间的关系 松耦合 



### 2.2、Ioc 作用





### 2.3、DI 依赖注入

Dependency Injection 实现了控制反转的思想，DI是IoC的具体实现方式

依赖注入的两种方式

1. set注入
2. 构造器注入

Bean管理：Bean对象的创建，以及Bean对象属性的赋值



## 3、SpringBean生命周期

详解查看图片

https://img2020.cnblogs.com/blog/1369022/202110/1369022-20211025232159069-1664351264.png





## 4、Spring的事务隔离级别以及传播级别

Spring有多少种事务隔离级别 ？？

5种

默认 

可重复读

读未提交

读提交

蓄力恶化

### 4.1、Spring事务失效的场景



### 4.2、事务传播机制

- Propagation.REQUIRED （需要）
  - 默认的事务传播级别，它表示如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
- Propagation.SUPPORTS （支持）
  - 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
- Propagation.MANDATORY （强制）
  - （mandatory：强制性）如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
- Propagation.REQUIRES_NEW （需要新的事务）
  - 表示创建一个新的事务，如果当前存在事务，则把当前事务挂起。也就是说不管外部方法是否开启事务，**Propagation.REQUIRES_NEW 修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰。**
- Propagation.NOT_SUPPORTED （不支持）
  - 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
- Propagation.NEVER （没有事务）
  - 以非事务方式运行，如果当前存在事务，则抛出异常。
- Propagation.NESTED （嵌套）
  - 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于PROPAGATION_REQUIRED

## 5、Spring 的AOP编程

