package com.hyb.algorithm.data.struct.structure.tree;

import java.util.*;


/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 *
 */
public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        int[] res=intersect(nums1,nums2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] mapArray=nums1;
        int[] targetArray=nums2;
        if(nums2.length<nums1.length){
            mapArray=nums2;
            targetArray=nums1;
        }

        Set<Integer> set=new HashSet<>();

        for(int t:mapArray){
            set.add(t);
        }

        List<Integer> list=new ArrayList<>();

        for(int t:targetArray){
            if(set.contains(t)){
                list.add(t);
                set.remove(t);
            }
        }

        int[] ints=new int[list.size()];

        int i=0;
        for(Integer t:list){
            ints[i]=t;
            i++;
        }
        return ints;
    }

    //https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] mapArray=nums1;
        int[] targetArray=nums2;
        if(nums2.length<nums1.length){
            mapArray=nums2;
            targetArray=nums1;
        }

        Map<Integer,Integer> map=new HashMap<>();
        for(int t:mapArray){
            if(map.containsKey(t)){
                map.put(t,map.get(t)+1);
                continue;
            }
            map.put(t,1);
        }

        List<Integer> list=new ArrayList<>();
        for(int t:targetArray){
            if(!map.containsKey(t)){
                continue;
            }

            int rep=map.get(t);
            map.put(t,rep-1);

            if(map.get(t)>=0){
                list.add(t);
            }
        }

        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;

    }
}
