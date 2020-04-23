package com.hyb.algorithm.basic.thread;

public class ThreadStartAndRun {

    public static void attack(){
        System.out.println("fight");

        System.out.println("current thread="+Thread.currentThread().getName());


    }

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                attack();
            }
        });


        System.out.println("current thread="+Thread.currentThread().getName());

        t.run();

        t.start();
    }
}
