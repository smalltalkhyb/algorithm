package com.hyb.algorithm.data.struct.leetcode.t1;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum {


    public static void main(String[] args) {

        int[] nums=new int[]{2, 7, 11, 15};

         int[] ret=twoSum2(nums,26);

         for(int i=0;i<ret.length;i++){
             System.out.print(ret[i]+",");
         }
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length<2){
            throw  new IllegalArgumentException("参数错误！");
        }

        int length=nums.length;
        int[] ret=new int[2];
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]+nums[j]==target){
                    ret[0]=i;
                    ret[1]=j;
                    break;
                }
            }
        }

        return  ret;
    }


    public static int[] twoSum2(int[] nums, int target) {
        if(nums.length<2){
            throw  new IllegalArgumentException("参数错误！");
        }

        int length=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            int div=target-nums[i];
            if(map.containsKey(div)){
                return new int[]{map.get(div),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
