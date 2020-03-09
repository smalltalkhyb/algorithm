package com.hyb.algorithm.data.struct.structure.graph.weight;


public class IndexMinHeapMain {

    public static void main(String[] args) {


        Integer[] arr = new Integer[]{6, 4, 5,9,8, 3, 2, 1};


        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            indexMinHeap.add(i, arr[i]);
        }


        indexMinHeap.change(6,7);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(indexMinHeap.extractMin());
        }
    }
}
