package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;
import com.tegareyn.algorithm.utils.StringUtil;

/**
 * 描述：合并K个排序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author mocheng
 * @version 1.0
 * @see LC23
 * @since 2024/3/1 17:01
 **/
public class LC23 {

    public static void main(String[] args) {
        ListNode listNode1 = StringUtil.string2ListNode("1,4,5");
        ListNode listNode2 = StringUtil.string2ListNode("1,3,4");
        ListNode listNode3 = StringUtil.string2ListNode("2,6");
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 0) {
            return null;
        }
        ListNode list1 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list1 = mergeKLists(list1, lists[i]);
        }
        return list1;
    }

    public static ListNode mergeKLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        merge(root, list1, list2);
        return root.next;
    }

    private static void merge(ListNode root, ListNode list1, ListNode list2) {
        if (list1 == null) {
            root.next = list2;
        } else if (list2 == null) {
            root.next = list1;
        } else {
            if (list1.val <= list2.val) {
                root.next = list1;
                merge(root.next, list1.next, list2);
            } else {
                root.next = list2;
                merge(root.next, list1, list2.next);
            }
        }
    }

}
