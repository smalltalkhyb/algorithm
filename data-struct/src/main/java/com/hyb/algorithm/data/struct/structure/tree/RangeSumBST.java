package com.hyb.algorithm.data.struct.structure.tree;


/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    public static void main(String[] args) {

        BST<Integer>  bst=new BST<>();

        int[] arr=new int[]{10,5,15,3,7,18};

        for(int a:arr){
            bst.add(a);
        }

        System.out.println( bst.rangeSumBST(7,15));
    }



}
