package com.hyb.algorithm.data.struct.structure.sort;

public class SelectionSort {

    private SelectionSort() {

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 9, 8, 7, 20, 16, 5, 4, 3, 2, 1};


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);

        System.out.println("----------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

        System.out.println("----------------");
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arrTest = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.SelectionSort", arrTest);

        return;

    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (i == minIndex)
                continue;
            SortTestHelper.swap(arr, i, minIndex);
        }
    }

    private void swap(Object[] arr, int src, int dest) {
        Object temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;

    }
}
