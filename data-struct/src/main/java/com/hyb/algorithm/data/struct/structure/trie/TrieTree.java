package com.hyb.algorithm.data.struct.structure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {

    private class Node {
        Map<Character, Node> next;
        boolean isWord;


        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }

    private Node root;
    private int size;


    public TrieTree() {
        size = 0;
        root = new Node();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //向 tireTree 中添加单词word
    public void add(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curr.next.containsKey(c)) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }

        if (curr.isWord) {
            return;
        }

        curr.isWord = true;
        size++;
    }


    //查询word 是否在tire tree 中
    public boolean contains(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (!curr.next.containsKey(character)) {
                return false;
            }
            curr = curr.next.get(character);
        }

        return curr.isWord;
    }

    //查询字符串前缀 是否包含在 trie tree 树中
    public boolean isPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);

            if (!curr.next.containsKey(character)) {
                return false;
            }
            curr = curr.next.get(character);
        }

        return true;
    }


    /**
     * https://coding.imooc.com/learn/questiondetail/121656.html
     * https://github.com/liuyubobobo/Play-with-Data-Structures/blob/master/10-Trie/Optional-02-Trie-Delete/src/TrieR.java
     * <p>
     * 递归删除
     *
     * @param word
     */
    public void remove(String word) {
        Node curr = root;
        remove(root, word, 0);
    }


    // 在以Node 为根的Trie中删除单词word[index..end] 返回是否删除成功，递归算法
    private boolean remove(Node node, String word, int index) {

        if (index == word.length()) {
            if (!node.isWord) {
                return false;
            }
            node.isWord = false;
            size--;
            return true;
        }

        Character c = word.charAt(index);

        if (!node.next.containsKey(c)) {
            return false;
        }

        boolean ret = remove(node.next.get(c), word, index + 1);

        Node nextNode=node.next.get(c);

        if (!nextNode.isWord&&node.next.size() == 0)
            node.next.remove(c);

        return true;
    }


}
