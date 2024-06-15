package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.LinkedList;

/**
 * 描述：完全二叉树的节点树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/10 10:27
 **/
public class LC222_2 {
    public static void main(String[] args) {

    }

    public static int solution(TreeNode root) {
        LinkedList<TreeNode> result = new LinkedList<>();
        dfs(root, result);
        return result.size();
    }

    public static void dfs(TreeNode root, LinkedList<TreeNode> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        result.offer(root);
        dfs(root.right, result);
    }
}
