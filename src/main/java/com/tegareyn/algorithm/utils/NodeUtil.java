package com.tegareyn.algorithm.utils;

import com.tegareyn.algorithm.model.ListNode;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see NodeUtil
 * @since 2024/1/22 11:13
 **/
public class NodeUtil {

    public static void main(String[] args) {
        System.out.println(build(new int[]{2,3,4,5}));
    }

    public static ListNode build(int[] array) {
        ListNode root = new ListNode();
        ListNode pre = root;
        for (int num : array){
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return root.next;
    }
}
