package com.hyb.algorithm.data.struct.structure.link;

public class LinkMainTest {

    public static void main(String[] args) {

        LinkListStruct<Integer>  linkListStruct=new LinkListStruct<>();

        for(int i=0;i<10;i++){
            linkListStruct.addFirst(i);
            System.out.println(linkListStruct);
        }

        linkListStruct.set(2,25);
        System.out.println(linkListStruct);


        linkListStruct.remove(2);

        linkListStruct.remove(4);


        System.out.println(linkListStruct);


    }
}
