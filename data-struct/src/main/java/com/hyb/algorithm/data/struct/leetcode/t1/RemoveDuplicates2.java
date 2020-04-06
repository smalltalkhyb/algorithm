package com.hyb.algorithm.data.struct.leetcode.t1;


/**
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {

        //int[] nums = new int[]{ 0,0,1,1,1,1,2,3,3};
        int[] nums = new int[]{ 1,1,1,2,2,3};
        int ret = new RemoveDuplicates2().removeDuplicates(nums);

        System.out.println("ret=" + ret);

        for (int i = 0; i < ret; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0)
            return 0;

        int insertIndex = 0;
        int val = nums[0];
        int repeatCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i] && repeatCount <1 ) {
                repeatCount++;
                nums[insertIndex+1] = nums[i];
                insertIndex++;
                continue;
            }

            if (val == nums[i] && repeatCount >= 1) {
                repeatCount++;
                continue;
            }
            nums[insertIndex+1] = nums[i];
            insertIndex++;
            repeatCount = 0;
            val = nums[i];
        }


        return insertIndex+1;

    }


}
