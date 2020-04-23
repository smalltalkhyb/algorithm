package com.hyb.algorithm.basic;

import java.util.concurrent.locks.ReentrantLock;

public class Excel implements IOffice {

    public void start(){
        System.out.println("excel start!");

        ReentrantLock t=new ReentrantLock();


    }
}
