package com.hyb.algorithm.data.struct.structure.link;


import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class ListNodeMain {

    public static void main(String[] args) {


        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};

        ListNode listNode = new ListNode(1);
        ListNode currentListNode = listNode;
        for (int i = 1; i < arr.length; i++) {
            ListNode subListNode = new ListNode(arr[i]);
            currentListNode.next = subListNode;
            currentListNode = subListNode;
        }

        removeElements2(listNode, 6);

        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }


    public static ListNode removeElements(ListNode head, int val) {

        while (head.next!=null&&head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }

        if(head==null){
            return  head;
        }


        ListNode prev=head;

        while (prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
                continue;
            }
            prev=prev.next;
        }

        return head;
    }


    public static ListNode removeElements2(ListNode head, int val) {

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        ListNode prev=dummyHead;
        while (prev.next!=null){
            if(prev.next.val!=val){
                prev=prev.next;
                continue;
            }

            ListNode delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
        }

        return dummyHead.next;
    }
}
