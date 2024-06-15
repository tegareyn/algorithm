package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;

/**
 * @Description 删除链表倒数第n个节点
 * @Author mocheng
 * @Since 2022/11/18 18:01
 * @Version 1.0
 **/
public class Main9 {

    public static void main(String[] args) {
        int i = 1;
        ListNode node = new ListNode(i);
        ListNode tmp = node;
        while(i < 10) {
            i ++;
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        node = removeNthFromEnd(node, 9);
        System.out.println(node);
    }

    // 1。额外数组 2。栈
    // 3。双指针：快指针比慢指针多移动n个位置；当快指针移动到末尾，慢指针就是需要删除的节点
    // （当原始链表长度为n时，双指针这种方式需要，添加一个虚拟节点，否则第一个节点不能删除）
    public static ListNode removeNthFromEnd(ListNode node, int n) {
        ListNode pre = new ListNode();
        pre.next = node; // 预置节点
        ListNode s = pre;
        ListNode f = pre;
        while(n-- >0) {
            if (f.next == null) {
                return new ListNode(-1);
            }
            f = f.next;
        }
        // 同步移动两个指针
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        // s.next是待删除的节点
        ListNode removedNode = s.next;
        s.next = removedNode.next;
        // 删除预置节点
        pre = pre.next;
        return pre;
    }

}
