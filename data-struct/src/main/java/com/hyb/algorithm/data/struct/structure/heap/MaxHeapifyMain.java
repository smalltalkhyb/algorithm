package com.hyb.algorithm.data.struct.structure.heap;

import java.util.HashMap;
import java.util.Random;

public class MaxHeapifyMain {


    private  static  double testHeapify(Integer[] arr,boolean isHeapify){

        long startTime=System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap=new MaxHeap<Integer>(arr);
        }else {
            maxHeap=new MaxHeap<>();
            for(int i=0;i<arr.length;i++){
                maxHeap.add(arr[i]);
            }
        }

        int[] retArr = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            retArr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < retArr.length ; i ++)
            if(retArr[i-1] < retArr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime=System.nanoTime();


        return (endTime-startTime)/1000000000.00;
    }

    public static void main(String[] args) {


        Random random=new Random();
        int n=1000000;

        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=random.nextInt(Integer.MAX_VALUE);
        }

        double time1=testHeapify(arr,false);
        System.out.println("with no heapify spend times="+time1);

        double time2=testHeapify(arr,true);
        System.out.println("with heapify spend times="+time2);

    }
}
