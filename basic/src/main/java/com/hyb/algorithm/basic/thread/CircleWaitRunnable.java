package com.hyb.algorithm.basic.thread;

public class CircleWaitRunnable  implements Runnable {


    private String name;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        name="smalltalk";
    }


    public static void main(String[] args) throws InterruptedException {
        CircleWaitRunnable runnable=new CircleWaitRunnable();

        Thread t=new Thread(runnable);

        t.start();


        System.out.println("第一次："+runnable.name);



//        while (runnable.name==null){
//            Thread.currentThread().sleep(1000);
//        }

        t.join();

        System.out.println("第二次："+runnable.name);


    }
}
