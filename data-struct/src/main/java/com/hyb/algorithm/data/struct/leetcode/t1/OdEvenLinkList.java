package com.hyb.algorithm.data.struct.leetcode.t1;

import com.hyb.algorithm.data.struct.structure.link.ListNode;

import java.util.List;

/***
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OdEvenLinkList {

//    public class ListNode {
//        private int val;
//        private ListNode next;
//
//        private ListNode(int val) {
//            this.val = val;
//        }
//    }


    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead.next;

        ListNode oddNodeFirst = new ListNode(0);
        ListNode evenNodeFirst = new ListNode(0);

        //odd 奇数  even  偶数
        ListNode oddPrev = oddNodeFirst;
        ListNode evenPrev = evenNodeFirst;

        while (prev != null) {
            if (prev.val % 2 != 0) {
                oddPrev.next = prev;
                oddPrev = oddPrev.next;
                prev = prev.next;
                continue;
            }

            evenPrev.next = prev;
            evenPrev = evenPrev.next;
            prev = prev.next;
        }

        evenPrev.next = null;

        oddPrev.next = evenNodeFirst.next;

        return oddNodeFirst.next;
    }


    public ListNode oddEvenList2(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode oddNode = head, evenNode = head.next, evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        if (evenNode != null) {
            evenNode.next = null;
        }

        oddNode.next = evenHead;


        return head;
    }

    public static void main(String[] args) {

        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        for (int i = 1; i < 6; i++) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }

        OdEvenLinkList odEvenLinkList = new OdEvenLinkList();

        ListNode listNode = odEvenLinkList.oddEvenList2(dummyHead.next);

        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }


}
