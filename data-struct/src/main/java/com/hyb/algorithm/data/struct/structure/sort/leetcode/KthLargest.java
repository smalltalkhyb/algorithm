package com.hyb.algorithm.data.struct.structure.sort.leetcode;

import com.hyb.algorithm.data.struct.structure.sort.SortTestHelper;

public class KthLargest {

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{3, 2, 1, 5, 6, 4};
        Integer[] arr = new Integer[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.sort(arr, 4));

        SortTestHelper.printArray(arr);
    }

    private int sort(Integer[] arr, int topK) {
        return quickSort(arr, 0, arr.length - 1, topK);
    }

    private int quickSort(Integer[] arr, int left, int right, int topK) {

        if (left >= right) {
            return 0;
        }


        int swapIndex = (int) (Math.random() * (right - left + 1)) + left;
        swap(arr, left, swapIndex);
        int v = arr[left];

        int lt = left;  // arr[l+1...lt] < v
        int gt = right + 1; //  arr[gt...r] > v
        int et = left + 1;// arr[lt+1...i) == v

        while (et < gt) {

            if (arr[et].compareTo(v) < 0) {
                swap(arr, et, lt + 1);
                et++;
                lt++;
                continue;
            }

            if (arr[et].compareTo(v) > 0) {
                swap(arr, et, gt - 1);
                gt--;
                continue;
            }
            //arr[et].compareTo(v) == 0
            et++;
        }

        swap(arr, left, lt);


        quickSort(arr, left, lt - 1, topK);
        quickSort(arr, gt, right, topK);


        return arr[lt];

    }


    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
