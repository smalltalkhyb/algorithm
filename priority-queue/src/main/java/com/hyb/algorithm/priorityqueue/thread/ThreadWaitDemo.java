package com.hyb.algorithm.priorityqueue.thread;

public class ThreadWaitDemo {

    private static final  Object lock1=new Object();
    private static  final  Object lock2=new Object();



    /**
     *  如果没有状态标识，当t1已经运行完了t2才运行，t2在等待t1唤醒导致t2永远处于等待状态
     *
     */

    private static  Boolean t1Run=false;
    private static Boolean t2Run=false;


    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("产品经理开始规划新需求！");
                    t1Run=true;
                    lock1.notify();
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock1) {
                    if (!t1Run) {
                        try {
                            System.out.println("开发人员先休息一会！");
                            lock1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    synchronized (lock2) {
                        System.out.println("开发人员开始开发。。。。");
                        t2Run = true;
                        lock2.notify();
                    }
                }
            }
        });


        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    if(!t2Run){
                        try {
                            System.out.println("测试人员先休息一会！");
                            lock2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    System.out.println("测试人员开始测试新功能......");
                }
            }
        });


        System.out.println("早上");

        System.out.println("测试人员到了。。。。");
        thread3.start();

        System.out.println("开发人员到了。。。。");
        thread2.start();


        System.out.println("产品人员到了.....");
        thread1.start();


    }
}
