package com.hyb.algorithm.basic.thread;

public class YieldDemo {



    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<10;i++){
                    System.out.println("thread  name="+Thread.currentThread().getName()+" index="+i);
                    if(i==5){
                        Thread.yield();
                    }
                }
            }
        };


        Thread thread=new Thread(runnable,"A");
        Thread thread1=new Thread(runnable,"B");

        thread.start();
        thread1.start();


    }



}
