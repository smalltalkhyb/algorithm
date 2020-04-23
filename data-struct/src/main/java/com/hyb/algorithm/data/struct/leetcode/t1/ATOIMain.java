package com.hyb.algorithm.data.struct.leetcode.t1;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
 */
public class ATOIMain {

    public static void main(String[] args) {
        //String str = "   +0 123";
        //String str="  0000000000012345678";
        String str = "-000000000000001";
        System.out.println(new ATOIMain().myAtoi(str));
    }


    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        char[] charArray = str.toCharArray();


        int ret = 0;
        boolean negative = false;
        boolean symbol = false;
        boolean beginZero = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                continue;
            }

            if (charArray[i] == '-' && !symbol) {
                symbol = true;
                negative = true;
                continue;
            }

            if (charArray[i] == '+' && !symbol) {
                symbol = true;
                continue;
            }

            if (!Character.isDigit(charArray[i])) {
                return negative ? -ret : ret;
            }

            int digit = charArray[i] - '0';

            if (ret > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ret = ret * 10 + digit;
        }

        if (negative) {
            return -ret;
        }

        return ret;
    }

    public int myAtoi2(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
