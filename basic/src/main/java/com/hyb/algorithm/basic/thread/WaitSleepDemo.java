package com.hyb.algorithm.basic.thread;

public class WaitSleepDemo {


    public static void main(String[] args) throws InterruptedException {

        Object lock=new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("A  thread start");
                synchronized (lock){
                    System.out.println("A  thread get lock");
                    try {
                        Thread.sleep(30);

                       // lock.wait(1000);
                        lock.wait();

                        System.out.println("A  thread done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        Thread.sleep(10);


        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("B  thread start");

                synchronized (lock){
                    System.out.println("B thread get lock");
                    try {
                        Thread.sleep(3000);

                        System.out.println("B  thread done");

                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
