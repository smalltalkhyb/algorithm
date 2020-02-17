package com.hyb.algorithm.data.struct.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


    Node root;
    int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    //向二分搜索树添加新的元素
    public void add(E e) {
        root = add(root, e);
    }

    //向以node 为根的二分搜索树添加元素e，递归算法
    //返回插入新节点后二分搜索树的根
    public Node add(Node node, E e) {

        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) >0) {
            node.right = add(node.right, e);
            return node;
        }

        return node;
    }

    //二分搜索树判断是否存在 该节点
    public boolean contains(E e) {
        return contains(root, e);
    }

    //以node为根查询 是否包含元素 e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }

        return contains(node.right, e);
    }

    //二分搜索树 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //以node 为根节点 前序遍历
    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树 前序遍历 非递归实现
    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    //中序遍历  递归实现
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void inOrderNR() {
        inOrderNR(root);
    }

    private void inOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();

        Node curr = node;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.e);
            curr = curr.right;
        }
    }


    //后续遍历
    //后续遍历的一个应用：
    //为二分搜索树释放内存
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    //二分搜索树后序遍历 非递归
    public void postOrderNR() {
        postOrderNR(root);
    }

    private void postOrderNR(Node node) {


        Stack<Node> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.e);
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
    }


    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node){
        Queue<Node> queue=new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()){
            Node curr=queue.remove();
            System.out.println(curr.e);

            if(curr.left!=null){
                queue.add(curr.left);
            }

            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
    }


    //寻找二分搜索树最小元素
    public E minimum(){
        if(size==0){
            throw new IllegalArgumentException("tree is  empty");
        }

        Node node= minimum(root);

        return node.e;
    }

    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }

        return  minimum(node.left);

    }


    //寻找二分搜索树最大元素
    public E maximum(){
        if(size==0){
            throw new IllegalArgumentException("tree is  empty");
        }

        Node node= maximum(root);

        return node.e;
    }

    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }

        return  maximum(node.right);

    }


    //删除最小值
    public E removeMin(){
        E e =minimum();
        root=removeMin(root);
        return e;
    }

    public Node removeMin(Node node){
        if(node.left==null){
            Node right=node.right;
            node.right=null;
            size--;
            return right;
        }

        node.left=removeMin(node.left);
        return  node;
    }

    //删除最大元素
    public E removeMax(){
        E e=maximum();
        root=removeMax(root);
        return e;
    }

    private Node removeMax(Node node){

        if(node.right==null){
            Node left=node.left;
            node.left=null;
            size--;
            return left;
        }
        node.right=removeMax(node.right);
        return node;
    }

    //删除元素为e 的树节点
    public void remove(E e){
        root =remove(root,e);
    }

    private Node remove(Node node ,E e){
        if(node==null){
            return  null;
        }

        if(e.compareTo(node.e)<0){
           node.left= remove(node.left,e);
           return node;
        }

        if(e.compareTo(node.e)>0){
            node.right= remove(node.right,e);
            return node;
        }

        //如果相等  e.compareTo(node.e)==0
        if(node.left==null){
            Node right=node.right;
            node.right=null;
            size--;
            return right;
        }

        if(node.right==null){
            Node left=node.left;
            node.left=null;
            size--;
            return  left;
        }

        // node.right!=null  and node.left!=null
        // 待删除节点左右子树均不为空的情况
        // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
        // 用这个节点顶替待删除节点的位置
        Node successor=minimum(node.right);
        successor.right=removeMin(node.right);
        successor.left=node.left;

        node.left=node.right=null;
        return successor;

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private void generateBSTString(Node node, StringBuilder stringBuilder, int depth) {

        if (node == null) {
            stringBuilder.append(generateBSTStringDepth(depth) + "null\n");
            return;
        }

        stringBuilder.append(generateBSTStringDepth(depth) + node.e + "\n");
        generateBSTString(node.left, stringBuilder, depth + 1);
        generateBSTString(node.right, stringBuilder, depth + 1);
    }

    private String generateBSTStringDepth(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}
