package com.hyb.algorithm.priorityqueue.math;

import java.util.HashMap;
import java.util.Map;


/**
 * leetcode1. 两数之和--每天刷一道leetcode系列
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，
 * 并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]`
 */
public class TwoSumTest {

    public static void main(String[] args) {

        int[] tempArray = new int[]{2, 7, 11, 15};

        //int[] ret = twoSum(tempArray, 9);

       // System.out.println(ret);
    }


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
