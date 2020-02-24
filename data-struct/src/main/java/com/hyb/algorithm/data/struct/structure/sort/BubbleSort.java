package com.hyb.algorithm.data.struct.structure.sort;

public class BubbleSort {

    private BubbleSort() {

    }

    public static void main(String[] args) {
        //Integer arr[] = new Integer[]{7, 6, 3, 4, 10, 6, 7, 8, 9, 10};

        Integer arr[] = SortTestHelper.generateRandomArray(100, 0, 1000);
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.BubbleSort", arr);

        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);

    }

    public static void sort(Comparable[] arr) {

        int end = arr.length ;
        int last = 0;
        for (int i = 0; i < arr.length; i++) {
            last = 0;
            for (int j = 1; j < end; j++) {
                if (arr[j - 1].compareTo(arr[j]) < 0) {
                    continue;
                }
                SortTestHelper.swap(arr, j - 1, j);
                last = j;// 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑

            }

            if (last > 0) {
                end = last;
            }
        }
    }


    //改进版的 冒泡算法  如果本来有序 就不用循环了
    public static void sort2(Comparable[] arr) {

        int lastSwap = 0;
        int n = arr.length;
        do {
            lastSwap = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) < 0) {
                    continue;
                }
                SortTestHelper.swap(arr, i - 1, i);
                //记录最后一次替换操作，下次循环直接跳过
                lastSwap = i;
            }

            n = lastSwap;

        } while (lastSwap > 0);

    }


}
