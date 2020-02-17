package com.hyb.algorithm.data.struct.structure.tree;

public class BSTMain {

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        BST<Integer> bst=new BST<>();
        for(int i=0;i<nums.length;i++){
            bst.add(nums[i]);
        }


//        bst.preOrder();
//
//        System.out.println("------------");
//
//        System.out.println("------preOrderNR------");
//        bst.preOrderNR();

//        System.out.println(bst);


//        System.out.println("-------inOrder-----");
//        bst.inOrder();
//
//        System.out.println("------inOrderNR------");
//        bst.inOrderNR();


        //后续遍历的一个应用：
        //为二分搜索树释放内存
//        System.out.println("-------postOrder-----");
//        bst.postOrder();
//
//        System.out.println("-------postOrderNR-----");
//        bst.postOrderNR();

        System.out.println("-------levelOrder-----");
        bst.levelOrder();
    }
}
