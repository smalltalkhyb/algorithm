package com.hyb.algorithm.data.struct.mianshi;

public class GCMainTest{


    private static final int _1MB = 1024 * 1024;

    /**
     * 参数 -Xms30M -Xmx30M -Xmn10M -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
     * @param args
     */
    public static void main(String[] args) throws InterruptedException{
        byte[] allocation1;

        allocation1=new byte[10*_1MB];

        byte[]  allocation2=new byte[8*_1MB];
    }
}

