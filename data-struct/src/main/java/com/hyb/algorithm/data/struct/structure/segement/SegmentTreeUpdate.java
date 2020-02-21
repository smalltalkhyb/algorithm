package com.hyb.algorithm.data.struct.structure.segement;

/**
 *
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 */
public class SegmentTreeUpdate {

    public static void main(String[] args) {
        Integer[] nums=new Integer[]{1,3,5};

        SegmentTree<Integer> segmentTree=new SegmentTree<Integer>(nums,(a,b)->a+b);

        System.out.println(segmentTree.query(0,1));

        segmentTree.update(1,5);

        System.out.println(segmentTree.query(0,1));

    }
}
