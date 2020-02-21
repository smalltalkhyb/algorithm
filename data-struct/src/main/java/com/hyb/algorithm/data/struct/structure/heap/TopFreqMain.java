package com.hyb.algorithm.data.struct.structure.heap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopFreqMain {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (freq > another.freq) {
                return -1;
            }

            if (freq < another.freq) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3,3,3,3,3};
        List<Integer> list = (new TopFreqMain()).topKFrequent(nums, 2);

        System.out.println(list);
    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (freqMap.containsKey(val)) {
                freqMap.put(val, freqMap.get(val) + 1);
                continue;
            }

            freqMap.put(val, 1);
        }


        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (Integer key : freqMap.keySet()) {
            if(priorityQueue.getSize()<k) {
                priorityQueue.enqueue(new Freq(key, freqMap.get(key)));
                continue;
            }

            Freq top=priorityQueue.getFront();

            if(freqMap.get(key)>top.freq){
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(key, freqMap.get(key)));
            }
        }

        List<Integer> topKList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKList.add(priorityQueue.dequeue().e);
        }

        return topKList;


    }
}
