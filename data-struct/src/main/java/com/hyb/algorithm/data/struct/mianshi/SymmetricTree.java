package com.hyb.algorithm.data.struct.mianshi;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.cnblogs.com/du001011/p/11241621.html
 * <p>
 * 判断二叉树是否是镜像对称
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class SymmetricTree {

    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        SymmetricTree.TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);

        root.left = left1;
        root.right = right1;


        TreeNode left12 = new TreeNode(3);
        TreeNode right12 = new TreeNode(4);

        left1.left = left12;
        left1.right = right12;


        TreeNode left22 = new TreeNode(4);
        TreeNode right22 = new TreeNode(3);

        right1.left = left22;
        right1.right = right22;


        System.out.println(isSymmetric(root));

    }


    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }


        Queue<TreeNode> treeNodeQueue=new LinkedList<>();

        treeNodeQueue.add(root);
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()){

            TreeNode t1=treeNodeQueue.poll();
            TreeNode t2=treeNodeQueue.poll();

            if(t1==null&&t2==null){
                continue;
            }

            if(t1==null||t2==null){
                return false;
            }

            if(t1.val!=t2.val){
                return false;
            }

            treeNodeQueue.add(t1.left);
            treeNodeQueue.add(t2.right);

            treeNodeQueue.add(t1.right);
            treeNodeQueue.add(t2.left);

        }
        return true;
    }


}
