package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：翻转二叉树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/30 17:58
 **/
public class LC226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution(root));
    }

    public static TreeNode solution(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                TreeNode item = queue.poll();
                if (item == null) {
                    continue;
                }
                length--;
                TreeNode left = item.left;
                TreeNode right = item.right;
                if (left != null) {
                    queue.offer(left);
                    item.right = left;
                } else {
                    item.right = null;
                }
                if (right != null) {
                    queue.offer(right);
                    item.left = right;
                } else {
                    item.left = null;
                }
            }
        }
        return root;
    }

}
