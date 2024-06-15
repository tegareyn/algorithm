package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：左叶子之和
 * 计算给定二叉树的所有左叶子之和
 * @author mocheng
 * @version 1.0
 * @see LC404
 * @since 2023/12/25 12:01
 **/
public class LC404 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{1,2});
        System.out.println(solution1(root));
    }
    public static int solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        // 非叶节点
        dfs1(root, result);
        return result.stream().mapToInt(x -> x).sum();
    }

    // 叶节点+左子节点
    public static void dfs1(TreeNode parent, List<Integer> result) {
        if (parent.left != null && parent.left.left == null && parent.left.right == null) {
            // 左子节点
            result.add(parent.left.val);
        }
        if (parent.left != null) {
            dfs1(parent.left, result);
        }
        if (parent.right != null) {
            dfs1(parent.right, result);
        }
    }

    static int result = 0;
    public static int solution1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        // 非叶节点
        dfs(root);
        return result;
    }

    // 叶节点+左子节点
    public static void dfs(TreeNode parent) {
        if (parent.left != null && parent.left.left == null && parent.left.right == null) {
            // 左子节点
            result += parent.left.val;
        }
        if (parent.left != null) {
            dfs(parent.left);
        }
        if (parent.right != null) {
            dfs(parent.right);
        }
    }
}
