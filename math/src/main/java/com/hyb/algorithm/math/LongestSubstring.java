package com.hyb.algorithm.math;


import java.util.HashMap;
import java.util.Map;

/**
 *
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  本题是一个典型的滑动窗口类题目，要求滑动窗口里没有重复的字符。
 * 那么怎么滑动呢？
 *
 * 首先，我们需要用一个数据结构来记录窗口中的字符（可以是数组或者map，这个具体代码的时候再说）。
 *
 * 何时窗口右移？如果要处理的那个字符在滑动窗口里没有，那么窗口就可以右移了。因为此时还是能保证窗口里没有重复的字符。
 *
 * 窗口何时左移？如果要处理的那个字符在滑动窗口里有，那么窗口就需要左移。
 *
 * 左移什么时候结束？当左移到滑动窗口里面已经没有要处理的那个字符就可以结束了。
 * 什么时候无重复子串最长？窗口最大的时候最长。
 *
 * 因此，回到刚才用来记录的数据结构那个问题，如果用数组怎么做？用数组的话，可以申请一个大小为256的数组，
 *
 * 当某个字符被加进滑动窗口，其对应位置的数就加1，当某个字符被移除滑动窗口，其对应位置的数就减1.
 *
 * 什么时候代表滑动窗口里面有这个字符？当其对应位置的值不为0就代表滑动窗口里面有这个字符了。
 *
 * 如果用map怎么做？可以用Mapmap来存储窗口中的值，key表示存储的字符，value表示存储的字符在已经遍历到的最右边的位置。用l表示滑动窗口的左端。
 *
 * 当map里包含要处理的字符的时候，此时窗口的最左边应该是l和map.get(c) + 1的较大者。当map里不包含要处理的字符的时候，此时窗口的最左边任然为l。
 * 最后将待处理字符加入map并计算窗口大小。
 * https://mp.weixin.qq.com/s?__biz=MzUxMzQ0Njc1NQ==&mid=2247485748&idx=2&sn=fd0228780414a8442afc0f071e8b9d6d&chksm=f9544f38ce23c62e7db8d83dfca7f36ae847725c70f524111f6e80ba536c507c2ceaf19618aa&scene=21#wechat_redirect
 */

public class LongestSubstring {

    public static void main(String[] args) {
        int ret = lengthOfLongestSubstring("aaabccccaaaaaaa");
        int ret2 = lengthOfLongestSubstringMap("aaabccccaaaaaaa");
        System.out.println(ret);
        System.out.println(ret2);

    }

    private static int lengthOfLongestSubstring(String s) {

        if(s==null||s.length()<=0){
            return 0;
        }

        int left=0;
        int right=0;
        int maxLength=0;

        int[] temp=new int[256];

        while (left<s.length()){

            if(right<s.length()&&temp[s.charAt(right)]==0){
                temp[ s.charAt(right++)]=1;
            }else {
                maxLength=maxLength>right-left?maxLength:right-left;
                temp[s.charAt(left++)]=0;
            }
        }

        return maxLength;


    }


    private static int lengthOfLongestSubstringMap(String s) {

        if(s==null||s.length()<=0){
            return 0;
        }

        Map<Character,Integer>  map=new HashMap<>();

        int left=0;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(map.containsKey(c)){
                left=left>map.get(c)+1?left:map.get(c)+1;
            }
            map.put(c,i);
            maxLength=maxLength>i-left+1?maxLength:i-left+1;
        }

        return maxLength;
    }


}
