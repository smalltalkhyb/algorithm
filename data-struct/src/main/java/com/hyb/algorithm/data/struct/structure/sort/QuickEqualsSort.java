package com.hyb.algorithm.data.struct.structure.sort;

/**
 * 解决快速排序 大量重复元素性能问题
 */
public class QuickEqualsSort {

    public static void main(String[] args) {
        Integer N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        //Integer[] arr = new Integer[]{46, 23, 45, 17, 6, 40, 22, 17, 30, 24};
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.QuickEqualsSort", arr);

        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);
    }


    public static void sort(Comparable[] arr) {
        quickSortEq(arr, 0, arr.length - 1);
    }

    private static void quickSortEq(Comparable[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        Integer partitionIndex = partition(arr, left, right);
        quickSortEq(arr, left, partitionIndex - 1);
        quickSortEq(arr, partitionIndex + 1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {
        //随机选一个 povit
        int swapLeft = (int) (Math.random() * (right - left + 1) + left);
        SortTestHelper.swap(arr, left, swapLeft);

        Comparable v = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= left+1 && arr[j].compareTo(v) > 0) {
                j--;
            }

            if (i >j) {
                break;
            }

            SortTestHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, left, j);
        return j;
    }
}
