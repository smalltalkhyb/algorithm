package com.hyb.algorithm.data.struct.structure.sort;

import java.util.Random;

public class QuickSort {

    private static Random random = new Random();

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 10000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0,10);
        //Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 10);
        //Integer[] arr = new Integer[]{46, 23, 45, 17, 6, 40, 22, 17, 30, 24};
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.QuickSort", arr);

        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);
    }


    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    //递归使用快速排序，对arr[left...right]的范围进行排序
    private static void quickSort(Comparable[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);

    }

    // 对arr[left...right]部分进行partition操作
    //返回partitionIndex 是的arr[left...partition-1]<arr[partitionIndex];  arr[partion+1...r]>arr[partitionIndex]
    private static int partition(Comparable[] arr, int left, int right) {

        //Comparable v = arr[left];
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot

        //(int) (Math.random() * (right - left + 1)) + left
        Integer randomIndex = left + random.nextInt(right - left + 1);
        SortTestHelper.swap(arr, left, randomIndex);
        Comparable v = arr[left];
        int partitionIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i].compareTo(v) < 0) {
                SortTestHelper.swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }

        arr[partitionIndex] = v;

        return partitionIndex;
    }


}
