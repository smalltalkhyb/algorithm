package com.hyb.algorithm.data.struct.structure.tree;


import java.util.ArrayList;

public class BSTSetMain {
    public static void main(String[] args) {


        System.out.println("Pride and Prejudice");

        String dir="F:\\Workspace2019\\Java\\201906\\algorithm\\data\\";

        ArrayList<String> words1=new ArrayList<>();
        if(FileOperation.readFile(dir+"pride-and-prejudice.txt",words1)) {
            System.out.println("Total words:" + words1.size());


            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1) {
                set1.add(word);
            }

            System.out.println("Total different words:" + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2=new ArrayList<>();

        if(FileOperation.readFile(dir+"a-tale-of-two-cities.txt",words2)){
            System.out.println("Total words:"+words2.size());

            BSTSet<String> set2=new BSTSet<>();

            for(String word:words2){
                set2.add(word);
            }

            System.out.println("Total different words:"+set2.getSize());
        }


    }
}
