package com.hyb.algorithm.data.struct.structure.rb;


public class RBTree<K extends Comparable<K>, V> {

    private final boolean RED = true;
    private final boolean BLACK = false;

    private class Node {
        private K key;
        private V val;
        private boolean color = RED;

        private Node left;
        private Node right;


        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            color = RED;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(K key, V val) {
        root = add(root, key, val);
        //根节点为红色
        root.color = RED;
    }

    private Node add(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, val);
            return node;
        }

        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, val);
            return node;
        }

        node.val = val;
        return node;
    }


    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;

        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;

    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;

        x.right = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 颜色翻转
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }

        return node.color;
    }


    private Node rotate(Node node) {
        if (node == null) {
            return null;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node= leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node=rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }

        return node;
    }


    public boolean contains(K key) {

        Node node = getNode(root, key);
        return node != null;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        }

        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }

        return node;
    }

    public void set(K key, V val) {
        Node node = getNode(root, key);

        if (node == null) {
            throw new IllegalArgumentException(" node is null");
        }

        node.val = val;

    }

    public V get(K key) {
        Node node = getNode(root, key);

        if (node == null) {
            //throw new IllegalArgumentException(" node is null");
            return null;
        }

        return node.val;

    }

    public int getSize() {
        return size;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
        root = remove(root, key);
        return node.val;
    }

    //删除元素 并返回 根节点
    private Node remove(Node node, K key) {

        if (node == null) {
            size--;
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return rotate(node);
        }

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return rotate(node);
        }

        //key.compareTo node.key==0
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return rotate(right);
        }

        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return rotate(left);
        }


        Node successor = minimun(node.right);
        //等价于 succesor.right=removeMin(node.right);
        //successor.right = remove(node.right,successor.key);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.right = node.left = null;

        return rotate(successor);
    }


    private Node minimun(Node node) {
        if (node.left == null)
            return node;
        return minimun(node.left);
    }


    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            size--;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }


}
