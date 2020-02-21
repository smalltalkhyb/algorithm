package com.hyb.algorithm.data.struct.structure.trie;


import java.util.Map;
import java.util.TreeMap;

/**
 * 211  添加与搜索单词 - 数据结构设计
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {

    private class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curr.next.containsKey(c)) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }

        if (curr.isWord)
            return;

        curr.isWord = true;
        size++;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        Character c = word.charAt(index);

        if (c != '.') {
            if (!node.next.containsKey(c)) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }

        for (Character key : node.next.keySet()) {
            boolean ret = match(node.next.get(key), word, index + 1);
            if (ret) {
                return true;
            }
        }
        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
