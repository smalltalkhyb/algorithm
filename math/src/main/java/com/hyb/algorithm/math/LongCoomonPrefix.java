package com.hyb.algorithm.math;

public class LongCoomonPrefix {

    public static void main(String[] args) {
        String[] strArray=new String[]{"flower","flow","flight"};
        String ret=longCommonPrefix(strArray);
        System.out.println(ret);


        String[] strArray2=new String[]{"dog","racecar","car"};
        longCommonPrefix(strArray2);
        String ret2=longCommonPrefix(strArray2);
        System.out.println(ret2);
    }


    private static String longCommonPrefix(String[] strArray){

        if(strArray.length<=0){
            return "";
        }
        String res=strArray[0];
        if(res==null||res.equals("")){
            return "";
        }


        for(int i=1;i<strArray.length;i++){
            String str=strArray[i];

            if(str==null||str.equals("")){
                return "";
            }

            int start=0;
            while (start<str.length()&&start<res.length()&&res.charAt(start)==str.charAt(start)){
                start++;
            }

            res=res.substring(0,start);
        }

        return res;
    }
}
