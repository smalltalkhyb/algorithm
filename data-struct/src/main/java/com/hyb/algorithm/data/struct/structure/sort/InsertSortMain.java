package com.hyb.algorithm.data.struct.structure.sort;


/**
 * 在数组有序的情况下 插入排序的速度非常快
 * 甚至比 nlog(n)的算法还高
 * 插入排序 可以引申出 希尔排序，
 * 插入排序是每次先跟最近的第一个元素比较，希尔排序每次是跟第h个元素比较
 */
public class InsertSortMain {

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.InsertSortMain", arr);

        SortTestHelper.printArray(arr);
    }


    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) > 0) {
                    break;
                }

                SortTestHelper.swap(arr, j, j - 1);
            }
        }
    }
}
