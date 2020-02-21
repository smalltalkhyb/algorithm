package com.hyb.algorithm.data.struct.structure.trie;

import com.hyb.algorithm.data.struct.structure.tree.FileOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TrieTreeMain {

    public static void main(String[] args) {
        String dirPath = "F:\\Workspace2019\\Java\\201906\\algorithm\\data\\";
        List<String> wordList = new ArrayList<>();
        if (FileOperation.readFile(dirPath + "pride-and-prejudice.txt", wordList)) {


            TreeSet<String> treeSet = new TreeSet<>();

            for (String word : wordList) {
                treeSet.add(word);
            }
            long beginTime = System.nanoTime();
            for (String word : wordList) {
                if(!treeSet.contains(word)){
                    System.out.println("treeSet not contains words="+word);
                }
            }

            long endTime = System.nanoTime();
            System.out.println("treeSet.size=" + treeSet.size());
            double spendTime = (endTime - beginTime) / 10 ^ 9;
            System.out.println("treeSet spend times=" + spendTime);




            TrieTree trieTree=new TrieTree();

            for(String word:wordList){
                trieTree.add(word);
            }
            beginTime = System.nanoTime();
            for(String word:wordList){
                if(!trieTree.contains(word)){
                    System.out.println("trieTree not contains words="+word);
                }
            }

            endTime = System.nanoTime();

            System.out.println("trieTree.size=" + treeSet.size());
            spendTime = (endTime - beginTime) / 10 ^ 9;
            System.out.println("trieTree spend times=" + spendTime);

        }
    }
}
