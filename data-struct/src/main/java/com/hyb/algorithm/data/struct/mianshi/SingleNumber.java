package com.hyb.algorithm.data.struct.mianshi;


/**
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 解法：异或
 *
 * 异或运算的特点：两个相同的数字异或，结果为0。
 *
 * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，如果把所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身。
 *
 * https://blog.csdn.net/baidu_40931662/article/details/83892506
 *
 */
public class SingleNumber {




    private static  int  singleNumber(int[] arr){

        int length=arr.length;

        int val=arr[0];
        for(int i=1;i<length;i++){
            val=val^arr[i];
        }

        return val;
    }

    public static void main(String[] args) {

        int[] a = {1,2,1,3,3,4,4};

        System.out.println(singleNumber(a));

        System.out.println(1^2^2);
        System.out.println(2^2);

    }
}
