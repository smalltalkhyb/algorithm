package com.hyb.algorithm.data.struct.leetcode.t1;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = new RemoveDuplicates().removeDuplicates(nums);

        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + ",");
        }

    }


    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int insertIndex = 0;
        int val = nums[insertIndex];
        for (int i = 1; i < nums.length; i++) {
            if(val!=nums[i]){
                nums[insertIndex+1]=nums[i];
                val=nums[i];
                insertIndex++;
                continue;
            }
        }

        return insertIndex+1;
    }
}
