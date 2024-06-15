package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 描述：二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 * @author mocheng
 * @version 1.0
 * @see LC530
 * @since 2024/1/2 18:48
 **/
public class LC530 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.buildBinaryTree(new Integer[]{543,384,652,null,445,null,699});
        System.out.println(solution(tree));
        solution1(tree);
        System.out.println(min);
    }

    public static int solution(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        resolve(root, queue);
        if (queue.size() <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Integer node = queue.poll();
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            min = Math.min(min, poll - node);
            node = poll;
        }
        return min;
    }

    public static void resolve(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            resolve(node.left, queue);
        }
        queue.add(node.val);
        if (node.right != null) {
            resolve(node.right, queue);
        }
    }

    static int pre = -1;
    static int min = Integer.MAX_VALUE;
    public static void solution1(TreeNode root) {
        if (root == null) {
            return;
        }
        solution1(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        solution1(root.right);
    }
}
