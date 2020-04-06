package com.hyb.algorithm.basic.cl;

public class ThreadOutMemory {

    public static void main(String[] args) {

        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                   while (true){

                   }

                }
            }).start();
        }
    }
}
