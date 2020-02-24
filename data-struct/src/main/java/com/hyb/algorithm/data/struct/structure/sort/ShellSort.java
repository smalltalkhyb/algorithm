package com.hyb.algorithm.data.struct.structure.sort;

/**
 * 插入排序的改进版
 *
 * https://www.bilibili.com/video/av17062242?from=search&seid=10483577144486914611
 */
public class ShellSort {


    private ShellSort() {

    }

    public static void main(String[] args) {
        //Integer[] arr = SortTestHelper.generateRandomArray(10, 1, 50);
        Integer[] arr = new Integer[]{46, 23, 45, 17, 6, 40, 22, 17, 30, 24};
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.ShellSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));

        SortTestHelper.printArray(arr);


    }

    public static void sort(Comparable[] arr) {

        int step = 3;
        int n = arr.length;
        int h = 0;

        while (step * h < n) {
            h = step * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                //对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h].compareTo(arr[j]) > 0) {
                        SortTestHelper.swap(arr, j - h, j);
                    }
                }
            }

            h /= step;
        }

    }
}
