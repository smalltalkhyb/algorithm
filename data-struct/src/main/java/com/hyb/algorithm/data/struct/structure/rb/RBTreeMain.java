package com.hyb.algorithm.data.struct.structure.rb;

import com.hyb.algorithm.data.struct.structure.avl.AVLTree;
import com.hyb.algorithm.data.struct.structure.tree.BST;
import com.hyb.algorithm.data.struct.structure.tree.FileOperation;

import java.util.ArrayList;

public class RBTreeMain {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        String dir="F:\\Workspace2019\\Java\\201906\\algorithm\\data\\";
        if(FileOperation.readFile(dir+"pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);




            // Test AVL
           long startTime = System.nanoTime();

            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word))
                    rbTree.set(word, rbTree.get(word) + 1);
                else
                    rbTree.add(word, 1);
            }

            for(String word: words)
                rbTree.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");

            System.out.println("RBTree: size= " +  rbTree.getSize());

            System.out.println("Pride  size="+rbTree.get("pride"));

            System.out.println("Prejudice  size="+rbTree.get("prejudice"));

            for(String word: words)
                rbTree.remove(word);


            System.out.println("RBTree: size= " +  rbTree.getSize());

            System.out.println("Pride  size="+rbTree.get("pride"));

            System.out.println("Prejudice  size="+rbTree.get("prejudice"));
        }

        System.out.println();
    }
}
