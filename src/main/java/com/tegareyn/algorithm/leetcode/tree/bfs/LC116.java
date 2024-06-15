package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.SpecialTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Ref LC116
 * @Description 完美二叉树: 填充每个节点的下一个右侧节点指针
 * @Author Spindrift
 * @Since 2022/11/28 00:05
 * @Version 1.0
 **/
public class LC116 {

    public static void main(String[] args) {
        SpecialTree perfect = new SpecialTree(8);
        perfect.left = new SpecialTree(7);
        perfect.right = new SpecialTree(9);
        System.out.println(connect(perfect));
    }

    public static SpecialTree connect(SpecialTree node) {
        if (node == null) {
            return null;
        }
        Queue<SpecialTree> queue = new LinkedList<>();
        queue.offer(node);
        connectQueue(queue);
        return node;
    }

    private static void connectQueue(Queue<SpecialTree> queue) {
        Queue<SpecialTree> queueN = new LinkedList<>();
        if (!queue.isEmpty()) {
            SpecialTree pre = queue.poll();
            if (pre.left != null) {
                queueN.offer(pre.left);
            }
            if (pre.right != null) {
                queueN.offer(pre.right);
            }
            while (!queue.isEmpty()) {
                SpecialTree next = queue.poll();
                pre.next = next;
                if (next.left != null) {
                    queueN.offer(next.left);
                }
                if (next.right != null) {
                    queueN.offer(next.right);
                }
                pre = next;
            }
        }
        if (!queueN.isEmpty()) {
            connectQueue(queueN);
        }
    }
}
