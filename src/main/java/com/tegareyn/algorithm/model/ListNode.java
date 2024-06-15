package com.tegareyn.algorithm.model;

/**
 * @ClassName ListNode
 * @Description leetcode 链表定义
 * @Author mocheng
 * @Since 2022/11/18 17:42
 * @Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node!=null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}
