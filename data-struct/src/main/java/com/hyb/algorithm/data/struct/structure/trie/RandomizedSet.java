package com.hyb.algorithm.data.struct.structure.trie;


import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> data;


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        data = new ArrayList();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if(map.containsKey(val)){
            return false;
        }
        data.add(val);
        int index = data.size() - 1;
        map.put(val, index);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        //将最后一个元素取出来 替换掉删除的元素
        int lastVal = data.get(data.size() - 1);
        int index = map.get(val);

        map.remove(val);
        data.remove(data.size() - 1);

        if (lastVal == val) {
            return true;
        }

        data.set(index, lastVal);
        map.put(lastVal, index);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(data.size());
        return data.get(index);
    }
}
