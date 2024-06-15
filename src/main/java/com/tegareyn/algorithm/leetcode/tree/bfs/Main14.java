package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Main
 * @Description 合并二叉树
 * @Author mocheng
 * @Since 2022/11/26 22:28
 * @Version 1.0
 **/
public class Main14 {

    public static TreeNode mergeTreesBfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(),
                    node1 = queue1.poll(),
                    node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left,
                    right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }

    public static TreeNode mergeTreesDfs(TreeNode t1, TreeNode t2) {
        TreeNode node = new TreeNode();
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            node = t2;
        } else if (t2 == null) {
            node = t1;
        } else {
            node.val = t1.val + t2.val;
            node.left = mergeTreesDfs(t1.left, t2.left);
            node.right = mergeTreesDfs(t1.right, t2.right);
        }
        return node;
    }


    public static TreeNode mergeTreesDfs2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTreesDfs2(t1.left, t2.left);
        t1.right = mergeTreesDfs2(t1.right, t2.right);
        return t1;
    }
}
