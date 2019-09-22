package com.hyb.algorithm.priorityqueue.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过SingleThreadExecutor让线程顺序执行
 */
public class ThreadPoolDemo {

    private static ExecutorService executor= Executors.newSingleThreadExecutor();


    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理开始规划需求！");
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("程序员开始开发！");
            }
        });

        Thread thred3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试人员开始测试新功能");
            }
        });


        System.out.println("测试人员来了！！！");
        System.out.println("产品经理来了！！！！");
        System.out.println("程序员来喽！！！！！");

        executor.submit(thread1);
        executor.submit(thread2);
        executor.submit(thred3);

        executor.shutdown();
    }
}
