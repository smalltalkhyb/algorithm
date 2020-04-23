package com.hyb.algorithm.basic.thread;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.currentThread().sleep(1000);
        return "smalltalk";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
//        FutureTask<String> task=new FutureTask<String>(myCallable);
//        new Thread(task).start();
//
//        if (!task.isDone()){
//            System.out.println("task is not done!");
//        }
//        System.out.println(task.get());

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(myCallable);

        if (!future.isDone()) {
            System.out.println("future   is not  done");
        }

        System.out.println(" name=" + future.get());
    }
}
