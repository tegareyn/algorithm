package com.tegareyn.algorithm.leetcode.list;

import com.tegareyn.algorithm.model.ListNode;

/**
 * @ClassName Main8
 * @Description 寻找链表中间节点
 * @Author mocheng
 * @Since 2022/11/18 17:44
 * @Version 1.0
 **/
public class Main8 {

    // 1。全量遍历一圈，得到链表长度n；再重新遍历一边找到n/2 + 1
    // 2。双指针：慢指针每次移动一格，快指针移动两格；当快指针移动到末尾时，慢指针则停留在中间位置
    public static ListNode middleNode(ListNode node) {
        ListNode s = node;
        ListNode f = node;
        while (s.next != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == null) {
                break;
            }
        }
        return s;
    }

}
