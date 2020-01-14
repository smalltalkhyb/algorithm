package com.hyb.algorithm.math;


import java.util.HashMap;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s?__biz=MzUxMzQ0Njc1NQ==&mid=2247485748&idx=2&sn=fd0228780414a8442afc0f071e8b9d6d&chksm=f9544f38ce23c62e7db8d83dfca7f36ae847725c70f524111f6e80ba536c507c2ceaf19618aa&scene=21#wechat_redirect
 */

public class LongestSubstring {

    public static void main(String[] args) {
        int ret = lengthOfLongestSubstring("abcabcdabcdefg");
        int ret2 = lengthOfLongestSubstringMap("abcabcdabcdefg");
        System.out.println(ret);
        System.out.println(ret2);

    }


    private static int lengthOfLongestSubstring(String str) {

        if (str == null || str.length() <= 0) {
            return 0;
        }

        int[] tmp = new int[256];

        int left = 0;
        int right = 0;

        int maxLength = 0;

        while (left < str.length()) {

            if (right < str.length()&&tmp[str.charAt(right)]==0) {
                int index=str.charAt(right);
                tmp[index] = 1;
                right = right + 1;
                continue;
            }

            int index = str.charAt(left);
            tmp[index] = 0;
            left = left + 1;

            maxLength = maxLength > right - left ? maxLength : right - left;

        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] tmp = new int[256];
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while (l < s.length()) {
            if (r < s.length() && tmp[s.charAt(r)] == 0) {
                tmp[s.charAt(r++)] = 1;
            } else {
                maxLen = maxLen > (r - l) ? maxLen : (r - l);
                tmp[s.charAt(l++)] = 0;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                l = l > (map.get(c) + 1) ? l : (map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = maxLen > (i - l + 1) ? maxLen : (i - l + 1);
        }
        return maxLen;
    }


    private static int lengthOfLongestSubstringMap(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int maxLength = 0;
        int r = 1;
        int l = 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!charMap.containsKey(c)) {
                r++;
                charMap.put(c, i);
                continue;
            }
            l++;
            maxLength = maxLength > r - l ? maxLength : r - l;
        }

        return maxLength;
    }


}
