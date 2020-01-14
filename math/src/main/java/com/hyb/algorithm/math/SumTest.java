package com.hyb.algorithm.math;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]`
 */
public class SumTest {


    private static ObjectMapper objectMapper=new ObjectMapper();

    public static void main(String[] args) {
        int[] tempArray = new int[]{0,2 , 11, 7};

        int[] ret = twoSum(tempArray, 9);

        try {
            System.out.println(objectMapper.writeValueAsString(ret));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



    private static  int[]  twoSum(int[] nums,int total ){

        Map<Integer,Integer> retMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=total-nums[i];

            if(retMap.containsKey(diff)){
                return new int[]{retMap.get(diff),i};
            }

            retMap.put(nums[i],i);
        }

        return null;
    }


}
