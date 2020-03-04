package com.hyb.algorithm.basic.jvm;

import java.util.concurrent.*;

public class ThreadPoolStudy {

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(2,
                4,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),new ThreadPoolExecutor.DiscardOldestPolicy());


    }



    private synchronized void   test(){

    }


}
