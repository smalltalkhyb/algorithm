package com.hyb.algorithm.data.struct.structure.hash;


/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {

        int[] freq=new int[26];

        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            freq[t-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        String s="loveleetcode";

        FirstUniqChar firstUniqChar=new FirstUniqChar();
        int  index=firstUniqChar.firstUniqChar(s);
        System.out.println(String.format("index=%s,char=%s",index,s.charAt(index)));
    }
}
