package com.hyb.algorithm.data.struct.structure.sort;

/**
 * 快速排序 三路排序算法
 */
public class QuickSortTreeWays {

    public static void main(String[] args) {
        Integer N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        //Integer[] arr = new Integer[]{46, 23, 45, 17, 6, 40, 22, 17, 30, 24};
        SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.QuickSortTreeWays", arr);

        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);
    }


    public static void sort(Comparable[] arr) {
        quickSortThreeWays(arr, 0, arr.length - 1);
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void quickSortThreeWays(Comparable[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        // 对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            //优化代码
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int swapLeft = (int) (Math.random() * (right - left + 1) + left);
        SortTestHelper.swap(arr, left, swapLeft);
        Comparable v = arr[left];

        int lt = left;  // arr[l+1...lt] < v
        int gt = right + 1; //  arr[gt...r] > v
        int et = left + 1;// arr[lt+1...i) == v

        while (et < gt) {

            if (arr[et].compareTo(v) < 0) {
                if (et != lt + 1) {
                    SortTestHelper.swap(arr, et, lt + 1);
                }
                et++;
                lt++;
                continue;
            }

            if (arr[et].compareTo(v) > 0) {
                SortTestHelper.swap(arr, et, gt - 1);
                gt--;
                continue;
            }
            //arr[et].compareTo(v) == 0
            et++;
        }

        SortTestHelper.swap(arr, left, lt);
        //et 的 不变
        quickSortThreeWays(arr, left, lt - 1);
        quickSortThreeWays(arr, gt, right);
    }
}
