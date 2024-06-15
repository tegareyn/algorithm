package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;

/**
 * @Ref LC21
 * @Description 合并两个有序链表
 * @Author Spindrift
 * @Since 2022/11/29 22:21
 * @Version 1.0
 **/
public class LC21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        merge2Lists(res, list1, list2);
       return res.next;
    }

    public static void merge2Lists(ListNode res, ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return;
        } else if (list1 == null) {
            res.next = list2;
        } else if (list2 == null){
            res.next = list1;
        } else {
            if (list1.val <= list2.val) {
                res.next = list1;
                merge2Lists(list1, list1.next, list2);
            } else {
                res.next = list2;
                merge2Lists(list2, list1, list2.next);
            }
        }
    }
}
