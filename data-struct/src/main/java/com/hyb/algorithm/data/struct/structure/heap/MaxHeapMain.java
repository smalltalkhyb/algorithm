package com.hyb.algorithm.data.struct.structure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxHeapMain {

    public static void main(String[] args) {

        Random random=new Random();

        int n=1000;

        MaxHeap<Integer> maxHeap=new MaxHeap<>();

        for(int i=0;i<n;i++){
            int r=Math.abs(random.nextInt(n));
            while (maxHeap.contains(r)){
                r=Math.abs(random.nextInt(n));
            }
            maxHeap.add(r);
        }

        List<Integer> integerList=new ArrayList<>(n);

        for(int i=0;i<n;i++){
            integerList.add(maxHeap.extractMax());
        }

        for(int i=1;i<n;i++){
            if(integerList.get(i)>integerList.get(i-1)){
                throw new IllegalArgumentException(" maxheap is error");
            }
        }

        for(int i=0;i<integerList.size();i++){
            System.out.print(integerList.get(i)+",");
        }
    }
}
