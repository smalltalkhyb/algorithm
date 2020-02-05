package com.hyb.algorithm.data.struct.structure.queue;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LevelOrderTree {


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>  arrayList=new ArrayList<>();

        if(root==null){
            return arrayList;
        }


        Queue<Pair<TreeNode,Integer>> queue=new LinkedList<Pair<TreeNode,Integer>>();

        queue.add(new Pair<TreeNode,Integer>(root,0));

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair =queue.poll();

            TreeNode treeNode=pair.getKey();
            Integer level=pair.getValue();

            if(level==arrayList.size()){
                arrayList.add(new ArrayList<>());
            }

            arrayList.get(level).add(treeNode.val);

            if(treeNode.left!=null){
                queue.add(new Pair<TreeNode,Integer>(treeNode.left,level+1));
            }

            if(treeNode.right!=null){
                queue.add(new Pair<TreeNode,Integer>(treeNode.right,level+1));
            }
        }

        return arrayList;
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);

        TreeNode left1=new TreeNode(9);
        TreeNode right1=new TreeNode(20);

        TreeNode r1l2=new TreeNode(15);
        TreeNode r1r2=new TreeNode(7);

        root.left=left1;
        root.right=right1;

        right1.left=r1l2;
        right1.right=r1r2;


        List<List<Integer>> ret=levelOrder(root);


        System.out.println(ret);

    }

}
