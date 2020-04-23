package com.hyb.algorithm.data.struct.leetcode.t1;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairsMain {

    public static void main(String[] args) {
        System.out.println(new ClimbStairsMain().climbStairs(45));
    }

    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        return climbStairs(n, mem);
    }

    public int climbStairs(int index, int[] mem) {

        if (index <= 0) {
            return 0;
        }
        if (index <= 1) {
            return 1;
        }

        if (index <= 2) {
            return 2;
        }

        if (mem[index] > 0) {
            return mem[index];
        }

        mem[index] = climbStairs(index - 1, mem) + climbStairs(index - 2, mem);

        return mem[index];
    }
}
