package com.hyb.algorithm.data.struct.leetcode.t1;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSum2(nums);
        System.out.println(ret.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {

                if(i>=j){
                    continue;
                }

                if (map.containsKey(nums[j])) {
                    List<Integer> clist=map.get(nums[j]);
                    clist.add(nums[j]);
                    list.add(clist);
                    map.remove(nums[j]);
                    continue;
                }

                int div = 0 - nums[i] - nums[j];
                List<Integer> sublist=new ArrayList<>();
                sublist.add(nums[i]);
                sublist.add(nums[j]);

                map.put(div, sublist);
            }

        }

        return list;

    }



    public  static List<List<Integer>> threeSum2(int[] nums) {

         Arrays.sort(nums);

        List<List<Integer>> ret=new ArrayList<>();

         for(int i=0;i<nums.length-2;i++){

             //当第i个元素大于零时，跳出循环
             if(nums[i]>0){
                 break;
             }

             if(i>0&&nums[i]==nums[i-1]){
                 continue;
             }

             int left=i+1;
             int right=nums.length-1;

             while (left<right) {

                 int sum = nums[i] + nums[left] + nums[right];

                 if (sum < 0){
                     left++;
                     continue;
                 }

                 if(sum>0){
                     right--;
                     continue;
                 }

                 ret.add(Arrays.asList(nums[i],nums[left],nums[right]));

                 while (left<right&&nums[left]==nums[left+1]){
                     left++;
                 }
                 while (left<right&&nums[right]==nums[right-1]){
                     right--;
                 }

                 left++;
                 right--;
             }

         }

         return  ret;
    }
}
