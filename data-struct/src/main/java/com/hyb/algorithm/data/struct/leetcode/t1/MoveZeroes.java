package com.hyb.algorithm.data.struct.leetcode.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes3(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public void moveZeroes(int[] nums) {
        List<Integer> noZeroList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            noZeroList.add(nums[i]);
        }

        for (int i = 0; i < noZeroList.size(); i++) {
            nums[i] = noZeroList.get(i);
        }

        for (int i = noZeroList.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public void moveZeroes2(int[] nums) {

        int k = 0; //[0,k)  均为非0元素；

        //遍历到i后 保证[0...i]中的非0元素都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public void moveZeroes3(int[] nums) {

        int k = 0; //[0,k)  均为非0元素；

        //遍历到i后 保证[0...i]中的非0元素都按照顺序排列在[0...k)中
        //同时保证[k,i]中的元素都是0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (i != k) {
                swap(nums, k, i);
            }
            k++;
        }
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
