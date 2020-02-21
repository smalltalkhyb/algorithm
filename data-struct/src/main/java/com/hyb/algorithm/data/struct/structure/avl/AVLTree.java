package com.hyb.algorithm.data.struct.structure.avl;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {


    private class Node {

        private K key;
        private V val;
        private int height;
        private Node left;
        private Node right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size++;
    }


    public void add(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node node, K key, V val) {

        if (node == null) {
            size++;
            return new Node(key, val);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, val);
        }

        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, val);
        }

        if (key.compareTo(node.key) == 0) {
            node.val = val;
        }


        return processRotate(node);

    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }


    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //找出节点最小元素
    public Node minimum() {
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    //找出节点最大元素
    public Node maximum() {
        return maximum(root);
    }


    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }


    public V remove(K key) {
        Node node = getNode(root, key);

        if (node == null) {
            return null;
        }
        root = remove(root, key);
        return node.val;
    }


    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return processRotate(node);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return processRotate(node);
        }
        // key.compareTo(node.key) == 0

        // 待删除节点左子树为空的情况
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return processRotate(rightNode);
        }

        // 待删除节点右子树为空的情况
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return processRotate(leftNode);
        }

        // 待删除节点左右子树均不为空的情况

        // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
        // 用这个节点顶替待删除节点的位置
        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        //successor.right = remove(node.right, successor.key);
        successor.left = node.left;

        node.left = node.right = null;

        // return successor;
        return processRotate(successor);

    }


    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return processRotate(right);
        }

        node.left = removeMin(node.left);
        return processRotate(node);
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


    //判断AVLTree 是否为二分搜索树
    public boolean isBST() {
        ArrayList<K> arrayList = new ArrayList<>();
        inOrder(root, arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).compareTo(arrayList.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(Node node, List<K> arrayList) {
        if (node == null) {
            return;
        }
        inOrder(node.left, arrayList);
        arrayList.add(node.key);
        inOrder(node.right, arrayList);
    }

    //判断二叉树是否为平衡二叉树
    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        int factors = getBalanceFactor(node);
        if (Math.abs(factors) > 1) {
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);

    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
        return node.val;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        // 向右旋转 (y)
        x.right = y;
        y.left = t3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    public Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        //向左旋转
        x.left = y;
        y.right = t2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }


    public Node processRotate(Node node) {

        if (node == null) {
            return null;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int factor = getBalanceFactor(node);


//        if (Math.abs(factor) > 1) {
//            System.out.println(" factor=" + factor);
//        }
        //LL  左子树比右子树高  平衡维护
        if (factor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR   右子树比左子树高
        if (factor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (factor > 1 && getBalanceFactor(node.left) < 0) {
            //先左旋 变成LL
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if (factor < -1 && getBalanceFactor(node.right) > 0) {
            //先右旋转 变成RR
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;

    }


    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException("k is not in tree");
        }
        node.val = v;
    }


}
