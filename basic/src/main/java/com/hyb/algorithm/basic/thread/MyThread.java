package com.hyb.algorithm.basic.thread;

import java.util.concurrent.locks.LockSupport;

public class MyThread  extends Thread {
    private String name;

    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("thread is name="+name+"    i="+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1=new MyThread("thread1 ");
        MyThread myThread2=new MyThread("thread2 ");
        MyThread myThread3=new MyThread("thread3 ");


        myThread2.start();
        myThread3.start();


        myThread1.start();
        myThread1.join();

        myThread1.start();

    }
}
