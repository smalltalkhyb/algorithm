package com.hyb.algorithm.data.struct.structure.tree;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 */
public class Morse {

    public static void main(String[] args) {
        String[] words=new String[]{"gin", "zen", "gig", "msg"};
        int ret= uniqueMorseRepresentations(words);

        System.out.println(ret);
    }


    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseArray=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set=new HashSet<>();
        for(String word:words){
            StringBuilder morseCode=new StringBuilder(300);
            for(int i=0;i<word.length();i++){
                char index=word.charAt(i);
                morseCode.append(morseArray[index-'a']);
            }
            set.add(morseCode.toString());
        }

        return set.size();
    }
}
