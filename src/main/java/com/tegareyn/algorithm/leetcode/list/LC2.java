package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;
import com.tegareyn.algorithm.utils.NodeUtil;

/**
 * 描述：两数之和
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * @author mocheng
 * @version 1.0
 * @see LC2
 * @since 2024/1/22 10:51
 **/
public class LC2 {

    public static void main(String[] args) {
        ListNode node1 = NodeUtil.build(new int[]{9,9,9,9,9,9,9});
        ListNode node2 = NodeUtil.build(new int[]{9,9,9,9});
        System.out.println(solution(node1, node2));
        System.out.println(solution1(node1, node2));
    }

    public static ListNode solution(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode();
        resolve(pre, node1, node2, 0);
        return pre.next;
    }

    public static void resolve(ListNode prev, ListNode node1, ListNode node2, int carry) {
        int v;
        if (node1 != null && node2 != null) {
            v = node1.val + node2.val + carry;
        } else if (node1 != null) {
            v = node1.val + carry;
        } else if (node2 != null){
            v = node2.val + carry;
        } else if (carry > 0){
            v = carry;
        } else {
            return;
        }
        carry = v / 10;
        v = v % 10;
        prev.next = new ListNode(v);
        resolve(prev.next, node1 == null ? null : node1.next, node2 == null ? null : node2.next, carry);
    }

    public static ListNode solution1(ListNode node1, ListNode node2) {
        ListNode root = new ListNode();
        ListNode pre = root;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int x = node1 == null ? 0 : node1.val;
            int y = node2 == null ? 0 : node2.val;
            int v = x + y + carry;
            carry = v / 10;
            pre.next = new ListNode(v % 10);
            pre = pre.next;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return root.next;
    }
}
