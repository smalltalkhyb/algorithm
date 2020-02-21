package com.hyb.algorithm.data.struct.structure.trie;


import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * https://leetcode-cn.com/problems/map-sum-pairs/
 */
class MapSum {

    private class  Node{
        private int val;
        private Map<Character,Node> next;

        public Node(int val){
            this.val=val;
            this.next=new HashMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root=new Node();
    }

    public void insert(String key, int val) {
        Node curr=root;
        for(int i=0;i<key.length();i++){
            Character character=key.charAt(i);
            if(!curr.next.containsKey(character)){
                Node node=new Node();
                curr.next.put(character,node);
                curr=node;
                continue;
            }
            curr=curr.next.get(character);
        }

        curr.val=val;
    }

    public int sum(String prefix) {
        Node curr=root;

        for(int i=0;i<prefix.length();i++){
            Character c=prefix.charAt(i);
            if(!curr.next.containsKey(c)){
                return 0;
            }
            curr=curr.next.get(c);

        }

        return  sum(curr);
    }

    private int sum(Node node){
        int ret=node.val;

        for(Character c:node.next.keySet()){
               ret+=sum(node.next.get(c));
        }
        return ret;
    }
}
