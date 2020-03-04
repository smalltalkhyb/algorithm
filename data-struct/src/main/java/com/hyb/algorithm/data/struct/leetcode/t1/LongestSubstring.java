package com.hyb.algorithm.data.struct.leetcode.t1;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));

        String s2 = "ddd";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring2(s3));

        String s4 = "abcabcbb";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s4));

        String s5 = " ";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s5));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterSet = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (characterSet.containsKey(c)) {
                left = Math.max(left, characterSet.get(c));
            }
            characterSet.put(c, i + 1);
            max = Math.max(max, i - left + 1);
        }


        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
