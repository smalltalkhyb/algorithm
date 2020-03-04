package com.hyb.algorithm.data.struct.structure.sort.leetcode;

import com.hyb.algorithm.data.struct.structure.sort.SortTestHelper;

public class ReversePairs {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{7, 5, 6, 4};

        ReversePairs reversePairs = new ReversePairs();
        int ret = reversePairs.reversePairs(nums);

        System.out.println(ret);

        SortTestHelper.printArray(nums);
    }

    public int reversePairs(Integer[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(Integer[] nums, int left, int right) {

        int ret = 0;
        if (left >= right) {
            return ret;
        }


        int mid = (left + right) / 2;
        int ret1 = mergeSort(nums, left, mid);
        int ret2 = mergeSort(nums, mid + 1, right);
        int ret3 = merge(nums, left, right, mid);
        return ret1 + ret2 + ret3;
    }


    private int merge(Integer[] nums, int left, int right, int mid) {
        int ret = 0;

        int[] tempArr = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            tempArr[i - left] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;


        while (k <= right) {
            while (i > mid && j <= right) {
                nums[k] = tempArr[j - left];
                j++;
                k++;
                continue;
            }

            while (j > right && i <= mid) {
                nums[k] = tempArr[i - left];
                i++;
                k++;
                continue;
            }

            if (k > right) {
                break;
            }

            //当j 比i 小的时候，j 就应该比i 剩下的元素都要小 也就是 mid+1-i 个
            if (tempArr[i - left] > tempArr[j - left]) {
                nums[k] = tempArr[j - left];
                j++;
                k++;
                ret += (mid - i + 1);
                continue;
            }
            if (tempArr[i - left] <= tempArr[j - left]) {
                nums[k] = tempArr[i - left];
                i++;
                k++;
                continue;
            }
        }

        return ret;
    }
}
