package com.hyb.algorithm.data.struct.structure.heap;

import java.util.*;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 使用java 的 PriorityQueue 实现  top k
 *
 * java 中的PriorityQueue 默认是最小堆 ，可以用类实现Comparable 接口 也可以用java 中的
 *  比较器Comparator 然后通过构造函数的方式注入 也可以使用lamda表达式 这样做的好处是
 *  比如PriorityQueue<String> 要修改String 的比较函数CompareTo，我们是无法修改的，但是我们可以
 *  通过Comparetor 比较器注入来实现
 *
 */
public class TopFreqJavaMain {


    private class  Freq{
        int e,freq;

        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }
    }

//    private class FreqComparator implements Comparator<Freq>{
//
//        @Override
//        public int compare(Freq o1, Freq o2) {
//            return o1.freq-o2.freq;
//        }
//    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,1,1,2,2,3};

        List<Integer> topList=(new TopFreqJavaMain()).topKFrequent(arr,2);

        System.out.println(topList);
    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(freqMap.containsKey(val)){
                freqMap.put(val,freqMap.get(val)+1);
                continue;
            }
            freqMap.put(val,1);
        }

        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.freq-o2.freq;
            }
        });


        for(Integer key:freqMap.keySet()){
            if(priorityQueue.size()<k){
                priorityQueue.add(new Freq(key,freqMap.get(key)));
                continue;
            }

             Freq top= priorityQueue.peek();
            if(freqMap.get(key)>top.freq){
                priorityQueue.remove();
                priorityQueue.add(new Freq(key,freqMap.get(key)));
            }
        }

        List<Integer> retList=new ArrayList<>();
        for(int i=0;i<k;i++){
            retList.add(priorityQueue.remove().e);
        }

        return  retList;

    }
}
