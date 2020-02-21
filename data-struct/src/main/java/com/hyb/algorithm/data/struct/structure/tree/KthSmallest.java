package com.hyb.algorithm.data.struct.structure.tree;


/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallest {

    public static void main(String[] args) {

        BST<Integer> bst=new BST<>();

        int[] arr=new int []{3,1,4,2};

        for(int i=0;i<arr.length;i++){
            bst.add(arr[i]);
        }

        //System.out.println(kthSmallest(bst,1));
    }

}
