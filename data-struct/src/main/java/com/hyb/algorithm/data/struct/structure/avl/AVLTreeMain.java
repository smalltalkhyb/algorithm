package com.hyb.algorithm.data.struct.structure.avl;

import com.hyb.algorithm.data.struct.structure.tree.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeMain {

    public static void main(String[] args) {
        AVLTree<String, Integer> avlTree = new AVLTree<>();

        List<String> wordList = new ArrayList<>();
        String dir = "F:\\Workspace2019\\Java\\201906\\algorithm\\data\\";
        if (FileOperation.readFile(dir + "pride-and-prejudice.txt", wordList)) {

            long beginTime=System.nanoTime();
            for (String word : wordList) {
                if (avlTree.contains(word)) {
                    avlTree.add(word, avlTree.get(word) + 1);
                    continue;
                }

                avlTree.add(word, 1);
            }

            System.out.println("avlTree.size=" + avlTree.getSize());

            System.out.println("avlTree.pride.size=" + avlTree.get("pride"));
            System.out.println("avlTree.prejudice.size=" + avlTree.get("prejudice"));

            System.out.println("avlTree.isBST=" + avlTree.isBST());

            System.out.println("avlTree.isBalance=" + avlTree.isBalance());


            for(String word:wordList){
                avlTree.remove(word);

                if(!avlTree.isBST()){
                    throw  new IllegalArgumentException("avlTree is not isBST");
                }

                if(!avlTree.isBalance()){
                    throw  new IllegalArgumentException("avlTree is not balance");
                }
            }

            long end=System.nanoTime();

            double spendTimes=(end-beginTime)/1000000000.00;
            System.out.println("avlTree spendtimes="+spendTimes);
        }
    }
}
