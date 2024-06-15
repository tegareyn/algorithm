package com.tegareyn.algorithm.facecode;

/**
 * @Ref LC2
 * @Description 计算两个逆序数字链表的和，结果用逆序链表进行输出
 * @Author mocheng
 * @Since 2022/3/27 14:44
 * @Version 1.0
 **/
public class InvertLinkList {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int tmpSumResult = 0;
        ListNode left = l1.next;
        ListNode right = l2.next;
        result.val = l1.val + l2.val;
        // 两个链表按位相加，直到其中一个链表没有值可加
        while (l1.next != null || l2.next != null) {
            int l = 0, r = 0;
            if (left != null) {
                l = left.val;
                left = left.next;


            }
            if (right != null) {
                r = right.val;
                right = right.next;


            }
            tmpSumResult = getTmpSumResult(tmpSumResult, l, r);
        }
        return null;
    }

    private static int getTmpSumResult(int tmpSumResult, int l, int r) {
        tmpSumResult += (l + r);
        ListNode tmpNode = null;
        if (tmpSumResult >= 10) {
            tmpNode = new ListNode(tmpSumResult - 10);
            tmpSumResult = 1;
        } else {
            tmpNode = new ListNode(tmpSumResult);
            tmpSumResult = 0;
        }
        return tmpSumResult;
    }


    //Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
