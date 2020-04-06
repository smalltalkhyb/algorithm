package com.hyb.algorithm.data.struct.leetcode.t1;


/**
 * 给定 nums = [3,2,2,3], val = 3,
 */
public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};

        int ret = new RemoveElement().removeElement2(nums, 3);
        System.out.println("length=" + ret);
        for (int i = 0; i < ret; i++) {
            System.out.print(nums[i] + ",");
        }
    }


    public int removeElement(int[] nums, int val) {

        int length = nums.length;

        int newPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newPos] = nums[i];
                newPos++;
            }
        }

        return newPos;
    }


    public int removeElement2(int[] nums, int val) {

        int newPos = nums.length - 1;

        int i = 0;

        while (i < newPos) {
            if (nums[i] == val) {
                nums[i] = nums[newPos];
                newPos--;
                continue;
            }

            i++;
        }

        return newPos+1;
    }
}
