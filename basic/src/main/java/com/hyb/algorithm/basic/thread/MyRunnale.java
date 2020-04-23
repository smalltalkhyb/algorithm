package com.hyb.algorithm.basic.thread;

public class MyRunnale implements Runnable {

    private String name;

    public MyRunnale(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(" thread name="+name+"    i="+i);
        }
    }

    public static void main(String[] args) {
        MyRunnale myRunnale1=new MyRunnale("thread1");
        MyRunnale myRunnale2=new MyRunnale("thread2");
        MyRunnale myRunnale3=new MyRunnale("thread3");

        Thread t1=new Thread(myRunnale1);
        Thread t2=new Thread(myRunnale2);
        Thread t3=new Thread(myRunnale3);

        t1.start();
        t2.start();
        t3.start();

    }
}
