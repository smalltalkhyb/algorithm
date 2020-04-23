package com.hyb.algorithm.data.struct.leetcode.t1;


/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class OddEvenArray {

    public int[] exchange(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            while (nums[right] % 2 == 0 && left < right) {
                right--;
            }
            while (nums[left] % 2 != 0 && left < right) {
                left++;
            }

            swap(nums, left, right);

        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        OddEvenArray oddEvenArray = new OddEvenArray();
        oddEvenArray.exchange(array);

        for (int entity : array) {
            System.out.print(entity + ",");
        }
    }
}
