package com.hyb.algorithm.data.struct.leetcode.t1;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.test();

    }

    public void test() {
        ListNode l1 = builder(1);
        ListNode l2 = builder(99);

        ListNode ret = addTwoNumbers(l1, l2);

        while (ret != null) {
            System.out.print(ret.val + "->");
            ret = ret.next;
        }
    }

    public ListNode builder(int val) {

        List<Integer> list = new ArrayList<>();
        while (val % 10 > 0) {
            list.add(val % 10);
            val = val / 10;
        }

        return transListToLink(list);

    }

    public ListNode transListToLink(List<Integer> list) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = null;
        for (Integer item : list) {
            if (dummyNode.next == null) {
                dummyNode.next = new ListNode(item);
                current = dummyNode.next;
                continue;
            }
            current.next = new ListNode(item);
            current = current.next;

        }

        return dummyNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int step = 0;
        int carry = 0;


        List<Integer> list = new ArrayList<>();

        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 == null) {
                sum = (l2.val + carry);
                int val = sum % 10;
                l2 = l2.next;
                carry = sum>=10?1:0;
                list.add(val);
                continue;
            }

            if (l2 == null) {
                sum = (l1.val + carry);
                int val = sum % 10;
                l1 = l1.next;
                carry = sum>=10?1:0;
                list.add(val);
                continue;
            }


            sum = (l1.val + l2.val + carry);
            int val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum>=10?1:0;
            list.add(val);
        }

        if (carry > 0) {
            list.add(carry);
        }

        return transListToLink(list);
    }
}
