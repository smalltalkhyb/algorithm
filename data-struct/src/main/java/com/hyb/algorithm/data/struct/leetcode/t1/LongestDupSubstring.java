package com.hyb.algorithm.data.struct.leetcode.t1;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-duplicate-substring/
 */
public class LongestDupSubstring {

    public static void main(String[] args) {
        String str = "banana";

        System.out.println(new LongestDupSubstring().longestDupSubstring(str));
    }

    public String longestDupSubstring(String S) {

        int left = 0;
        int right = S.length();
        int repeatLength = 0;
        char[] nums = S.toCharArray();

        while (left < right) {
            repeatLength = left + (right - left) / 2;
            if (search(nums, left, repeatLength) == -1) {
                right = left;
                continue;
            }
            left = repeatLength + 1;
        }

        return "";
    }


    int step = 26;
    long mode = (long) Math.pow(2, 32) - 1;
    int begin='0';

    public int search(char[] nums, int left, int repeatLength) {

        long h = 0;
        for (int i = 0; i < repeatLength; i++) {
            h = (h * step + (nums[i]-begin)) % mode;
        }

        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add(h);

        long begin = 1;
        for (int i = 1; i <= repeatLength; i++) {
            begin = (begin * step) % mode;
        }

        int tcode=0;
        for (int start = 1; start < nums.length - repeatLength + 1; start++) {
            tcode+=(tcode*step+(nums[start]-begin))%mode;
        }

        return -1;
    }




}
