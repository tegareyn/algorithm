package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;

/**
 * @Ref LC206
 * @Description 业务用途描述
 * @Author Spindrift
 * @Since 2022/11/30 14:36
 * @Version 1.0
 **/
public class LC206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseList(head);
        System.out.println(head);
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseLinkPoint(head, head, head.next);
    }

    /**
     *
     * @param head 头指针元素
     * @param cur 待变更指针的元素
     * @param pre cur的前一个指针元素
     */
    public static ListNode reverseLinkPoint(ListNode head, ListNode pre, ListNode cur) {
        if (cur != null) {
            // 指针逆转
            // 1. cur.next = head; (交换完成后，指向也需要改变)
            // 2. next 指针后移
            ListNode next = cur.next;
            pre.next = next;
            cur.next = head;
            head = reverseLinkPoint(cur, pre, next);
        }
        return head;
    }
}
