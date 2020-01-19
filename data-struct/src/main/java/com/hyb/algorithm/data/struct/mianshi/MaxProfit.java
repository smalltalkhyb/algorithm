package com.hyb.algorithm.data.struct.mianshi;


/**
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * ————————————————
 * 版权声明：本文为CSDN博主「ccmedu」的原创文章，遵循 CC 4.0 BY 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/ccmedu/article/details/99004073
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] prices = new int[] {7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);

    }


    private static int  maxProfit(int[] prices){

        int length=prices.length;
        int min=prices[0];
        int maxProfit=0;


        for(int i=1;i<length;i++){
            int diff=prices[i]-min;
            maxProfit=maxProfit>diff?maxProfit:diff;
            min=min<prices[i]?min:prices[i];
        }


        return maxProfit;
    }
}
