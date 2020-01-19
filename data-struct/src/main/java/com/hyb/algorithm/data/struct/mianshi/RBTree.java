package com.hyb.algorithm.data.struct.mianshi;

public class RBTree<K extends   Comparable<K>,V>  {

    private static  final Boolean RED=true;
    private static  final  Boolean BALCK=false;

    private class  Node{
        public  K key;
        public V val;
        public Node left;
        public Node right;
        public Boolean color;


        public Node(K key,V  val){
            this.key=key;
            this.val=val;
            left=null;
            right=null;
            color=BALCK;
        }
    }


    private  Node root;
    private int size;


    public RBTree(){
        root=null;
        size=0;
    }



}
