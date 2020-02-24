package com.hyb.algorithm.data.struct.structure.sort;

public class MergeSort {

    private MergeSort() {

    }

    // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
    // 可以在1秒之内轻松处理100万数量级的数据
    // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
    // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 1, 10000);
        //Integer[] arr = new Integer[]{46, 23, 45, 17, 6, 40, 22, 17, 30, 24};
        //SortTestHelper.printArray(arr);
        //SortTestHelper.testSort("com.hyb.algorithm.data.struct.structure.sort.MergeSort", arr);
        //System.out.println(SortTestHelper.isSorted(arr));

        //SortTestHelper.printArray(arr);

        mergeButtomToUp(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);
    }

    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    //自顶向上归并排序
    private static void mergeButtomToUp(Comparable[] arr) {

        int n = arr.length;

        //step 从 1,2,4,8....
        for (int step = 1; step < n; step = 2 * step) {
            for (int i = 0; i + step < n; i += 2 * step) {
                int right = Math.min(n - 1, 2 * step + i - 1);
                int mid = i + step - 1;

                if (arr[mid + 1].compareTo(arr[mid]) >= 0)
                    continue;
                merge(arr, i, right, mid);
            }
        }
    }


    // // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) < 0) {
            return;
        }
        merge(arr, left, right, mid);
    }

    private static void merge(Comparable[] arr, int left, int right, int mid) {
        if (left >= right) {
            return;
        }

        int tempLength = right - left + 1;
        Comparable[] tempArr = new Comparable[tempLength];

        for (int i = left; i <= right; i++) {
            tempArr[i - left] = arr[i];
        }

        int leftP = left;
        int rightP = mid + 1;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        for (int k = left; k <= right; k++) {
            // 如果左半部分元素已经全部处理完毕
            if (leftP > mid) {
                arr[k] = tempArr[rightP - left];
                rightP++;
                continue;
            }
            // 如果右半部分元素已经全部处理完毕
            if (rightP > right) {
                arr[k] = tempArr[leftP - left];
                leftP++;
                continue;
            }

            // 左半部分所指元素 < 右半部分所指元素
            if (tempArr[leftP - left].compareTo(tempArr[rightP - left]) < 0) {
                arr[k] = tempArr[leftP - left];
                leftP++;
                continue;
            }
            // 左半部分所指元素 >= 右半部分所指元素
            arr[k] = tempArr[rightP - left];
            rightP++;
            continue;

        }
    }
}
