package com.hyb.algorithm.data.struct.structure.segement;


/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class NumArray {


    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(4, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
