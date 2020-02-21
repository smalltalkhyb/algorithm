package com.hyb.algorithm.data.struct.structure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BSTRemoveMain {

    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();

        int n=1000;
        Random random=new Random();
        for(int i=0;i<n;i++){
            bst.add(random.nextInt(n));
        }

        int[] arr=new int[n];
        for(int i=0;i<n;i++ ){
            arr[i]=i;
        }


        //打乱所有顺序
        shuffle(arr);


        for(int i=0;i<n;i++){
            if(bst.contains(arr[i])){
                bst.remove(arr[i]);
                System.out.println("After remove="+arr[i]+",bst.size="+bst.size);
            }
        }

        System.out.println(bst.getSize());

    }

    private static  void  shuffle(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            int pos= (int)((i+1)*Math.random());
            int temp=arr[pos];
            arr[pos]=arr[i];
            arr[i]=temp;
        }
    }
}
