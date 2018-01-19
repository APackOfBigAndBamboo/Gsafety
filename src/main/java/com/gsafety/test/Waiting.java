package com.gsafety.test;

public class Waiting implements Runnable { // 实现了Runnable接口的类

    private Object waitObj; // 将在此对象上调用wait()方法。

    public Waiting(Object waitObj) { // 构造方法，传入一个对象的引用
        this.waitObj = waitObj;
    }

    public void run() { // 覆盖抽象方法run()
        String name = Thread.currentThread().getName();
        // 在调用wait()方法之前，向控制台输出一段文字
        System.out.println(name + "：线程将进入挂起状态，等待被别的线程唤醒……");
        try {
            synchronized (waitObj) {
                waitObj.wait(); // 调用wait方法
            }
        } catch (InterruptedException e) { // 捕捉异常并输出错误消息
            System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
            return; // 出错后线程将不再向下执行
        }
        // 线程一旦被唤醒，将继续执行代码，向控制台输出下一行文字。
        System.out.println(name + "：线程被唤醒了。");
    }

    public void notify(Notifier notifier) {

    }
}
